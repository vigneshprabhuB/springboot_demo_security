package com.vignesh.gAppEngineTryy.controllers;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class User{

@GetMapping(value = "/getTime")
public String getCurrentTime(){

    return new Date().toGMTString();  
} 


@PostMapping(value = "/saveUser") 
public String saveUser(){

    return "userSaved...";  
} 




}