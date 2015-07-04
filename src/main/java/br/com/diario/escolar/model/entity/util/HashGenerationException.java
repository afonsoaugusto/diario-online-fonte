/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diario.escolar.model.entity.util;

/**
 *
 * @author AFONSO
 */
public class HashGenerationException extends Exception {

    public HashGenerationException(String could_not_generate_hash_from_String, java.lang.Exception ex) {
        super(could_not_generate_hash_from_String, ex);
    }
   
}
