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
                background-color:#C0C5C6;
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
                nav, article {
                    width: 100%;
                    height: auto;
                }
            }
        </style>
    </head>
    <body>
        <header>   <div style="display: flex; align-items: center; justify-content: center;">
                <div style="position: absolute; left: 0;">
                    <a href="index.html"><img src="logo.jpg"></a>
                </div>
                <div>
                    <h2 style="text-align: center; margin: 0;">Orphanage Management System</h2>
                </div>
            </div>
            <div style="text-align: center;">
                <h3></h3>
            </div>
        </header>
                <section>

            <article>
                <h1>Notification</h1>
        <p> Congratulation! You have successfully adopt a child.</p>
        <p> <a href="login.jsp">Logout</a></p>
            </article>
        </section>

    </body>
</html>
