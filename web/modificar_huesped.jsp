<%-- 
    Document   : modificar_huesped
    Created on : Aug 6, 2021, 12:46:13 AM
    Author     : Admin
--%>


<%@page import="Logica.Huesped"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <!-- Required meta tags-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Colorlib Templates">
        <meta name="author" content="Colorlib">
        <meta name="keywords" content="Colorlib Templates">

        <!-- Title Page-->
        <title>Registro Huésped</title>

        <!-- Icons font CSS-->
        <link href="vendorHuesped/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
        <link href="vendorHuesped/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
        <!-- Font special for pages-->
        <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Vendor CSS-->
        <link href="vendorHuesped/select2/select2.min.css" rel="stylesheet" media="all">
        <link href="vendorHuesped/datepicker/daterangepicker.css" rel="stylesheet" media="all">

        <!-- Main CSS-->
        <link href="cssHuesped/main.css" rel="stylesheet" media="all">
    </head>

    <body>
        <%
            HttpSession misession = request.getSession();
            Huesped huesped = (Huesped) misession.getAttribute("Huesped");
        %>


        <div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
            <div class="wrapper wrapper--w680">
                <div class="card card-4">
                    <div class="card-body">
                        <h2 class="title">Editar huésped</h2>
                        <form action="SvModificar" method="GET">
                            <div class="row row-space">
                                <div class="col-2">
                                    <div class="input-group">
                                        <label class="label">Nombre</label>
                                        <input class="input--style-4" type="text" name="nombre" value="<%=huesped.getNombre()%>">
                                    </div>
                                </div>
                                <div class="col-2">
                                    <div class="input-group">
                                        <label class="label">Apellido</label>
                                        <input class="input--style-4" type="text" name="apellido" value="<%=huesped.getApellido()%>">
                                    </div>
                                </div>
                            </div>
                            <div class="row row-space">
                                <div class="col-2">
                                    <div class="input-group">
                                        <label class="label">Fecha de Nacimiento</label>
                                        <div class="input-group-icon">
                                            <input class="input--style-4 js-datepicker" type="text" name="fechaNac" value="<%=huesped.getFechaNac()%>">
                                            <i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="row row-space">
                                <div class="col-2">
                                    <div class="input-group">
                                        <label class="label">Profesión</label>
                                        <input class="input--style-4" type="text" name="profesion" value="<%=huesped.getProfesion()%>">
                                    </div>
                                </div>
                                <div class="col-2">
                                    <div class="input-group">
                                        <label class="label">DNI</label>
                                        <input class="input--style-4" type="text" name="dni" value="<%=huesped.getDni()%>">
                                    </div>
                                </div>
                            </div>


                            <div class="col-3">
                                <div class="input-group">
                                    <label class="label">Dirección</label>
                                    <input class="input--style-4" type="text" name="direccion" value="<%=huesped.getDireccion()%>">
                                </div>
                            </div>
                            <input type="hidden" name="id" value="<%=huesped.getId_persona()%>">
                            <li><a href="ver_reservas.jsp">Volver</a></li>
                            <input type="submit" value="Modificar">
                            </div>
                            </div>
                            </div>
                            </div>
   
                                </body>
                            </html>
                           