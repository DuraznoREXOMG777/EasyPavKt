package com.highflyers.commonresources.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AppDateFormatterUtility {

    private AppDateFormatterUtility(){}

    public static String getFullDateFormatted(Date date){
        if(date == null)
            return "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd 'de' MMMM 'de' yyyy");
        return dateFormat.format(date);
    }

    public static String getFullDateFormatted(String date){
        Date date1 = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date1 = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd 'de' MMMM 'de' yyyy");
        /*try {
            if(date != null)
                date1 = dateFormat.parse(date);
        } catch (ParseException e) {
            return "null";
        }*/
        return date1.toString();
    }

    public static String getShortDate(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return(getShortDate(dateFormat.parse(date))) ;
        } catch (ParseException e) {
            return "null";
        } catch (NullPointerException ex){
            return "null";
        }
    }

    public static String getShortDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

    public static String getAPIDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMdd");
        return dateFormat.format(date);
    }

    public static String getEmailDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        return dateFormat.format(date);
    }

    public static String getNotificationDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd 'de' MMM 'de' yyyy h:mm a");
        return dateFormat.format(date);
    }

    public static String getCreditNameFormat() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd-HHmm");
        return dateFormat.format(new Date());
    }

    public static Date convertToDate(String format, String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try{
            return simpleDateFormat.parse(date);
        }catch(ParseException ex){
            return convertToDate(date);
        }
    }

    public static Date convertToDate(String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss zzz yyyy", Locale.US);
        try{
            return simpleDateFormat.parse(date);
        }catch(ParseException ex){
            return null;
        }
    }
}
