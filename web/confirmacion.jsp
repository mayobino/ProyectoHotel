<html lang="es">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>Huésped cargado</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:200,400,700" rel="stylesheet">

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="cssError/style.css" />

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
                  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
                  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
                <![endif]-->

    </head>

    <body>

        <div id="notfound">
            <div class="notfound">
                <div class="notfound-404">
                    <h1>¡Bravo!</h1>
                    <h2>Huésped cargado correctamente</h2>
¿                </div>
                
                <p>Nombre: <%=session.getAttribute("nombre")%></p>
                <p>Apellido: <%=session.getAttribute("apellido")%></p>
                <p>Dni: <%=session.getAttribute("dni")%></p>
                <p>Fecha de Nacimiento: <%=session.getAttribute("fechaNac")%></p>
                <p>Dirección: <%=session.getAttribute("direccion")%></p>
                <p>Profesión: <%=session.getAttribute("profesion")%></p>

                <a href="index.jsp">Volver</a>
            </div>
        </div>

    </body>

</html>





