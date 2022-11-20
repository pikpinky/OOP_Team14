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
public class ProductDao {

    public ArrayList<Product> getAllProduct(int page) {
        ArrayList<Product> list = new ArrayList<>();
        String query = "with x as (select ROW_NUMBER() over (order by price asc) as p , * from Product)\n"
                    + "select * from x where p between ? * 6 - 5 and ? * 6";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, page);
            ps.setInt(2, page);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(2),
                rs.getString(3),
                rs.getString(4),
                rs.getInt(5),
                rs.getString(6),
                rs.getString(7),
                rs.getInt(8),
                rs.getInt(9)));
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
                list.add(new Category(rs.getInt(1),
                rs.getString(2)));
            }
        }
        catch(Exception e){
            
        }
        return list;
    }
    
    public ArrayList<Product> getProductByCategory(String cid, int page){
        ArrayList<Product> list = new ArrayList<>();
        String query = "with s as (select ROW_NUMBER() over (order by price asc) as p , * from Product where cateID = ?)\n"
                        + "select * from s where p between ? * 3 - 2 and ? * 3";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cid);
            ps.setInt(2, page);
            ps.setInt(3, page);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(2),
                rs.getString(3),
                rs.getString(4),
                rs.getInt(5),
                rs.getString(6),
                rs.getString(7),
                rs.getInt(8),
                rs.getInt(9)));
            }
        }
        catch (Exception e){
            
        }
        return list;
    }
    
    public Product getProductByID(int id){
        String query = "select * from Product\n"
                + "where id = ?";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Product p = new Product(rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getInt(4),
                rs.getString(5),
                rs.getString(6),
                rs.getInt(7),
                rs.getInt(8));
            return p;
        }
        catch(Exception e){
        }
        return null;
    }
    
    public ArrayList<Product> getProducByKey(String key, int page){
        String query = "with x as (select ROW_NUMBER() over (order by price asc) as p , * from Product where name like ?)\n"
                +"select * from x where p between ? * 3 - 2 and ? * 3";
        ArrayList<Product> list = new ArrayList<>();
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,"%" + key + "%");
            ps.setInt(2, page);
            ps.setInt(3, page);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(2),
                rs.getString(3),
                rs.getString(4),
                rs.getInt(5),
                rs.getString(6),
                rs.getString(7),
                rs.getInt(8),
                rs.getInt(9)));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    
    public int getAmountOfAllProduct(){
        try{
            String query = "select count(*) from Product";
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
        catch(Exception e){
            
        }
        return 0;
    }
    
    public int getAmountOfCateProduct(String cid){
        try{
            String query = "select count(*) from Product\n"
                    + "where cateID = ?";
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cid);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
        catch(Exception e){
            
        }
        return 0;
    }
    
    public int getAmountOfKeyProduct(String key){
        try{
            String query = "select count(*) from Product\n"
                    + "where name like ?";
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,"%" + key + "%");
            ResultSet rs = ps.executeQuery();
            rs.next();
            System.out.println(key);
            return rs.getInt(1);
        }
        catch(Exception e){
            
        }
        return 0;
    }
    
    public ArrayList<Product> getProductBySeller(int sellID){
        String query = "select * from Product\n"
                + "where sellID = ?";
        ArrayList<Product> list = new ArrayList<>();
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, sellID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getInt(4),
                rs.getString(5),
                rs.getString(6),
                rs.getInt(7),
                rs.getInt(8)));
            }
        }
        catch(Exception e){
            
        }
        return list;
    }
    
    public void deleteProduct(int id){
        String query = "delete from Product\n"
                + "where id = ?";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch(Exception e){
            
        }
    }
    
    public void addProduct(Product p){
        String query = "insert into Product\n"
                + "values(?, ?, ?, ?, ?, ?, ?)";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, p.getName());
            ps.setString(2, p.getImage());
            ps.setInt(3, p.getPrice());
            ps.setString(4, p.getTitle());
            ps.setString(5, p.getDescription());
            ps.setInt(6, p.getCateID());
            ps.setInt(7, p.getSellID());
            ps.executeUpdate();
        }
        catch(Exception e){
            
        }
    }
    
    public void EditProduct(Product p){
        String query = "update Product\n"
                + "set [name] = ?,"
                + "image = ?,"
                + "price = ?,"
                + "title = ?,"
                + "cateID = ?,"
                + "description = ?\n" 
                + "where id = ?";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, p.getName());
            ps.setString(2, p.getImage());
            ps.setInt(3, p.getPrice());
            ps.setString(4, p.getTitle());
            ps.setInt(5, p.getCateID());
            ps.setString(6, p.getDescription());
            ps.setInt(7, p.getId());
            ps.executeUpdate();
        }
        catch(Exception e){
            
        }
    }
    
    
    public static void main(String[] args) {
        ProductDao dao = new ProductDao();
        System.out.println(dao.getAllCategory());
    }
}
