package com.mysoft;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shcheki on 20.03.2015.
 */
public class DB {
    public static List<Guests> getGuests(){
        ArrayList<Guests> Guests =new ArrayList<Guests>();
        Guests e =new Guests();
        e.setFirstname("John");
        e.setLastname("Bekerly");
        e.setUseremail("johnbekkerly@gmail.com");
        Guests.add(e);

        Guests e1 =new Guests();
        e1.setFirstname("Mathew");
        e1.setLastname("Errowbought");
        e1.setUseremail("mathew123@gmail.com");
        Guests.add(e1);
        return Guests;
    }
    public static List<Guests> setGuests( String firstname, String secondname, String Useremail, String textComment){
        ArrayList<Guests> Guests =new ArrayList<Guests>();
        Guests e =new Guests();
        e.setFirstname(firstname);
        e.setLastname(secondname);
        e.setUseremail(Useremail);
        e.setUseremail(textComment);
        Guests.add(e);
        return Guests;
    }
}
