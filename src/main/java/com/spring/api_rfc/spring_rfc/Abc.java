package com.spring.api_rfc.spring_rfc;


/*
IntelliJ IDEA 2022.3.1 (Ultimated Edition)
Build #IC-223.8214.52, built on December 20, 2022
@Author user a.k.a. Muhamad Saripudin
Java Developer
Created on 17/10/2024 12:58
@Last Modified 17/10/2024 12:58
Version 1.0
*/


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Abc {

    public static void main(String[] args) {

        BCryptPasswordEncoder a = new BCryptPasswordEncoder();
//        System.out.println(a.matches("D6180209a","0cc175b9c0f1b6a831c399e269772661"));
        System.out.println(a.encode("a"));
//        0cc175b9c0f1b6a831c399e269772661
    }
}
