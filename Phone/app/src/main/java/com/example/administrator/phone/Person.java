package com.example.administrator.phone;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2017-05-15.
 */


public class Person {
    private Drawable iconDrawable;
    private String name;
    private String number;
    private String email;
    private String company;

    public void setIcon(Drawable icon){
        iconDrawable=icon;
    }
    public void setName(String str){
        name=str;
    }
    public void setNumber(String str){
        number=str;
    }
    public void setEmail(String str){
        email=str;
    }
    public void setCompany(String str){
        company=str;
    }

    public Drawable getIcon(){
        return this.iconDrawable;
    }
    public String getName(){
        return this.name;
    }
    public String getNumber(){
        return this.number;
    }
    public String getEmail(){
        return this.email;
    }
    public String getCompany(){
        return this.company;
    }
}

