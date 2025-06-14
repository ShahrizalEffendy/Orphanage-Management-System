/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ChildBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChildDAO {
    private static final String DB_URL = "jdbc:derby://localhost:1527/orphanage";
    private static final String DB_USER = "app";
    private static final String DB_PASSWORD = "app";
    private List<ChildBean> childList;

    public static void saveChild(ChildBean child) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO Child (name, age, gender,username, password) VALUES (?, ?, ?, ?, ?)")) {

            stmt.setString(1, child.getName());
            stmt.setInt(2, child.getAge());
            stmt.setString(3, child.getGender());
            stmt.setString(4, child.getUsername());
            stmt.setString(5, child.getPassword());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<ChildBean> getAllChildren() {
        List<ChildBean> children = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Child");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ChildBean child = new ChildBean();
                child.setId(rs.getInt("id"));
                child.setName(rs.getString("name"));
                child.setAge(rs.getInt("age"));
                child.setGender(rs.getString("gender"));
                child.setUsername(rs.getString("username"));
                child.setPassword(rs.getString("password"));

                children.add(child);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return children;
    }
   
    public void deleteChild(int childId) {
    // Find the child with the given ID and remove it from the childList
    for (ChildBean child : childList) {
        if (child.getId() == childId) {
            childList.remove(child);
            break;
        }
    
    }  }

    
    
}

