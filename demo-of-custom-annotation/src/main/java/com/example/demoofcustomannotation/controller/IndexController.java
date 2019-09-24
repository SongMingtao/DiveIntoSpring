package com.example.demoofcustomannotation.controller;

import com.example.demoofcustomannotation.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    @Qualifier("PersonService")
    private PersonService personService;
    @GetMapping("/index")
    @ResponseBody
    public String hello(){
        return personService.getName();
    }
}
