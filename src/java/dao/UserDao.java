/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBcontext;
import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class UserDao {
     public Account getAccount(String user, String pass){
        String query = "select * from Account\n"
                + "where [user] = ? and pass = ?";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
        }
        catch(Exception e){
            
        }
        return null;
    }
    
    public Account getAccountByID(int id){
        String query = "select * from Account\n"
                + "where id = ?";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
        }
        catch(Exception e){
            
        }
        return null;
    }
    
    public Account checkAccount(String user){
        String query = "select * from Account\n"
                + "where [user] = ?";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
        }
        catch(Exception e){
            
        }
        return null;
    }
    
    public void addAccount(String user, String pass, int isSeller, String phone, String address){
        String query = "insert into Account\n"
                    + "values (?, ?, ?, ?, ?)";
        try{
            Connection con = new DBcontext().getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setInt(3, isSeller);
            ps.setString(4, phone);
            ps.setString(5, address);
            ps.executeUpdate();
        }
        catch(Exception e){
            
        }
    }
    
}
