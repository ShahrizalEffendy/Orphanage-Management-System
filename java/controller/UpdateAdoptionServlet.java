/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP 14S
 */
public class UpdateAdoptionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String p_name = request.getParameter("p_name");
        int age = Integer.parseInt(request.getParameter("age"));
        int p_age = Integer.parseInt(request.getParameter("p_age"));
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");
        String p_contact = request.getParameter("p_contact");
        String occupation = request.getParameter("occupation");
        String child_name = request.getParameter("child_name");
        int child_age = Integer.parseInt(request.getParameter("child_age"));
        String gender = request.getParameter("gender");
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            // Establish a database connection
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orphanage", "app", "app");

            // Prepare the SQL statement to update the donor data
            String sql = "UPDATE adoption SET name = ?, p_name = ?, age = ?, p_age = ?, address = ?, contact = ?, p_contact = ?, occupation = ?, child_name = ?, child_age = ?, gender = ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, p_name);
            stmt.setInt(3, age);
            stmt.setInt(4, p_age);
            stmt.setString(5, address);
            stmt.setString(6, contact);
            stmt.setString(7, p_contact);
            stmt.setString(8, occupation);
            stmt.setString(9, child_name);
            stmt.setInt(10, child_age);
            stmt.setString(11, gender);
            stmt.setInt(12,id);

            // Execute the update query
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                // Data updated successfully
                String successMessage = "Adoption data updated successfully.";
                request.setAttribute("successMessage", successMessage);
                request.getRequestDispatcher("/updateAdoption.jsp").forward(request, response);
            } else {
                // No rows were updated
                String errorMessage = "Failed to update adoption data.";
                request.setAttribute("errMessage", errorMessage);
                request.getRequestDispatcher("/updateAdoption.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String errorMessage = "An error occurred while updating adoption data.";
            request.setAttribute("errMessage", errorMessage);
            request.getRequestDispatcher("/updateAdoption.jsp").forward(request, response);
        } finally {
            // Close the database resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
