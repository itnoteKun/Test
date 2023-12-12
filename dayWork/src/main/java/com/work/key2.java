package com.work;

public class key2 {

    private String name="admin";
    public int password=111111;


    public boolean setnam(String name){
        if(name == "admin"){

            return false;
        }else {
            return true;
        }
    }
    public boolean setPassword(int password){
        if(password != this.password){

            return true;
        }else return false;
    }

    public void getPassword(int password) {
        this.password = password;

    }
}
