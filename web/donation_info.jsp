<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      
     table {
            width: 400px;
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
      <h3>Donation Information</h3>
   </div>
   </header>
      <section>
         <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>Item</th>
                <th>Quantity</th>
                <th>Update</th>
                <th>Delete</th>               
            </tr>
            </thead>
                <tbody>
                    <% 
                    // Database connection details
                    String dbUrl = "jdbc:derby://localhost:1527/orphanage";
                    String dbUsername = "app";
                    String dbPassword = "app";

                    try {
                        // Establish the database connection
                        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

                        // Fetch data from the "childr" table
                        String query = "SELECT * FROM donation";
                        PreparedStatement statement = connection.prepareStatement(query);
                        ResultSet resultSet = statement.executeQuery();

                        // Loop through the result set and populate the table rows
                        while (resultSet.next()) {
                            int id = resultSet.getInt("id");
                            String item = resultSet.getString("item");
                            int quantity = resultSet.getInt("quantity");

                            // Display the donor information in table rows
                            %>
                            <tr>
                                <td><%= id %></td>                                
                                <td><%= item %></td>
                                <td><%= quantity %></td>
                                <td>
                                    <form action="updateDonation.jsp" method="post">
                                        <input type="hidden" name="id" value="<%= id %>">
                                        <input type="hidden" name="name" value="<%= item %>">
                                        <button type="submit" class="button">Update</button>
                                    </form>
                                </td>
                                <td>
                                    <form action="deleteDonation.jsp" method="post">
                                        <input type="hidden" name="id" value="<%= id %>">
                                        <input type="hidden" name="name" value="<%= item %>">
                                        <button type="submit" class="button">Delete</button>
                                    </form>
                                </td>
                            </tr>
                            <%
                        }

                        // Close resources
                        resultSet.close();
                        statement.close();
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    %>
                </tbody>

         </table>
        <a href="admin_success.jsp"><button>Back</button></a>
      </article>
   </section>
</body>
</html>
