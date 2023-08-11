package com.poly.utils;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class BcryptPassword {
    public String encrypt(String password) {
    	String encrypted = BCrypt.hashpw(password, BCrypt.gensalt());
       	return encrypted;
    }
    public boolean checkPassword(String origin,String encrypted) {
    	boolean check = BCrypt.checkpw(origin, encrypted);
    	return check;
    }
}
