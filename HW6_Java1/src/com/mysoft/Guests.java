package com.mysoft;

/**
 * Created by shcheki on 20.03.2015.
 */
public class Guests {
    private String firstname;
    private String lastname;
    private String textComment;
    private String useremail;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getTextComment() {
        return textComment;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }
}
