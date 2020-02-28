package com.microservice.search.validation;

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

   public boolean isPasswordValid (String password) {

         /*
    *    ^                 # start-of-string
        (?=.*[0-9])       # a digit must occur at least once
        (?=.*[a-z])       # a lower case letter must occur at least once
        (?=.*[A-Z])       # an upper case letter must occur at least once
        (?=.*[@#$%^&+=])  # a special character must occur at least once
        (?=\S+$)          # no whitespace allowed in the entire string
        .{15,}             # anything, at least eight places though
        $                 # end-of-string
    * */

       final String emailRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{15,}$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(password);

        if(matcher.find()){
            System.out.println("ISPRAVAN PASS");
            return true;
        }
       System.out.println("NEISPRAVAN PASS");
        return false;

   }

   public boolean isNameValid (String name) {

        final String nameRegex = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,20}$";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(name);

        if(matcher.find()){
            System.out.println("ISPRAVAN NAME/LASTNAME");
            return true;
        }
       System.out.println("NEISPRAVAN NAME/LASTAME");
        return false;
   }





    public boolean isAddressValid (String name) {

        final String nameRegex = "(?:[A-Z][a-z.-]+[ ]?)+";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(name);

        if(matcher.find()){
       //     System.out.println("ISPRAVAN NAME/LASTNAME");
            return true;
        }
  //      System.out.println("NEISPRAVAN NAME/LASTAME");
        return false;
    }

    public boolean isStreetNumberValid (String name) {

        final String nameRegex = "((\\d{1,6}\\-\\d{1,6})|(\\d{1,6}\\\\\\d{1,6})|(\\d{1,6})(\\/)(\\d{1,6})|(\\w{1}\\-?\\d{1,6})|(\\w{1}\\s\\d{1,6})|((P\\.?O\\.?\\s)((BOX)|(Box))(\\s\\d{1,6}))|((([R]{2})|([H][C]))(\\s\\d{1,6}\\s)((BOX)|(Box))(\\s\\d{1,6}))?)$";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(name);

        if(matcher.find()){
            //     System.out.println("ISPRAVAN NAME/LASTNAME");
            return true;
        }
        //      System.out.println("NEISPRAVAN NAME/LASTAME");
        return false;
    }


    public boolean isLongitudeAndLatitudeValid (double name) {

        String name1 = Double.toString(name);
        final String nameRegex = "[-+]?([0-9]*\\.[0-9]+|[0-9]+)";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(name1);

        if(matcher.find()){
            //     System.out.println("ISPRAVAN NAME/LASTNAME");
            return true;
        }
        //      System.out.println("NEISPRAVAN NAME/LASTAME");
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




    public boolean isContentValid (String name) {

        final String nameRegex = "^\\d{4}-\\d{2}-\\d{2}$";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(name);

        if(matcher.find()){
            //     System.out.println("ISPRAVAN NAME/LASTNAME");
            return true;
        }
        //      System.out.println("NEISPRAVAN NAME/LASTAME");
        return false;
    }

    public boolean isDateValid (Date date) {

        String sdate = date.toString();
        final String nameRegex = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,50}$";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(sdate);

        if(matcher.find()){
            //     System.out.println("ISPRAVAN NAME/LASTNAME");
            return true;
        }
        //      System.out.println("NEISPRAVAN NAME/LASTAME");
        return false;
    }

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
