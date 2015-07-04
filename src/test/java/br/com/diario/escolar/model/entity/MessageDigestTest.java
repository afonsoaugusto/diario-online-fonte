/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diario.escolar.model.entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AFONSO
 */
public class MessageDigestTest {
    public static void main(String[] args) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update("texto".getBytes());
            byte[] hash = md.digest();
            System.out.println(hash);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MessageDigestTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
