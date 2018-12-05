package com.crm.demo.controller;

import com.crm.demo.model.Contact;
import com.crm.demo.model.UserInfo;
import com.crm.demo.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.crm.demo.controller.DatabaseControllerSingleton;

@Controller
public class CRMXController {

    public static DatabaseControllerSingleton DBconn = DatabaseControllerSingleton.GetInstance();

    @Autowired
    IContactService contactService;

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

    @GetMapping("/logout")
    public String logout() {
        UserInfo.logout();
        return "redirect:/";
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

    @PostMapping("/newContact")
    public String createnew(@ModelAttribute Contact contact, Model model){
        model.addAttribute("contact", contact);
        contactService.createContact(contact);
        System.out.println("hej");
        System.out.println(contact.getFirstName() + " " + contact.getLastName());
        return "redirect:/";
    }

//    @GetMapping("/newContact")
//    public String createnew(@ModelAttribute Contact contact, Model model){
//            model.addAttribute("contact", contact);
//        return "newcontact";
//    }




}
