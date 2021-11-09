
package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_reserva;
    
    @Temporal (TemporalType.DATE)
    private Date fechaEntrada; 
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    
    @Basic
    private int cantidadPersonas;
    
    @ManyToOne
    private Empleado id_usuario;
    @ManyToOne
    private Huesped id_huesped;
    @ManyToOne
    private Habitacion id_habitacion;

    public Reserva() {
    }

    public Reserva(int id_reserva, Date fechaEntrada, Date fechaSalida, int cantidadPersonas, Empleado id_usuario, Huesped id_huesped, Habitacion id_habitacion) {
        this.id_reserva = id_reserva;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cantidadPersonas = cantidadPersonas;
        this.id_usuario = id_usuario;
        this.id_huesped = id_huesped;
        this.id_habitacion = id_habitacion;
    }

    
    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public Empleado getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Empleado id_usuario) {
        this.id_usuario = id_usuario;
    }


    public Huesped getId_huesped() {
        return id_huesped;
    }

    public void setId_huesped(Huesped id_huesped) {
        this.id_huesped = id_huesped;
    }

    public Habitacion getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(Habitacion id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    void setId_huesped(String id_huesped) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
    
}
