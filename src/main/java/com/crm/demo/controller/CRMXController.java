package com.crm.demo.controller;

import com.crm.demo.model.Contact;
import com.crm.demo.model.Note;
import com.crm.demo.model.UserInfo;
import com.crm.demo.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.crm.demo.controller.DatabaseControllerSingleton;

import java.sql.SQLException;

@Controller
public class CRMXController {

    public static DatabaseControllerSingleton DBconn = DatabaseControllerSingleton.GetInstance();

    @Autowired
    IContactService contactService;

    public String UserInfoCheck(String template) {
        if (UserInfo.isLoggedIn) {
            return template;
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/")
    public String index(Model model) {
        if (UserInfo.isLoggedIn) {
            model.addAttribute("contacts", contactService.fetchAllContacts());
            return "/crmforside";
        } else {
            model.addAttribute("loginError", UserInfo.loginError);
            return "/login";
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, String password, Model model){
        System.out.println(username + " " + password);
        boolean login = UserInfo.checkLogin(username, password);
        if (login) {
            System.out.println("Login success");
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        UserInfo.logout();
        return "redirect:/";
    }

    @GetMapping("/custview/{custId}")
    public String custview(@PathVariable("custId") int custId, Model model) {
        model.addAttribute("customer", contactService.fetchOneContact(custId));
        model.addAttribute("numNotes", contactService.readCustNotesSize(custId));
        return UserInfoCheck("/custsingleview");
    }

    @GetMapping("/newnote/{custId}")
    public String newnote(@PathVariable("custId") int custId, Model model) {
        model.addAttribute("customer", contactService.fetchOneContact(custId));
        return UserInfoCheck("/newnote");
    }

    @PostMapping("/newnote/{custId}")
    public String newnote(@PathVariable("custId") int custId, @ModelAttribute Note note, Model model) throws SQLException {
        if (UserInfo.isLoggedIn) {
            note.setNote_Customer_fk(custId);
            contactService.createNote(note);
        }
        return "redirect:/custview/"+custId;
    }

    @GetMapping("/readnotes/{custId}")
    public String readnotes(@PathVariable("custId") int custId, Model model) {
        model.addAttribute("customer", contactService.fetchOneContact(custId));
        model.addAttribute("custNotes", contactService.readCustNotes(custId));
        return UserInfoCheck("/readnotes");
    }

    @GetMapping("/deletenote/{Note_AL_index}")
    public String deleteNote(@PathVariable("Note_AL_index") int Note_AL_index) throws SQLException {
        int CustomerId = 0;
        if (UserInfo.isLoggedIn) {
            CustomerId = contactService.deleteNote(Note_AL_index);
        }
        return "redirect:/readnotes/"+CustomerId;
    }

    @GetMapping("/newContact")
    public String createnew() {
        return UserInfoCheck("/newcontact");
    }

    @PostMapping("/newContact")
    public String createnew(@ModelAttribute Contact contact, Model model) {
        if (UserInfo.isLoggedIn) {
            model.addAttribute("contact", contact);
            contactService.createContact(contact);
            System.out.println("hej");
            System.out.println(contact.getFirstName() + " " + contact.getLastName());
        }
        return "redirect:/";
    }
}
