package com.example.addressbook;

public class Address {
    // Member Variable
    private String name;
    private String phone;
    private String email;

    // constructor Method

    public Address(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Getter/setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //custom method
    public String getInfo() {
        return this.name + "-" + this.phone + "-" + this.email;
    }

}
