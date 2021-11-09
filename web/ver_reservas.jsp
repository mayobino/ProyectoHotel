

<%@page import="Logica.Huesped"%>
<%@page import="Logica.Reserva"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Persona"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Table V05</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="imagesTabla/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendorTabla/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fontsTabla/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendorTabla/animate/animate.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendorTabla/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendorTabla/perfect-scrollbar/perfect-scrollbar.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="cssTabla/util.css">
        <link rel="stylesheet" type="text/css" href="cssTabla/main.css">
        <!--===============================================================================================-->
    <head>
        <title>Table V05</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    </head>
    <body>

        <div class="limiter">
            <div class="container-table100">
                <div class="wrap-table100">
                    <div class="table100 ver1">
                        <div class="table100-firstcol">
                            <table>
                                <thead>
                                    <tr class="row100 head">
                                        <th class="cell100 column1">Huéspedes</th>
                                        <th class="cell100 column2">Profesión</th>
                                        <th class="cell100 column3">Editar</th>
                                        <th class="cell100 column4">Eliminar</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <%

                                        Controladora control = new Controladora();
                                        List<Huesped> listaHuesped = control.traerHuesped();
                                        for (Huesped huesped : listaHuesped) {
                                    %>
                                    <tr class="row100 body">
                                        <%String nombreComp = huesped.getNombre() + " " + huesped.getApellido();%>
                                        <td class="cell100 column1"><%=nombreComp%></td>

                                        <%String profesion = huesped.getProfesion();%>
                                        <td class="cell100 column2"><%=profesion%></td>

                                        <%int id = huesped.getId_persona();%>
                                        <td class="cell100 column3">
                                            <form name="frmEditarHuesped" action="SvModificar" method="post" style="display:inline">   
                                                <input type="hidden" name="id" value="<%=id%>">
                                                <button type="submit" name="editar" class="btn btn-primary" data-title="Edit" style="display:inline">Editar</button>
                                            </form>
                                        </td>

                                        <td class="cell100 column4">
                                            <form name="frmEliminarHuesped" action="SvEliminar" method="post" style="display:inline">   
                                                <input type="hidden" name="id" value="<%=id%>">
                                                <button type="submit" class="btn btn-danger" data-title="Edit" style="display:inline">Eliminar</button>
                                            </form>
                                    </tr>
                                    <% }%>
                                   
                                </tbody>
                            </table>
                        </div>

                    </div>
                   

                </div>
                                     <button type="button" class="btn btn-light"><a href="home.jsp">Volver</a></button>
            </div>
        </div>






        <!--===============================================================================================-->	
        <script src="vendorTabla/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendorTabla/bootstrap/js/popper.js"></script>
        <script src="vendorTabla/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendorTabla/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendorTabla/perfect-scrollbar/perfect-scrollbar.min.js"></script>
        <script>
            $('.js-pscroll').each(function () {
                var ps = new PerfectScrollbar(this);

                $(window).on('resize', function () {
                    ps.update();
                });

                $(this).on('ps-x-reach-start', function () {
                    $(this).parent().find('.table100-firstcol').removeClass('shadow-table100-firstcol');
                });

                $(this).on('ps-scroll-x', function () {
                    $(this).parent().find('.table100-firstcol').addClass('shadow-table100-firstcol');
                });

            });




        </script>
        <!--===============================================================================================-->
        <script src="jsTabla/main.js"></script>

    </body>
</html>
