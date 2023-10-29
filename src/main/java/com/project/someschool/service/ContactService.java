package com.project.someschool.service;


import com.project.someschool.config.SomeSchoolProps;
import com.project.someschool.constants.SomeSchoolConstants;
import com.project.someschool.model.Contact;
import com.project.someschool.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    SomeSchoolProps someSchoolProps;

    public Page<Contact> findMsgsWithOpenStatus(int pageNum, String sortField, String sortDir){
        int pageSize = someSchoolProps.getPageSize();
        if(null!=someSchoolProps.getContact() && null!=someSchoolProps.getContact().get("pageSize")){
            pageSize = Integer.parseInt(someSchoolProps.getContact().get("pageSize").trim());
        }
        org.springframework.data.domain.Pageable pageable =  PageRequest.of(pageNum-1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending():
                Sort.by(sortField).descending());
        Page<Contact> msgPage = contactRepository.findByStatus(
                SomeSchoolConstants.OPEN,pageable);
        return msgPage;
    }

    public boolean updateMsgStatus(int contactId){
        boolean isUpdated = false;
        int row = contactRepository.updateStatusById(SomeSchoolConstants.CLOSE, contactId);
        if(row > 0) {
            isUpdated = true;
        }
        return isUpdated;
    }

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = false;
        contact.setStatus(SomeSchoolConstants.OPEN);
        Contact savedContact = contactRepository.save(contact);
        if(null != savedContact && savedContact.getContactId()>0) {
            isSaved= true;
        }
        return isSaved;
    }

}
