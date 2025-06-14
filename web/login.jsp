<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ORPHANAGE MANAGEMENT SYSTEM</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
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



            article {
                float: right;
                padding-top: 50px;
                padding-left: 200px;
                width: 100%;
                background-color:#C0C5C6;
                height: 500px; /* only for demonstration, should be removed */
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
               
                var username = document.form.username.value;
                var password = document.form.password.value;
                var type = document.form.type.value;
                

                if (username == null || username == "")
                {
                    alert("Username can't be blank");
                    return false;
                } else if (password == null || password == "")
                {
                    alert("Password can't be blank");
                    return false;
                } else if (type == null || type == "")
                {
                    alert("Choose Login As");
                    return false;
                } 
            }
        </script> 
    </head>
    <body>
    <center>
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
      <h3>Log In</h3>
   </div>
        </header>

        <section>

            <article>


                <form name="form" action="LoginServlet" method="post" onsubmit="return validate()">

                    <table border="0" cellspacing="4" cellpadding="4">

                        <tbody>

                            <tr>
                                <td>Username: </td>
                                <td><input type="text" name="username" value="" /></td>
                            </tr>
                            <tr>
                                <td>Password: </td>
                                <td><input type="password" name="password" value="" /></td>
                            </tr>
                            <tr>
                                <td>Login as: </td>
                                <td><select name="type">
                                        <option value="">Select</option>
                                        <option value="admin">Admin</option>
                                        <option value="donor">Donor</option>
                                        <option value="adopt">Adopt</option>
                                    </select></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td><span style="color: red"> <%=(request.getAttribute("errMessage") == null) ? ""
                            : request.getAttribute("errMessage")%>
                                    </span> </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Login" /><input type="reset" value="Reset" /></td>
                            </tr>
                            <tr>
                                <td>Sign Up now as </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td><a href="donorRegistration.jsp">Donor</a></td>
                                <td><a href="adopt_reg.html">Adopt</a></td>
                            </tr>
                        </tbody>
                    </table>

                </form>
            </article></section>
    </center>
</body>
</html>
