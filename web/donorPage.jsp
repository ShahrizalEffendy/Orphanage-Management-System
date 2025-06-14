<%@page import="bean.DonorRegisterBean"%>
<%@page import="dao.LoginDao"%>
<%@page import="util.DBConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    DonorRegisterBean don = new DonorRegisterBean();
%>
<html lang="en">
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

            /* Style the header */
            header {
                background-color: #4692A1;
                padding: 20px;
                text-align: center;
                font-size: 20px;
                color: white;
            }

            .topright {
                position: absolute;
                top: 8px;
                right: 16px;
                font-size: 18px;
            }
            /* Create two columns/boxes that floats next to each other */
            nav {
                float: right;
                width: 45%;
                height: 300px; /* only for demonstration, should be removed */
                background: #C0C5C6; 
            }

            nav p{
                margin: 50px;
                padding-top: none;
            }

            /* Style the list inside the menu */
            nav ul {
                list-style-type: none;
                padding: 0;
            }

            article {
                float: left;
                padding: 20px;
                width: 55%;
                background-color:#C0C5C6;
                height: 300px; /* only for demonstration, should be removed */
            }

            /* Clear floats after the columns */
            section::after {
                content: "";
                display: table;
                clear: both;
            }

            /* Style the footer */
            footer {
                background-color: #777;
                padding: 10px;
                text-align: center;
                color: white;
            }

            /* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
            @media (max-width: 600px) {
                nav, article {
                    width: 100%;
                    height: auto;
                }
            }
        </style>
        <script>
            function validate()
            {

                var item = document.form.item.value;
                var quantity = document.form.quantity.value;

                if (item == null || item == "")
                {
                    alert("Choose Item");
                    return false;
                } else if (quantity == null || quantity == "")
                {
                    alert("No of item can't be blank");
                    return false;
                }
            }
        </script> 
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
      <h3>Donor Information</h3>
   </div>
            <div class="topright"><%= don.getName()%>, <a href="login.jsp">Logout</a></div>
        </header>

        <section>
            <nav>
                <p align="left" >
                <h1>Donate</h1>
                <form name="form" action="DonationServlet" method="POST" onsubmit="return validate()">
                    <table border="0" cellspacing="0" cellpadding="4">

                        <tbody>
                            <tr>
                                <td>Item:</td>
                                <td> <select name="item">
                                        <option value="">Select</option>
                                        <option value="chair">Chair</option>
                                        <option value="Table">Table</option>
                                        <option value="Pillow">Pillow</option>
                                        <option value="Bed">Bed</option>
                                        <option value="Plate">Plate</option>
                                        <option value="clothes">Clothes</option>
                                    </select></td>
                            </tr>
                            <tr>
                                <td>No of items:</td>
                                <td><input type="text" name="quantity" value="" /></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Donate" /></td>
                            </tr>
                        </tbody>
                    </table>
                </form>
                </p>
            </nav>

            <article>
                <p align="left">
                <h1>Welcome Donor!</h1>                
                            </article>
                            </section>
                            </body>
                            </html>


