/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import entity.Product;
import java.util.*;
import context.DBcontext;
import entity.*;

/**
 *
 * @author DELL
 */
public class OrderDao {
    
    public boolean checkOrder(int accID){
        String query = "select * from [Order]\n"
                + "where accID = ? and ordered = 0";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, accID);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return true;
        }
        catch(Exception e){
            
        }
        return false;
    }
    
    public boolean checkOrder1(int accID){
        String query = "select * from [Order]\n"
                + "where accID = ? and ordered = 2";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, accID);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return true;
        }
        catch(Exception e){
            
        }
        return false;
    }
    
    public void addOrder(int accID, String address){
        String query = "insert into [Order](accID, [address]) values(?, ?)";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, accID);
            ps.setString(2, address);
            ps.executeUpdate();
        }
        catch(Exception e){
            
        }
    }
    
    public Order getOrder(int accID){
        String query = "select * from [Order]\n"
                + "where accID = ? and ordered = 0";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, accID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Order order = new Order(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getDate(5));
            return order;
        }
        catch(Exception e){
            
        }
        return null;
    }
    
    public void addOrderDetail(int quantity, int oID, int pID){
        String query = "insert into OrderDetail (oID, pID, quantity)\n"
                + "values(?, ?, ?)";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, oID);
            ps.setInt(2, pID);
            ps.setInt(3, quantity);
            ps.executeUpdate();
        }
        catch(Exception e){
            
        }
    }
        
    public ArrayList<OrderDetail> getOrderDetail(int oID){
        String query = "select OrderDetail.*, Product.name, Product.image, Product.price, Product.sellID from OrderDetail\n"
                + "inner join [Order] on OrderDetail.oID = [Order].oID\n"
                + "inner join Product on OrderDetail.pID = Product.id\n"
                + "where [Order].ordered = 0 and [Order].oID = ?";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, oID);
            ResultSet rs = ps.executeQuery();
            ArrayList<OrderDetail> list = new ArrayList<>();
            while(rs.next()){
                list.add(new OrderDetail(rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getInt(4),
                rs.getString(5),
                rs.getString(6),
                rs.getInt(7),
                rs.getInt(8)));
            }
            return list;
        }
        catch(Exception e){
            
        }
        return null;
    }
    
    public int getProductQuantity(int oID, int pID){
        String query = "select quantity from OrderDetail where oID = ? and pID = ?";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, oID);
            ps.setInt(2, pID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
        catch(Exception e){
            
        }
        return 0;
    }
    
    public void updateOrder(int pID, int oID, int quantity, String op){
        String query1 = "update OrderDetail set quantity = ? where oID = ? and pID = ?";
        String query2 = "delete OrderDetail where oID = ? and pID = ?";
        String query = null;
        if(op.equals("0") && quantity == 1)
            query = query2;
        else
            query = query1;
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            if(query.equals(query1)){
                if(op.equals("0"))
                    ps.setInt(1, quantity - 1);
                else
                    ps.setInt(1, quantity + 1);
                ps.setInt(2, oID);
                ps.setInt(3, pID);
            }
            else{
                ps.setInt(1, oID);
                ps.setInt(2, pID);
            }
            ps.executeUpdate();
        }
        catch(Exception e){
            
        }
    }
    
    public ArrayList<OrderDetail> getOrderedtDetail(int accID){
        String query = "select OrderDetail.*, Product.name, Product.image, Product.price, Product.sellID from OrderDetail\n"
                + "inner join [Order] on OrderDetail.oID = [Order].oID\n"
                + "inner join Product on OrderDetail.pID = Product.id\n"
                + "where [Order].accID = ? and [Order].ordered = 1";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, accID);
            ResultSet rs = ps.executeQuery();
            ArrayList<OrderDetail> list = new ArrayList<>();
            while(rs.next()){
                list.add(new OrderDetail(rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getInt(4),
                rs.getString(5),
                rs.getString(6),
                rs.getInt(7),
                rs.getInt(8)));
            }
            return list;
        }
        catch(Exception e){
            
        }
        return null;
    }
    
    public void updateOrderStatus(int oID, String address){
        String query = "update [Order] set ordered = 1, [date] = getdate(), [address] = ? where oID = ?";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(2, oID);
            ps.setString(1, address);
            ps.executeUpdate();
        }
        catch(Exception e){
            
        }
    }
    
    public void deleteOrder(int oID, int pID){
        String query = "delete OrderDetail where oID = ? and pID = ?";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, oID);
            ps.setInt(2, pID);
            ps.executeUpdate();
        }
        catch(Exception e){
            
        }
    }
    
    public void updateOrder1(int oID){
        String query = "update [Order] set ordered = 2 where oID = ?";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, oID);
            ps.executeUpdate();
        }
        catch(Exception e){
            
        }
    }
    
    public void updateOrder2(int accID){
        String query = "update [Order] set ordered = 0 where accID = ? and ordered = 2";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, accID);
            ps.executeUpdate();
        }
        catch(Exception e){
            
        }
    }
    
    public void updateOrderDetailStatus(int oID, int pID){
        String query = "update OrderDetail set [status] = 1 where oID = ? and pID = ?";
        try{
           Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, oID);
            ps.setInt(2, pID);
            ps.executeUpdate(); 
        }
        catch(Exception e){
            
        }
    }
    
    public ArrayList<OrderDetail> getOrderToSeller(int sellID){
        String query = "select OrderDetail.*, Product.name, Product.image, Product.price, Product.sellID, Account.[user] from OrderDetail\n"
                + "inner join Product on OrderDetail.pID = Product.id\n"
                + "inner join [Order] on [Order].oID = OrderDetail.oID\n"
                + "inner join Account on Account.id = [Order].accID\n"
                + "where Product.sellID = ?";
        try{
           Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, sellID);
            ResultSet rs = ps.executeQuery();
            ArrayList<OrderDetail> list = new ArrayList<>();
            while(rs.next()){
                list.add(new OrderDetail(rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getInt(4),
                rs.getString(5),
                rs.getString(6),
                rs.getInt(7),
                rs.getInt(8),
                rs.getString(9)));
            }
            return list;
        }
        catch(Exception e){
            
        }
        return null;
    }
    
    
    
    public static void main(String[] args) {
        OrderDao dao = new OrderDao();
        System.out.println(dao.getOrderToSeller(1));
    }
}
