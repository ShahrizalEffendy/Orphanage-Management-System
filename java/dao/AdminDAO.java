/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.AdminBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {
    private static final String DB_URL = "jdbc:derby://localhost:1527/orphanage";
    private static final String DB_USER = "app";
    private static final String DB_PASSWORD = "app";

    public static void saveAdm(AdminBean adm) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO Admin1 (name, address, contact,username, password) VALUES (?, ?, ?, ?, ?)")) {

            stmt.setString(1, adm.getName());
            stmt.setString(2, adm.getAddress());
            stmt.setString(3, adm.getContact());
            stmt.setString(4, adm.getUsername());
            stmt.setString(5, adm.getPassword());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<AdminBean> getAdmin() {
        List<AdminBean> admin = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Admin1");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                AdminBean adm = new AdminBean();
                
                adm.setName(rs.getString("name"));
                adm.setContact(rs.getString("contact"));
                adm.setAddress(rs.getString("address"));
            

                admin.add(adm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }

    
}


