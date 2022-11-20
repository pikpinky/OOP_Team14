/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import entity.Product;
import java.util.*;
import context.DBcontext;
import entity.Category;
/**
 *
 * @author DELL
 */
public class Dao {

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> list = new ArrayList<>();
        String query = "select * from Product";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getDouble(4),
                rs.getString(5),
                rs.getString(6)));
            }
        }
        catch(Exception e){
            
        }
        return list;
    }
    
    public ArrayList<Category> getAllCategory() {
        ArrayList<Category> list = new ArrayList<>();
        String query = "select * from Category";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Category(rs.getString(1),
                rs.getString(2)));
            }
        }
        catch(Exception e){
            
        }
        return list;
    }
    
    public ArrayList<Product> getProductByCategory(String cid){
        ArrayList<Product> list = new ArrayList<>();
        String query = "select * from Product\n"
                        + "where cateID = ?";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getDouble(4),
                rs.getString(5),
                rs.getString(6)));
            }
        }
        catch (Exception e){
            
        }
        return list;
    }
    
    public Product getProductByID(String id){
        String query = "select * from Product\n"
                + "where id = ?";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Product p = new Product(rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getDouble(4),
                rs.getString(5),
                rs.getString(6));
            return p;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    public static void main(String[] args) {
        Dao dao = new Dao();
        Product p = dao.getProductByID("p2");
        System.out.println(p);
    }
    
}
