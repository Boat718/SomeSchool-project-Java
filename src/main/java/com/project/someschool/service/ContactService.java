package com.project.someschool.service;


import com.project.someschool.model.Contact;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = true;
        System.out.println(contact.toString());
        return isSaved;
    }

}
