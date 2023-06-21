package ir.gambaloo.module;

import java.io.Serializable;

public class User implements Serializable {
    private String emailAddress;
    private String username;
    private String password;
    private String phoneNumber;
    private  String address;
    private double balance;

    public void setCart ( Cart cart ) {
        this.cart = cart;
    }

    private  Cart cart;

    public void setBalance ( double balance ) {
        this.balance = balance;
    }

    public User( String emailAddress, String username, String password, String phoneNumber, String address) {
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address=address;
        cart=new Cart();
    }

    public double getBalance() {
        return balance;
    }

    public Cart getCart() {
        return cart;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getAddress() { return address;}

}
