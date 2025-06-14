/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.AdoptionBean;
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
public class AdoptionDAO {
     private static final String DB_URL = "jdbc:derby://localhost:1527/orphanage";
    private static final String DB_USER = "app";
    private static final String DB_PASSWORD = "app";

    public static void saveAdm(AdoptionBean adm) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO adoption (name, p_name, age, p_age, address, contact, p_contact, occupation, child_name, child_age, gender) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            stmt.setString(1, adm.getName());
            stmt.setString(2, adm.getP_name());
            stmt.setInt(3, adm.getAge());
            stmt.setInt(4, adm.getP_age());
            stmt.setString(5, adm.getAddress());
            stmt.setString(6, adm.getContact());
            stmt.setString(7, adm.getP_contact());
            stmt.setString(8, adm.getOccupation());
            stmt.setString(9, adm.getChild_name());
            stmt.setInt(10, adm.getChild_age());
            stmt.setString(11, adm.getGender());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<AdoptionBean> getAdmin() {
        List<AdoptionBean> admin = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM adoption");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                AdoptionBean adm = new AdoptionBean();
                
                adm.setName(rs.getString("name"));
                adm.setP_name(rs.getString("p_name"));
                adm.setAge(rs.getInt("age"));
                adm.setP_age(rs.getInt("p_age"));
                adm.setAddress(rs.getString("address"));
                adm.setContact(rs.getString("contact"));
                adm.setP_contact(rs.getString("p_contact"));
                adm.setOccupation(rs.getString("occupation"));
                adm.setChild_name(rs.getString("child_name"));
                adm.setChild_age(rs.getInt("child_age"));
                adm.setGender(rs.getString("gender"));
                
            

                admin.add(adm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }

}
