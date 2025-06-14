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

public class UpdateChildServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            // Establish a database connection
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orphanage", "app", "app");

            // Prepare the SQL statement to update the donor data
            String sql = "UPDATE CHILD SET name = ?, age = ?, gender = ?, username = ?, password = ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, gender);
            stmt.setString(4, username);
            stmt.setString(5, password);
            stmt.setInt(6, id);


            // Execute the update query
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                // Data updated successfully
                String successMessage = "Child data updated successfully.";
                request.setAttribute("successMessage", successMessage);
                request.getRequestDispatcher("/updateChild.jsp").forward(request, response);
            } else {
                // No rows were updated
                String errorMessage = "Failed to update child data.";
                request.setAttribute("errMessage", errorMessage);
                request.getRequestDispatcher("/updateChild.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String errorMessage = "An error occurred while updating child data.";
            request.setAttribute("errMessage", errorMessage);
            request.getRequestDispatcher("/updateChild.jsp").forward(request, response);
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
