<%-- 
    Document   : updateChild
    Created on : Jul 12, 2023, 8:31:32 PM
    Author     : HP 14S
--%>
<%@page import="controller.UpdateChildServlet"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>ORPHANAGE MANAGEMENT SYSTEM</title>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        * {
         box-sizing: border-box;
      }

      body {
         font-family: Arial, Helvetica, sans-serif;
         
      }

      header {
         background-color: #4692A1;
         padding: 20px;
         text-align: center;
         font-size: 20px;
         color: white;
      }

      article {
         float: right;
         padding-top: 50px;
         padding-left: 200px;
         width: 100%;
         background-color: #C0C5C6;
         height: 500px; /* only for demonstration, should be removed */
      }

      section::after {
         content: "";
         display: table;
         clear: both;
      }

      footer {
         background-color: #777;
         padding: 10px;
         text-align: center;
         color: white;
      }

      @media (max-width: 600px) {
         nav,
         article {
            width: 100%;
            height: auto;
         }
      }
 
      .container {
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

      .form {
            width: 400px;
        }

      table {
            width: 100%;
            font-family: Tahoma;
            border-collapse: collapse;
        }
      
        td,
        th {
            padding: 5px;
            border: 1px solid #666;
        }

     
      th {
            background: #ddd;
        }
    </style>
</head>
<body>
    <header>
   <div style="display: flex; align-items: center; justify-content: center;">
      <div style="position: absolute; left: 0;">
         <a href="index.html"><img src="logo.jpg"></a>
      </div>
      <div>
         <h2 style="text-align: center; margin: 0;">Orphanage Management System</h2>
      </div>
   </div>
   <div style="text-align: center;">
      <h3>Child Information</h3>
   </div>
   </header>
    
     <section>
    <article>
    <div class="container">
        <div class="form">
       <h1>Update Child</h1>

            <% 
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;

            try {
                // Establish a database connection
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orphanage", "app", "app");

                // Get the donor ID parameter from the request
                int id = Integer.parseInt(request.getParameter("id"));

                // Prepare the SQL statement to select the donor based on the ID
                String sql = "SELECT * FROM child WHERE id = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);

                // Execute the query to retrieve the donor data
                rs = stmt.executeQuery();

                // Check if the donor exists
                if (rs.next()) {
                    // Retrieve the donor data
                    id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    String gender = rs.getString("gender");
                    String username = rs.getString("username");
                    String password = rs.getString("password");

                    // Display the form to update donor data
                    %>

                        <table>
                    <form action="UpdateChildServlet" method="POST" onsubmit="return validateForm()">
                        <input type="hidden" name="id" value="<%= id%>">
                        <label for="name">Name:</label>
                        <input type="text" id="name" name="name" value="<%= name %>"><br><br>                         
                        <label for="age">Age:</label>
                        <input type="text" id="age" name="age" value="<%= age %>"><br><br>
                        <label for="gender">Gender:</label>
                        <input type="text" id="gender" name="gender" value="<%= gender %>"><br><br>
                        <label for="username">Username:</label>
                        <input type="text" id="username" name="username" value="<%= username %>"><br><br>
                        <label for="password">Password:</label>
                        <input type="text" id="password" name="password" value="<%= password %>"><br><br>
                        <input type="submit" value="Update">
                    </form>                      
                        </table>               
                    <%
                } else {
                // Check for error message
                String errorMessage = (String) request.getAttribute("errMessage");
                if (errorMessage != null && !errorMessage.isEmpty()) {
                    %>
                    <p>Error: <%= errorMessage %></p>
                    <%
                }
                }

                // Check for success message
                String successMessage = (String) request.getAttribute("successMessage");
                if (successMessage != null && !successMessage.isEmpty()) {
                    %>
                    <p><%= successMessage %></p>
                    <%
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Close the database resources
                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            %>
        <a href="child_success.jsp"><button>Back</button></a>
            </article>
    </section>
</body>
</html>
