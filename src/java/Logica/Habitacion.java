package Logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Habitacion implements Serializable {

    @Id
    private int idHabitacion;

    @Basic
    private int pisoHabitacion;
    private String nombreHabitacion;
    private String tipoHabitacion;
    private double precioHabitacion;

    @OneToMany
    private List<Reserva> listaReservas;

    public Habitacion() {
    }

    public Habitacion(int idHabitacion, int pisoHabitacion, String nombreHabitacion, String tipoHabitacion, double precioHabitacion, List<Reserva> listaReservas) {
        this.idHabitacion = idHabitacion;
        this.pisoHabitacion = pisoHabitacion;
        this.nombreHabitacion = nombreHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.precioHabitacion = precioHabitacion;
        this.listaReservas = listaReservas;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getPisoHabitacion() {
        return pisoHabitacion;
    }

    public void setPisoHabitacion(int pisoHabitacion) {
        this.pisoHabitacion = pisoHabitacion;
    }

    public String getNombreHabitacion() {
        return nombreHabitacion;
    }

    public void setNombreHabitacion(String nombreHabitacion) {
        this.nombreHabitacion = nombreHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public double getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(double precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

}
