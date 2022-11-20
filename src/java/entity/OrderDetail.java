/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class OrderDetail {
    private int oID;
    private int pID;
    private String user;
    private int quantity;
    private int status;
    private String name;
    private String image;
    private int price;
    private int sellID;

    public OrderDetail(int oID, int pID, int quantity, int status, String name, String image, int price, int sellID) {
        this.oID = oID;
        this.pID = pID;
        this.quantity = quantity;
        this.status = status;
        this.name = name;
        this.image = image;
        this.price = price;
        this.sellID = sellID;
    }

    
    public OrderDetail(int oID, int pID, int quantity, int status, String name, String image, int price, int sellID, String user) {
        this.oID = oID;
        this.pID = pID;
        this.user = user;
        this.quantity = quantity;
        this.status = status;
        this.name = name;
        this.image = image;
        this.price = price;
        this.sellID = sellID;
    }

    public String getUser() {
        return user;
    }

    public int getoID() {
        return oID;
    }

    public int getpID() {
        return pID;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getPrice() {
        return price;
    }

    public int getSellID() {
        return sellID;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "oID=" + oID + ", pID=" + pID + ", quantity=" + quantity + ", status=" + status + ", name=" + name + ", image=" + image + ", price=" + price + ", sellID=" + sellID + '}';
    }
}
