/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.DonorRegisterBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Vaio
 */
public class DonorRegisterDao {
    
    private static final String DB_URL = "jdbc:derby://localhost:1527/orphanage";
    private static final String DB_USER = "app";
    private static final String DB_PASSWORD = "app";

    // Insert donor Data
    public static void registerDonor(DonorRegisterBean don){
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO donor (name, address, contactno, username, password) VALUES (?, ?, ?, ?, ?)")) {

            stmt.setString(1, don.getName());
            stmt.setString(2, don.getAddress());
            stmt.setString(3, don.getContactno());
            stmt.setString(4, don.getUsername());
            stmt.setString(5, don.getPassword());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    public static List<DonorRegisterBean> getDonor(){
        
        List <DonorRegisterBean> donor = new ArrayList<>();
  
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM donor");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                DonorRegisterBean don = new DonorRegisterBean();
                
                don.setId(rs.getInt("id"));
                don.setName(rs.getString("name"));
                don.setContactno(rs.getString("contact"));
                don.setAddress(rs.getString("address"));
                don.setUsername(rs.getString("username"));
                don.setPassword(rs.getString("password"));

                donor.add(don);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return donor;
    }
    
}
