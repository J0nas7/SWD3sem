package com.crm.demo.service;

import com.crm.demo.model.Contact;
import com.crm.demo.model.Note;
import com.crm.demo.repository.IContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.crm.demo.controller.CRMXController.DBconn;

@Service
public class ContactServiceImpl implements IContactService {

    private List<Note> notesList = new ArrayList<>();

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

    // Notes implementation
    public int getNotesListSize() {
        return notesList.size();
    }

    @Override
    public void createNote(Note n) throws SQLException {
        String insertSql = "INSERT INTO "+DBconn.DBprefix+"Notes (Note_Subject, Note_Content, Note_Customer_fk, Note_Timestamp, Note_Status) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pStatement = DBconn.DBconnect.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
        pStatement.setString(1, n.getNote_Subject());
        pStatement.setString(2, n.getNote_Content());
        pStatement.setInt(3, n.getNote_Customer_fk());
        pStatement.setInt(4, n.getNote_Timestamp());
        pStatement.setInt(5, n.getNote_Status());
        DBconn.statementUpdate(pStatement);
        ResultSet rs = pStatement.getGeneratedKeys();
        int last_inserted_id = 0;
        if (rs.next()) {
            last_inserted_id = rs.getInt(1);
        }

        this.notesList.add(new Note(last_inserted_id, this.getNotesListSize()+1, n.getNote_Subject(), n.getNote_Content(), n.getNote_Customer_fk(), n.getNote_Timestamp(), n.getNote_Status()));
    }

    @Override
    public void editNote(Note n) throws SQLException {
        //Note tempNote = notesList.get(n.getNote_AL_index()-1);
        this.notesList.set(n.getNote_AL_index()-1, n);

        String updateSql = "UPDATE "+DBconn.DBprefix+"Notes SET Note_Subject=?, Note_Content=?, Note_Customer_fk=?, Note_Timestamp=?, Note_Status=? WHERE Note_ID=?";
        PreparedStatement pStatement = DBconn.DBconnect.prepareStatement(updateSql);
        pStatement.setString(1, n.getNote_Subject());
        pStatement.setString(2, n.getNote_Content());
        pStatement.setInt(3, n.getNote_Customer_fk());
        pStatement.setInt(4, n.getNote_Timestamp());
        pStatement.setInt(5, n.getNote_Status());
        pStatement.setInt(6, n.getNote_ID());
        DBconn.statementUpdate(pStatement);
    }
}
