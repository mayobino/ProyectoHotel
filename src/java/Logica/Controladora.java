package Logica;

import Persistencia.ControladoraPersistencia;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearUsuario() {
        Usuario usuario = new Usuario(0, "Admin", "123");
        controlPersis.crearUsuario(usuario);
    }

    public void crearEmpleado() throws Exception {

    }

    public boolean comprobarIngreso(String usuario, String contrasenia) {

        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();

        if (listaUsuarios != null) {
            for (Usuario usu : listaUsuarios) {

                if (usu.getNombreUsuario().equals(usuario) && usu.getContrasenia().equals(contrasenia)) {

                    return true;
                }

            }
        }
        return false;
    }

    public void registroHuesped(String nombre, String apellido, String dni, String fechaNac, String direccion, String profesion) throws Exception {
        Huesped huesped = new Huesped();

        huesped.setNombre(nombre);
        huesped.setApellido(apellido);
        huesped.setDni(dni);
        Date fecha = deStringtoDate(fechaNac);
        huesped.setFechaNac(fecha);
        huesped.setDireccion(direccion);
        huesped.setProfesion(profesion);

        controlPersis.registroHuesped(huesped);
    }

    public List<Huesped> traerHuesped() {

        return controlPersis.traerHuesped();

    }

    public void borrarHuesped(int id) {

        controlPersis.borrarHuesped(id);

    }

    public Huesped buscarHuesped(int id) {

        return controlPersis.buscarHuesped(id);

    }

    public void modificarHuesped(Huesped huesped) {

        controlPersis.modificarHuesped(huesped);

    }

    public void registroReserva(String id_huesped, String fechaEntrada, String fechaSalida, String cantPersonas) {
        Reserva reserva = new Reserva();

        int idHuesped = Integer.valueOf(id_huesped.split("-")[0].trim());

        Huesped huesped = controlPersis.buscarHuesped(idHuesped);
        reserva.setId_huesped(huesped);

        Date fecha = deStringtoDate(fechaEntrada);
        reserva.setFechaEntrada(fecha);

        Date fechaUno = deStringtoDate(fechaSalida);
        reserva.setFechaSalida(fechaUno);

        reserva.setCantidadPersonas(Integer.parseInt(cantPersonas));

        controlPersis.registroReserva(reserva);
    }

    public static synchronized java.util.Date deStringtoDate(String fecha) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaEnviar = null;
        try {
            fechaEnviar = df.parse(fecha);
            return fechaEnviar;
        } catch (Exception ex) {
            System.out.println("Error - " + ex);
//            ex.printStackTrace();
            return null;

        }

    }

}
