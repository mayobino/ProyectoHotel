
package Servlets;

import Logica.Controladora;
import static Logica.Controladora.deStringtoDate;
import Logica.Huesped;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvModificar", urlPatterns = {"/SvModificar"})
public class SvModificar extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvModificar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvModificar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
             int id = Integer.parseInt(request.getParameter("id"));
             Controladora control = new Controladora ();
             //System.out.println(id);
             Huesped huesped = control.buscarHuesped (id);
             //System.out.println(huesped.getFechaNac());
             
             
             HttpSession misession = request.getSession();
             misession.setAttribute("Huesped", huesped);
             response.sendRedirect("modificar_huesped.jsp");
    }
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String fechaNac = request.getParameter("fechaNac");
        String direccion = request.getParameter("direccion");
        String profesion = request.getParameter("profesion");
        
        Controladora control = new Controladora ();
        Huesped huesped = control.buscarHuesped(id);
        huesped.setNombre(nombre);
        huesped.setApellido(apellido);
        huesped.setDni(dni);
        
        //String to date
        Date fecha = deStringtoDate(fechaNac);
        huesped.setFechaNac(fecha);
        
        huesped.setDireccion(direccion);
        huesped.setProfesion(profesion);
        
        control.modificarHuesped(huesped);
        
        //actualizo mi lista de huéspedes
        request.getSession().setAttribute("listaHuesped", control.traerHuesped());
        response.sendRedirect("ver_reservas.jsp");
    }

    
        

    
            
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
