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

@WebServlet(name = "SvCargarReserva", urlPatterns = {"/SvCargarReserva"})
public class SvCargarReserva extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvCargarReserva</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvCargarReserva at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //traigo los datos de la interfaz
        String id_huesped = request.getParameter("id_huesped");
        String fechaIngreso = request.getParameter("fechaIngreso");
        String fechaSalida = request.getParameter("fechaSalida");
        String cantidadPersonas = request.getParameter("cantidadPersonas");

        //traigo session y asigno atributos para poder abrir en cualquier JSP
        request.getSession().setAttribute("id_huesped", id_huesped);
        request.getSession().setAttribute("fechaIngreso", fechaIngreso);
        request.getSession().setAttribute("fechaSalida", fechaSalida);
        request.getSession().setAttribute("cantidadPersonas", cantidadPersonas);

        //conecto con la lógica        
        Controladora control = new Controladora();

        try {
            control.registroReserva(id_huesped, fechaIngreso, fechaSalida, cantidadPersonas);
        } catch (Exception ex) {
            Logger.getLogger(SvDatosReserva.class.getName()).log(Level.SEVERE, null, ex);
        }

        //armo la respuesta
        response.sendRedirect("confirmacion_reserva.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
