package com.microservice.reservation.validation;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {


    public RegularExpressions() {

    }

    public boolean isEmailValid(String emailAddress) {

        final String mailRegex = "^([\\w-!#$%&'.*+=?^_`{|}~]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([A-Za-z]{2,12}(?:\\.[A-Za-z]{2})?)$";
        Pattern pattern = Pattern.compile(mailRegex);
        Matcher matcher = pattern.matcher(emailAddress);

        if (matcher.find()) {
            System.out.println("ISPRAVAN EMAIL");
            return true;
        }
        System.out.println("NEISPRAVAN EMAIL");
        return false;
    }



    public boolean isNumberValid (int name) {

        String i = Integer.toString(name);
        final String nameRegex = "^[0-9]{1,6}$";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(i);

        if(matcher.find()){
            //     System.out.println("ISPRAVAN NAME/LASTNAME");
            return true;
        }
        //      System.out.println("NEISPRAVAN NAME/LASTAME");
        return false;
    }




//    public boolean isDateValid (Date date) {
//
//        String sdate = date.toString();
//        final String nameRegex = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,50}$";
//        Pattern pattern = Pattern.compile(nameRegex);
//        Matcher matcher = pattern.matcher(sdate);
//
//        if(matcher.find()){
//            //     System.out.println("ISPRAVAN NAME/LASTNAME");
//            return true;
//        }
//        //      System.out.println("NEISPRAVAN NAME/LASTAME");
//        return false;
//    }

    public boolean isDoubleValid (Double name) {
        String dou = Double.toString(name);
        final String nameRegex = "^[-+]?[0-9]*\\.?[0-9]+$";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(dou);

        if(matcher.find()){
            //     System.out.println("ISPRAVAN NAME/LASTNAME");
            return true;
        }
        //      System.out.println("NEISPRAVAN NAME/LASTAME");
        return false;
    }

    public boolean isLongValid (Long name) {

        String lo = Long.toString(name);
        final String nameRegex = "^[1-9]+[0-9]*$";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(lo);

        if(matcher.find()){
            //     System.out.println("ISPRAVAN NAME/LASTNAME");
            return true;
        }
        //      System.out.println("NEISPRAVAN NAME/LASTAME");
        return false;
    }















}
