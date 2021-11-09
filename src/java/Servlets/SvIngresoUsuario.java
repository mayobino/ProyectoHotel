package Servlets;


import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvIngresoUsuario", urlPatterns = {"/SvIngresoUsuario"})
public class SvIngresoUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }
    
     //creo una instancia a la controladora para conectarme con la logica
        Controladora control = new Controladora ();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //traerá el usuario y la contraseña que el empleado/a ingrese y me lo guardará en estas variables
        String usuario = request.getParameter("username");
        String contrasenia = request.getParameter("pass");
        
        //variable para verificar usuario y contraseña
        boolean estaONo;
 
        
        //asigno a la variable que verifica el usuario y la contraseña el control sobre eso
        estaONo = control.comprobarIngreso(usuario, contrasenia);
        
           //compruebo si dejo ingresar o no al usuario de acuerdo a los datos
        if (estaONo == true) {
            
            //verificar que exista una session, es decir, que haya puesto un usuario y contraseña efectivamente
            HttpSession misession = request.getSession(true);
            misession.setAttribute("usuario", usuario);
            misession.setAttribute("contrasenia", contrasenia);
            
            response.sendRedirect("home.jsp");
        }
         
        else {
            
            response.sendRedirect("index_error.jsp");
        }
        
    
        
        
        
    }

    
}
