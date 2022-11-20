/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class Account {
    private int id;
    private String user;
    private String pass;
    private int isSeller;
    private String phone;
    private String address;

    public Account(int id, String user, String pass, int isSeller, String phone, String address) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.isSeller = isSeller;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public int getIsSeller() {
        return isSeller;
    }

    public String getPhone() {
        return phone;
    }
    
    public String getAddress(){
        return address;
    }
    
}
