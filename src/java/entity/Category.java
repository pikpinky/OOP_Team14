/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class Category {
    private int cid;
    private String cname;

    public Category(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public int getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    @Override
    public String toString() {
        return "Category{" + "cid=" + cid + ", cname=" + cname + '}';
    }
    
    
}
