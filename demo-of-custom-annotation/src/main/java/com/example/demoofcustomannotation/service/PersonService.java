package com.example.demoofcustomannotation.service;

import com.example.demoofcustomannotation.annotation.MyRPC;

@MyRPC(name = "PersonService")
public class PersonService {
    public String getName(){
        return "personNamessssss";
    }
}
