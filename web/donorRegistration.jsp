<html>
    <head>
        <title>ORPHANAGE MANAGEMENT SYSTEM</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Register</title>
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
                var name = document.form.name.value;
                var address = document.form.address.value;
                var contactno = document.form.contactno.value;
                var username = document.form.username.value;
                var password = document.form.password.value;
                var conpassword = document.form.conpassword.value;

                if (name == null || name == "")
                {
                    alert("Name can't be blank");
                    return false;
                } else if (contactno == null || contactno == "")
                {
                    alert("Contact number can't be blank");
                    return false;
                } else if (address == null || address == "")
                {
                    alert("Address can't be blank");
                    return false;
                } else if (username == null || username == "")
                {
                    alert("Username can't be blank");
                    return false;
                } else if (password == null || password == "")
                {
                    alert("Password can't be blank");
                    return false;
                } else if (password != conpassword)
                {
                    alert("Confirm Password should match with the Password");
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
      <h3>Donor Sign Up</h3>
   </div>
    </header>

    <section>
        <article>
            <form name="form" action="DonorRegisterServlet" method="post" onsubmit="return validate()">
                <table >
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name" /></td>
                    </tr>
                    <tr>
                        <td>Contact No: </td>
                        <td><input type="text" name="contactno" value="" /></td>
                    </tr>
                    <tr>
                        <td>Address:</td>
                        <td><input type="text" name="address" /></td>
                    </tr>
                    <tr>
                        <td>Username:</td>
                        <td><input type="text" name="username" /></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password" /></td>
                    </tr>
                    <tr>
                        <td>Confirm Password:</td>
                        <td><input type="password" name="conpassword" /></td>
                    </tr>
                    <tr>
                            <td><%=(request.getAttribute("errMessage") == null) ? ""
                                : request.getAttribute("errMessage")%></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Register"></input>
                            <input type="reset" value="Reset"></input></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><a href="login.jsp" />Already have account?</a></td>
                    </tr>
                        
                </table>
            </form>
        </article>
    </section>
</body>
</html>