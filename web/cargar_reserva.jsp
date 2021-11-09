<%-- 
    Document   : cargar_reserva
    Created on : Aug 8, 2021, 1:28:19 PM
    Author     : Admin
--%>

<%@page import="Logica.Reserva"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Huesped"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>Sistema de reservas</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Hind:400,700" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="cssReserva/bootstrap.min.css" />

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="cssReserva/style.css" />

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
                  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
                  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
                <![endif]-->

    </head>

    <body>
        <%
            HttpSession misession = request.getSession();
            Reserva reserva = (Reserva) misession.getAttribute("Reserva");

            Controladora control = new Controladora();
            List<Huesped> listaHuesped = control.traerHuesped();

        %>
        <div id="booking" class="section" style="background-image: url('images/minimalista.png');">
            <div class="section-center">
                <div class="container">
                    <div class="row">
                        <div class="booking-form">
                            <div class="form-header">
                                <h1>Sistema de reservas</h1>
                                <h3>HOTEL LOS FRESNOS</h3>
                            </div>
                            <!--<form action="SvCargarReserva" method="POST" onsubmit="return validateform()">-->
                            <form action="SvCargarReserva" method="POST">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <span class="form-label">Fecha de ingreso: </span>
                                            <input id="fechaIngreso" class="form-control" type="date" name="fechaIngreso" required>
                                            <!--<input class="form-control" type="date" name="fechaIngreso" required>-->
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <span class="form-label">Fecha de salida: </span>
                                            <input id="fechaSalida" class="form-control" type="date" name="fechaSalida" required>
                                            <!--<input class="form-control" type="date" name="fechaSalida" required>-->
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <span class="form-label">Huésped</span>

                                            <select class="form-control" name="id_huesped"> 
                                                <option>-</option>
                                                <%for (Huesped huesped : listaHuesped) {
                                                        String nombreComp = huesped.getId_persona() + " - " + huesped.getNombre() + " " + huesped.getApellido();%>
                                                <option><%=nombreComp%></option>
                                                <%}%>
                                            </select>
                                            <span class="select-arrow"></span>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <span class="form-label">Cantidad de personas: </span>

                                            <select class="form-control" name="cantidadPersonas">
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                            </select>
                                            <span class="select-arrow"></span>
                                        </div>
                                    </div>
                                    <div class="col-md-4">

                                    </div>
                                </div>
                                <div class="form-btn">
                                    <button class="submit-btn" value="submit" name="Cargar">Confirmar</button>
<!--                                    <button class="submit-btn" type="submit"><a href="ver_reservas.jsp">Ver Huéspedes</a></button>-->
                                    <button class="submit-btn" type="submit"><a href="home.jsp">Volver</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->
    
<!--    <script>
        function validateform() {
            fechaIngreso = document.getElementById('fechaIngreso').value;
            fechaSalida = document.getElementById('fechaSalida').value;

            validateDate = fechaSalida > fechaIngreso && fechaIngreso >= new Date();

            if (validateDate) {
                alert('Fechas inválidas');
            }
        }
    </script>-->
</html>