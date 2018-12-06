package com.crm.demo.model;

public class Note {
    private int Note_ID;
    private int Note_AL_index;
    private String Note_Subject;
    private String Note_Content;
    private int Note_Customer_fk;
    private String Note_Timestamp;
    private int Note_Status;

    public Note() {
    }

    public Note(int note_ID, int note_AL_index, String note_Subject, String note_Content, int note_Customer_fk, String note_Timestamp, int note_Status) {
        Note_ID = note_ID;
        Note_AL_index = note_AL_index;
        Note_Subject = note_Subject;
        Note_Content = note_Content;
        Note_Customer_fk = note_Customer_fk;
        Note_Timestamp = note_Timestamp;
        Note_Status = note_Status;
    }

    public int getNote_ID() {
        return Note_ID;
    }

    public void setNote_ID(int note_ID) {
        Note_ID = note_ID;
    }

    public int getNote_AL_index() {
        return Note_AL_index;
    }

    public void setNote_AL_index(int note_AL_index) {
        Note_AL_index = note_AL_index;
    }

    public String getNote_Subject() {
        return Note_Subject;
    }

    public void setNote_Subject(String note_Subject) {
        Note_Subject = note_Subject;
    }

    public String getNote_Content() {
        return Note_Content;
    }

    public void setNote_Content(String note_Content) {
        Note_Content = note_Content;
    }

    public int getNote_Customer_fk() {
        return Note_Customer_fk;
    }

    public void setNote_Customer_fk(int note_Customer_fk) {
        Note_Customer_fk = note_Customer_fk;
    }

    public String getNote_Timestamp() {
        return Note_Timestamp;
    }

    public void setNote_Timestamp(String note_Timestamp) {
        Note_Timestamp = note_Timestamp;
    }

    public int getNote_Status() {
        return Note_Status;
    }

    public void setNote_Status(int note_Status) {
        Note_Status = note_Status;
    }

    @Override
    public String toString() {
        return "Note{" +
                "Note_ID=" + Note_ID +
                ", Note_Subject='" + Note_Subject + '\'' +
                ", Note_Content='" + Note_Content + '\'' +
                ", Note_Customer_fk=" + Note_Customer_fk +
                ", Note_Timestamp=" + Note_Timestamp +
                ", Note_Status=" + Note_Status +
                '}';
    }
}
