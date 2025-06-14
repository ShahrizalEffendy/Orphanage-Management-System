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
      <h3>Adoption Information</h3>
   </div>
   </header>
    <section>
        <article>
    <h1>Delete Adoption</h1>

    <table>
        <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Partner's Name</th>
                <th>Age</th>
                <th>Partner's Age</th>
                <th>Address</th>
                <th>Contact No</th>
                <th>Partner's Contact No</th>
                <th>Occupation</th>
                <th>Child's Name</th>
                <th>Child's Age</th>
                <th>Child's Gender</th>
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
            String sql = "SELECT * FROM adoption";
            rs = stmt.executeQuery(sql);

            // Iterate over the result set and display data in table rows
            while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String p_name = rs.getString("p_name");
                    int age = rs.getInt("age");
                    int p_age = rs.getInt("p_age");
                    String address = rs.getString("address");
                    String contact = rs.getString("contact");
                    String p_contact = rs.getString("p_contact");
                    String occupation = rs.getString("occupation");
                    String child_name = rs.getString("child_name");
                    int child_age = rs.getInt("child_age");
                    String gender = rs.getString("gender");

                %>
                <tr>
                    <td><%= id %></td>                                
                    <td><%= name %></td>
                    <td><%= p_name %></td>
                    <td><%= age %></td>
                    <td><%= p_age %></td>                                
                    <td><%= address %></td>
                    <td><%= contact %></td>
                    <td><%= p_contact %></td>
                    <td><%= occupation %></td>                                
                    <td><%= child_name %></td>
                    <td><%= child_age %></td>
                    <td><%= gender %></td>
                    <td>
                        <form action="DeleteAdoptionServlet" method="post">
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
    <a href="adoption_info.jsp"><button>Back</button></a>
</article>
</section>
</body>
</html>


