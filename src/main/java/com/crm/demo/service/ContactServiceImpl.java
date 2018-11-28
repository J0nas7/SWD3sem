package com.crm.demo.service;

import com.crm.demo.model.Contact;
import com.crm.demo.repository.IContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements IContactService{


    @Autowired
    private IContactRepo contactRepo;


    @Override
    public List<Contact> fetchAllContacts(){
        return contactRepo.findAll();
    }


    @Override
    public Contact fetchOneContact(int id){
        return contactRepo.getOne(id);
    }

    @Override
    public Contact createContact(Contact contact){
        return contactRepo.save(contact);
    }

    @Override
    public void deleteContact(int id){
        contactRepo.deleteById(id);
    }


    @Override
    public Contact updateContact(Contact contact){
        return contactRepo.save(contact);
    }
}
