<%-- 
    Document   : confirmacion_reserva
    Created on : Aug 8, 2021, 3:52:26 PM
    Author     : Admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>Usuario no registrado</title>

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
                    <h2>Reserva cargada correctamente</h2>

                </div>
                <p>Huesped: <%=session.getAttribute("id_huesped")%></p>
                <p>Fecha ingreso: <%=session.getAttribute("fechaIngreso")%></p>
                <p>Fecha salida: <%=session.getAttribute("fechaSalida")%></p>

                <a href="login.jsp">Volver</a>
            </div>
        </div>

    </body>

</html>







