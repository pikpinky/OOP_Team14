/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Order {
    private int oID;
    private int accID;
    private String address;
    private int isOrdered;
    private Date date;
    private ArrayList<OrderDetail> detail = new ArrayList<>();

    public Order(int oID, int accID, String address,int isOrdered, Date date) {
        this.oID = oID;
        this.accID = accID;
        this.isOrdered = isOrdered;
        this.date = date;
        this.address = address;
    }

    public Order(int oID, int accID, int isOrdered, Date date) {
        this.oID = oID;
        this.accID = accID;
        this.isOrdered = isOrdered;
        this.date = date;
    }
    
    public String getAddress(){
        return address;
    }

    public int getoID() {
        return oID;
    }


    public int getAccID() {
        return accID;
    }

    public int getIsOrdered() {
        return isOrdered;
    }

    public Date getDate() {
        return date;
    }

    public ArrayList<OrderDetail> getDetail() {
        return detail;
    }
    
    public void setDetail(ArrayList<OrderDetail> list){
        detail = list;
    }
    
    public int getMoney(){
        int  res = 0;
        for(OrderDetail x : detail)
            res += x.getPrice() * x.getQuantity();
        return res;
    }
    
    @Override
    public String toString() {
        return "Order{" + "oID=" + oID + ", accID=" + accID + ", isOrdered=" + isOrdered + ", date=" + date + '}';
    }
    
}
