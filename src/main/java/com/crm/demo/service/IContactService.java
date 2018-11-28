package com.crm.demo.service;

import com.crm.demo.model.Contact;

import java.net.ConnectException;
import java.util.List;

public interface IContactService {

    List<Contact> fetchAllContacts();
    Contact fetchOneContact(int id);
    Contact createContact(Contact c);
    void deleteContact(int id);
    Contact updateContact(Contact c);


}
