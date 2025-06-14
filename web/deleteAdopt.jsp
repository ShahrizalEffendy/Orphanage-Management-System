<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
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
      <h3>Adopt Information</h3>
   </div>
   </header>
    <section>
        <article>
    <h1>Delete Adopt</h1>

    <table>
        <tr>
               <th>Id</th>
               <th>Name</th>
               <th>Username</th>
               <th>Password</th>
        </tr>
        <% 
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Establish a database connection
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orphanage", "app", "app");

            // Execute the query to retrieve donor data
            stmt = conn.createStatement();
            String sql = "SELECT * FROM adopt2";
            rs = stmt.executeQuery(sql);

            // Iterate over the result set and display data in table rows
            while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String username = rs.getString("username");
                    String password = rs.getString("password");

                %>
                <tr>
               <td><%= id %></td>
               <td><%= name %></td>
               <td><%= username %></td>
               <td><%= password %></td>
                    <td>
                        <form action="DeleteAdoptServlet" method="post">
                            <input type="hidden" name="id" value="<%= id %>">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
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
    </table>
    <a href="adopt_info.jsp"><button>Back</button></a>
</article>
</section>
</body>
</html>


