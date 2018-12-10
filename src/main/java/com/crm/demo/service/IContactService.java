package com.crm.demo.service;

import com.crm.demo.model.Contact;
import com.crm.demo.model.Note;

import java.net.ConnectException;
import java.sql.SQLException;
import java.util.List;

public interface IContactService {

    List<Contact> fetchAllContacts();
    Contact fetchOneContact(int id);
    Contact createContact(Contact c);
    void deleteContact(int id);
    Contact updateContact(Contact c);

    // Notes implementation
    void createNote(Note n) throws SQLException;
    Note readNote(int NoteListIndex);
    List readCustNotes(int CustomerID);
    int readCustNotesSize(int CustomerID);
    void editNote(Note n) throws SQLException;
    int deleteNote(int NoteID) throws SQLException;


}
