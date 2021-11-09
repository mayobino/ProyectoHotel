package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvDatosReserva", urlPatterns = {"/SvDatosReserva"})
public class SvDatosReserva extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvDatosReserva</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvDatosReserva at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //traigo los datos del JSP
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String fechaNac = request.getParameter("fechaNac");
        String direccion = request.getParameter("direccion");
        String profesion = request.getParameter("profesion");
        

        //traigo la sesion y asigno atributos para abrir en cualquier JSP
        request.getSession().setAttribute("nombre", nombre);
        request.getSession().setAttribute("apellido", apellido);
        request.getSession().setAttribute("dni", dni);
        request.getSession().setAttribute("fechaNac", fechaNac);
        request.getSession().setAttribute("direccion", direccion);
        request.getSession().setAttribute("profesion", profesion);
      

        //conecto con logica
        Controladora control = new Controladora();   
       
        try {
            control.registroHuesped(nombre, apellido, dni, fechaNac, direccion, profesion);
        } catch (Exception ex) {
            Logger.getLogger(SvDatosReserva.class.getName()).log(Level.SEVERE, null, ex);
        }

        //armo la respuesta
        response.sendRedirect("confirmacion.jsp");

    }

}
