/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.*;
import java.util.*;
import Entity.*;
import com.sun.istack.internal.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author tinht
 */
public class AccountDAO{

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public ArrayList<Account> getAll() {
        ArrayList<Account> accountList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [UserInfo]";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Account acc = new Account();
                acc.setId(rs.getInt("id"));
                acc.setUsername(rs.getString("username"));
                acc.setPassword(rs.getString("password"));
                acc.setFirstName(rs.getString("firstname"));
                acc.setLastName(rs.getString("lastname"));
                acc.setType(rs.getString("type"));
                accountList.add(acc);
            }
        } catch (Exception ex) {
            
        }
        return accountList;
    }
    
    public Account GetLoginAccount(Account acc) {
        ArrayList<Account> list = getAll();
        for(Account a : list) {
            if(a.getUsername().equals(acc.getUsername()) && a.getPassword().equals(acc.getPassword())) {
                return a;
            }
        }
        
        return null;
    }
    
    public Account AccountValid(String username) {
        String query = "select * from UserInfo\n"
                + "where [username] = ?\n";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {                
                return new Account(rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public Account Test() {
        ArrayList<Account> list = getAll();
        return list.get(0);
    }
    
    public Account Login(String username, String password) {
        String sql = "select * from UserInfo where (username = '" + username + "' and [password] = '" + password + "')";
        
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                return new Account(rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getString(6));
            }
            
        } catch (Exception e) {
            
        }
        
        return null;
    }
    
    public void CreateAccount(Account acc) {
        ArrayList<Account> list = getAll();
        int id = list.size();
        String sql = "insert into UserInfo\n" 
                    + "values ('" + id
                + "', '" + acc.getUsername()
                + "', '" + acc.getPassword()
                + "', '" + acc.getFirstName()
                + "', '" + acc.getLastName()
                + "', '" + acc.getType()
                + "')\n";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
            
        }
    }
    
    public Account GetAccount(String username) {
        String sql = "select * from UserInfo where (username = '" + username + "')";
        
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                return new Account(rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getString(6));
            }
            
        } catch (Exception e) {
            
        }
        
        return null;
    }
    
    public void UpdateAccount(String currentName, Account acc) {
        Account currentAccount = GetAccount(currentName);
        String sql = "update UserInfo\n" +
                        "set\n" +
                        "	id = " + currentAccount.getId() + ",\n" +
                        "	username = '" + acc.getUsername() + "',\n" +
                        "	[password] = '" + acc.getPassword()+ "',\n" +
                        "	firstname = '" + acc.getFirstName()+ "',\n" +
                        "	lastname = '" + acc.getLastName()+ "',\n" +
                        "	[type] = '" + currentAccount.getType()+ "'\n" +
                        "where\n" +
                        "	username = '" + currentAccount.getUsername() + "'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public void DeleteAccount(String name) {
        String sql = "delete from UserInfo where( username = '" + name + "')";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        AccountDAO db = new AccountDAO();
        System.out.println(db.Login("admin", "12345678"));
    }
}
