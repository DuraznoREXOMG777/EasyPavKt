package com.highflyers.commonresources.utils;

import java.util.Random;

public class AppPasswordGenerator {

    public static String generateUserPassword(){
        return generateRandomPassword(7, true, true, true, false);
    }

    private static String generateRandomPassword(int maxLength, boolean upperCase, boolean lowerCase, boolean numbers, boolean specialCharacters) {
        String upperCaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseChars = "abcdefghijklmnopqrstuvwxyz";
        String numberChars = "0123456789";
        String specialChars = "!@#$%^&*()_-+=<>?/{}~|";
        String allowedChars = "";

        Random rn = new Random();
        StringBuilder sb = new StringBuilder(maxLength);

        //this will fulfill the requirements of atleast one character of a contentType.
        if(upperCase) {
            allowedChars += upperCaseChars;
            sb.append(upperCaseChars.charAt(rn.nextInt(upperCaseChars.length()-1)));
        }

        if(lowerCase) {
            allowedChars += lowerCaseChars;
            sb.append(lowerCaseChars.charAt(rn.nextInt(lowerCaseChars.length()-1)));
        }

        if(numbers) {
            allowedChars += numberChars;
            sb.append(numberChars.charAt(rn.nextInt(numberChars.length()-1)));
        }

        if(specialCharacters) {
            allowedChars += specialChars;
            sb.append(specialChars.charAt(rn.nextInt(specialChars.length()-1)));
        }
        //fill the allowed length from different chars now.
        for(int i=sb.length();i < maxLength;++i){
            sb.append(allowedChars.charAt(rn.nextInt(allowedChars.length())));
        }

        return  sb.toString();
    }
}
