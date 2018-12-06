package com.crm.demo.service;

import com.crm.demo.model.Contact;
import com.crm.demo.model.Note;
import com.crm.demo.model.UserInfo;
import com.crm.demo.repository.IContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.crm.demo.controller.CRMXController.DBconn;

@Service
public class ContactServiceImpl implements IContactService {

    public ContactServiceImpl() throws SQLException {
        // Construct Notes:
        this.constructNotes();
    }

    // General Contact implementation
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
    private List<Note> notesList = new ArrayList<>();

    public int getNotesListSize() {
        return notesList.size();
    }

    public void constructNotes() throws SQLException {
        String selectSql = "SELECT * FROM "+DBconn.DBprefix+"Notes WHERE Note_Status=?";
        PreparedStatement pStatement = DBconn.DBconnect.prepareStatement(selectSql);
        pStatement.setInt(1, 1);
        ResultSet notesQuery = DBconn.statementQuery(pStatement);
        while (notesQuery.next()) {
            long timestamp = notesQuery.getLong("Note_Timestamp");
            Date noteDate = new Date();
            noteDate.setTime(timestamp);

            this.notesList.add(new Note(
                    notesQuery.getInt("Note_ID"),
                    this.getNotesListSize()+1,
                    notesQuery.getString("Note_Subject"),
                    notesQuery.getString("Note_Content"),
                    notesQuery.getInt("Note_Customer_fk"),
                    noteDate.toString(),
                    notesQuery.getInt("Note_Status")
            ));
        }
    }

    @Override
    public void createNote(Note n) throws SQLException {
        // Get the current EPOCH timestamp from a Date object
        Date timestamp = new Date();
        n.setNote_Timestamp(timestamp.toString());
        n.setNote_Status(1);

        // Insert the Note to the DB table
        String sql_Note_Timestamp = String.valueOf(timestamp.getTime());
        String insertSql = "INSERT INTO "+DBconn.DBprefix+"Notes (Note_Subject, Note_Content, Note_Customer_fk, Note_Timestamp, Note_Status) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pStatement = DBconn.DBconnect.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
        pStatement.setString(1, n.getNote_Subject());
        pStatement.setString(2, n.getNote_Content());
        pStatement.setInt(3, n.getNote_Customer_fk());
        pStatement.setString(4, sql_Note_Timestamp);
        pStatement.setInt(5, n.getNote_Status());
        DBconn.statementUpdate(pStatement);

        // Get the DB tables last inserted row ID, and add the Note to ArrayList
        ResultSet rs = pStatement.getGeneratedKeys();
        int last_inserted_id = 0;
        if (rs.next()) {
            last_inserted_id = rs.getInt(1);
        }
        n.setNote_ID(last_inserted_id);
        n.setNote_AL_index(getNotesListSize()+1);
        System.out.println(n.toString());

        this.notesList.add(n);
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
        pStatement.setString(4, n.getNote_Timestamp());
        pStatement.setInt(5, n.getNote_Status());
        pStatement.setInt(6, n.getNote_ID());
        DBconn.statementUpdate(pStatement);
    }
}
