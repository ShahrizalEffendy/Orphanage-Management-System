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
nav {
float: right;
width: 45%;
height: 400px; /* only for demonstration, should be removed */
background: #C0C5C6;
}
nav p{
margin: 50px;
padding-top: none;
}
article {
float: left;
padding: 20px;
width: 55%;
background-color:#C0C5C6;
height: 400px;
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
nav, article {
width: 100%;
height: auto;
}
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
      <h3>Admin Page</h3>
   </div>
  </header>
    
  <section>
    <nav>
    <p align="left" >
    <a href="child_registration.html"><button>New Child Registration</button></a><br><br>
    <a href="child_success.jsp"><button>Child Information</button></a><br><br>
    <a href="admin_info.jsp"><button>Admin Information</button></a><br><br>
    <a href="admin_registration.html"><button>New Admin Registration</button></a><br><br>
    <a href="donor_info.jsp"><button>Donor Information</button></a><br><br>
    <a href="donation_info.jsp"><button>Donation Information</button></a><br><br>
    <a href="adopt_info.jsp"><button>Adopt Information</button></a><br><br>
    <a href="adoption_info.jsp"><button>Adoption Information</button></a><br><br>
    </p>
    </nav>
      
    <article>
    <p align="left">    
    <h2>Welcome Administrator!</h2>
    </p>
    <a href="login.jsp"><button>Logout</button></a><br><br>    
    </article>
  </section>
</body>
</html>
