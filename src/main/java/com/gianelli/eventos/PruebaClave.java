/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gianelli.eventos;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author giane
 */
public class PruebaClave {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("12345"));
    }
}

