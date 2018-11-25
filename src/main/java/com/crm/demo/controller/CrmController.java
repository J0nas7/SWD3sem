package com.crm.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class CrmController {

    @GetMapping("/")
    public String login(){


        return "login/crmforside";
    }
}
