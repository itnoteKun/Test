package com.work;

public class getAdmin {
    public static void main(String[] args) {
        Admin ad = new Admin();
        ad.setName("admin1");
        ad.setPassword(111111);
        ad.getName();
        ad.getPassword();
        ad.setName("admin2");
        ad.setPassword(222222);
        ad.getName();
        ad.getPassword();
    }

}
