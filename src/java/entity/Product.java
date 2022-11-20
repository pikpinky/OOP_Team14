/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class Product {
    private int id;
    private String name;
    private String image;
    private int price;
    private String title;
    private String description;
    private int cateID;
    private int sellID;

    public Product() {
    }

    public Product(int id, String name, String image, int price, String title, String description, int cateID, int sellID) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.title = title;
        this.description = description;
        this.cateID = cateID;
        this.sellID = sellID;
    }

    public Product(String name, String image, int price, String title, String description, int cateID, int sellID) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.title = title;
        this.description = description;
        this.cateID = cateID;
        this.sellID = sellID;
    }
    
    
    

    public int getId() {
        return id;
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

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCateID() {
        return cateID;
    }

    public int getSellID() {
        return sellID;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", title=" + title + ", description=" + description + '}';
    }
    
}
