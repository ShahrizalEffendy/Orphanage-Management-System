/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.AdoptBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class AdoptDAO {
  private static final String DB_URL = "jdbc:derby://localhost:1527/orphanage";
    private static final String DB_USER = "app";
    private static final String DB_PASSWORD = "app";

    public static void saveAdt(AdoptBean adt) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO adopt2 (name,username, password) VALUES (?, ?, ?)")) {

            stmt.setString(1, adt.getName());
            stmt.setString(2, adt.getUsername());
            stmt.setString(3, adt.getPassword());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<AdoptBean> getAdopt() {
        List<AdoptBean> adopt = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM adopt2");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                AdoptBean adt = new AdoptBean();
                
                adt.setName(rs.getString("name"));
                adt.setUsername(rs.getString("username"));
                adt.setPassword(rs.getString("password"));
            

                adopt.add(adt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return adopt;
    }

    
}

