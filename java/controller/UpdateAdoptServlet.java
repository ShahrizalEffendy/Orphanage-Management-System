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
public class UpdateAdoptServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            // Establish a database connection
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orphanage", "app", "app");

            // Prepare the SQL statement to update the donor data
            String sql = "UPDATE adopt2 SET name = ?, username = ?, password = ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, username);
            stmt.setString(3, password);
            stmt.setInt(4, id);


            // Execute the update query
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                // Data updated successfully
                String successMessage = "Adopt data updated successfully.";
                request.setAttribute("successMessage", successMessage);
                request.getRequestDispatcher("/updateAdopt.jsp").forward(request, response);
            } else {
                // No rows were updated
                String errorMessage = "Failed to update adopt data.";
                request.setAttribute("errMessage", errorMessage);
                request.getRequestDispatcher("/updateAdopt.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String errorMessage = "An error occurred while updating adopt data.";
            request.setAttribute("errMessage", errorMessage);
            request.getRequestDispatcher("/updateAdopt.jsp").forward(request, response);
        } finally {
            // Close the database resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        };
    }


}
