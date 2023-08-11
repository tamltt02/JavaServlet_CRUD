package com.example.assignment.utils;

import org.mindrot.jbcrypt.BCrypt;

public class HashUtil {
    public  static String hash(String plain){
        String salt = BCrypt.gensalt();// sinh ra cái salt
        return BCrypt.hashpw(plain,salt);//trọn pass vs slat và băm ra
    }

    public static boolean verify(String plain, String hashed){

        return BCrypt.checkpw(plain,hashed);
    }
}
