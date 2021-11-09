package Persistencia;

import Logica.Empleado;
import Logica.Huesped;
import Logica.Reserva;
import Logica.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    EmpleadoJpaController jpaEmpleado = new EmpleadoJpaController();
    HabitacionJpaController jpaHabitacion = new HabitacionJpaController();
    HuespedJpaController jpaHuesped = new HuespedJpaController();
    ReservaJpaController jpaReserva = new ReservaJpaController();
    UsuarioJpaController jpaUsuario = new UsuarioJpaController();

    //crear un usuario 
    public void crearUsuario(Usuario usuario) {

        jpaUsuario.create(usuario);
    }

    public List<Usuario> traerUsuarios() {

        return jpaUsuario.findUsuarioEntities();

    }

    //crear un empleado 
    public void crearEmpleado(Empleado empleado) throws Exception {

        jpaEmpleado.create(empleado);
    }

    public List<Huesped> traerHuesped() {

        return jpaHuesped.findHuespedEntities();

    }

    //dar de alta un huesped
    public void registroHuesped(Huesped huesped) throws Exception {

        jpaHuesped.create(huesped);
    }

    //buscar un huesped
    public Huesped buscarHuesped(int id) {

        return jpaHuesped.findHuesped(id);

    }
    
     public Usuario buscarEmpleado (int id) {

        return jpaUsuario.findUsuario(id);
    }
     
    //alta reserva

    public void registroReserva(Reserva reserva) {

        jpaReserva.create(reserva);

    }

    //modificar un huesped
    public void modificarHuesped(Huesped huesped) {

        try {
            jpaHuesped.edit(huesped);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //borrar un huesped
    public void borrarHuesped(int id) {

        try {
            jpaHuesped.destroy(id);
        } catch (NonexistentEntityException ex) {
            java.util.logging.Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
