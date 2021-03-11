package com.example.addressexam;

public class Address {

    private String name;
    private String phone_num;
    private String e_mail;

    public Address(String name,String phone_num, String e_mail) {

        this.name = name;
        this.phone_num = phone_num;
        this.e_mail = e_mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }
}
