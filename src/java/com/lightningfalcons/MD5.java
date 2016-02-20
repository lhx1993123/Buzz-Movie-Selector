/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lightningfalcons;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author Lance
 */
public class MD5 {
    
    public static String md5(String input) {
        String md5 = null;
        if (input == null) {
            return null;
        }
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            
            digest.update(input.getBytes(), 0, input.length());
            
            md5 = new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Something went wrong");
        }
        return md5;
    }
}
