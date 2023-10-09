package com.project.someschool.service;


import com.project.someschool.constants.SomeSchoolConstants;
import com.project.someschool.model.Contact;
import com.project.someschool.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactsMsgs = contactRepository.findByStatus(SomeSchoolConstants.OPEN);
        return contactsMsgs;
    }

    public boolean updateMsgStatus(int contactId){
        boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(contactId);
        contact.ifPresent(contact1 -> {
            contact1.setStatus(SomeSchoolConstants.CLOSE);
        });
        Contact updatedContact = contactRepository.save(contact.get());
        if(null != updatedContact && updatedContact.getUpdatedBy()!=null) {
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
