package Logica;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Huesped extends Persona  {

    
    @Basic
    private String profesion;

    @OneToMany
    private List<Reserva> listaReservas;

    public Huesped() {
    }

    public Huesped(String profesion, List<Reserva> listaReservas, int id_persona, String dni, String nombre, String apellido, String direccion, Date fechaNac, Date empFechaNac) {
        super(id_persona, dni, nombre, apellido, direccion, fechaNac, empFechaNac);
        this.profesion = profesion;
        this.listaReservas = listaReservas;
    }

    @Override
    public int getId_persona() {
        return id_persona;
    }

    @Override
    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    
    @Override
    public String getDni() {
        return dni;
    }

    @Override
    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public Date getFechaNac() {
        return fechaNac;
    }

    @Override
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public Date getEmpFechaNac() {
        return empFechaNac;
    }

    @Override
    public void setEmpFechaNac(Date empFechaNac) {
        this.empFechaNac = empFechaNac;
    }
    
   
    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }


    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    
    

}
