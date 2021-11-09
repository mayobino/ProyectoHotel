
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            String usu = (String) misession.getAttribute("usuario");

            if (usu == null) {
                response.sendRedirect("sin_usuario.jsp");
            } else {
        %>

        <div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
            <div class="wrapper wrapper--w680">
                <div class="card card-4">
                    <div class="card-body">
                        <h2 class="title">Registro de huésped</h2>
                        <form action="SvDatosReserva" method="POST">
                            <div class="row row-space">
                                <div class="col-2">
                                    <div class="input-group">
                                        <label class="label">Nombre</label>
                                        <input class="input--style-4" type="text" name="nombre">
                                    </div>
                                </div>
                                <div class="col-2">
                                    <div class="input-group">
                                        <label class="label">Apellido</label>
                                        <input class="input--style-4" type="text" name="apellido">
                                    </div>
                                </div>
                            </div>
                            <div class="row row-space">
                                <div class="col-2">
                                    <div class="input-group">
                                        <label class="label">Fecha de Nacimiento</label>
                                        <div class="input-group-icon">
                                            <input class="input--style-4 js-datepicker" type="text" name="fechaNac">
                                            <i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="row row-space">
                                <div class="col-2">
                                    <div class="input-group">
                                        <label class="label">Profesión</label>
                                        <input class="input--style-4" type="text" name="profesion">
                                    </div>
                                </div>
                                <div class="col-2">
                                    <div class="input-group">
                                        <label class="label">DNI</label>
                                        <input class="input--style-4" type="text" name="dni">
                                    </div>
                                </div>
                            </div>


                            <div class="col-3">
                                <div class="input-group">
                                    <label class="label">Dirección</label>
                                    <input class="input--style-4" type="text" name="direccion">
                                </div>
                            </div>

                    </div>

                </div>
                <div class="p-t-15">
                    <button class="btn btn--radius-2 btn--blue" type="submit" name="Cargar">Confirmar</button>
                    <button class="btn btn--radius-2 btn--blue" type="submit"><a href="home.jsp">Volver</a></button>
                    
                    </button>

                </div>

                </form>
            </div>
        </div>
    </div>

</div>

<!-- Jquery JS-->
<script src="vendorHuesped/jquery/jquery.min.js"></script>
<!-- Vendor JS-->
<script src="vendorHuesped/select2/select2.min.js"></script>
<script src="vendorHuesped/datepicker/moment.min.js"></script>
<script src="vendorHuesped/datepicker/daterangepicker.js"></script>

<!-- Main JS-->
<script src="jsHuesped/global.js"></script>
<%}%> 
</body>
</html>
