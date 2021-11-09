
package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvEliminar", urlPatterns = {"/SvEliminar"})
public class SvEliminar extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvEliminar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvEliminar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //traigo el id del jsp
        int id = Integer.parseInt(request.getParameter("id"));

       Controladora control = new Controladora ();
       control.borrarHuesped(id);
       
       //actualizo la lista de huespedes
       request.getSession().setAttribute("listaHuesped", control.traerHuesped());
       response.sendRedirect("ver_reservas.jsp");

    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
