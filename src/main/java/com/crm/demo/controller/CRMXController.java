package com.crm.demo.controller;

import com.crm.demo.model.Contact;
import com.crm.demo.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CRMXController {

    @Autowired
    IContactService contactService;

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, String password, Model model){
        Boolean login = false;

        System.out.println(username + " " + password);
        if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("1234")){
            System.out.println("Login success");
            return "redirect:/crmforside";
        }
        else
        {
            return "/login";
        }
    }

    @GetMapping("/crmforside")
    public String crmforside(Model model){
        model.addAttribute("contacts", contactService.fetchAllContacts());

        return "/crmforside";
    }

    @PostMapping("/newContact")
    public String createnew(@ModelAttribute Contact contact, Model model){
        model.addAttribute("contact", contact);
        contactService.createContact(contact);
        System.out.println("hej");
        System.out.println(contact.getFirstName() + " " + contact.getLastName());
        return "redirect:/crmforside";
    }

//    @GetMapping("/newContact")
//    public String createnew(@ModelAttribute Contact contact, Model model){
//            model.addAttribute("contact", contact);
//        return "newcontact";
//    }




}
