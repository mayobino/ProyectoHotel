
package Logica;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Empleado extends Persona   {
    
     
     @Basic
     private String cargo;
     
     @OneToOne
     private Usuario id_usuario;

    public Empleado() {
    }

    public Empleado(String cargo, Usuario id_usuario, int id_persona, String dni, String nombre, String apellido, String direccion, Date fechaNac, Date empFechaNac) {
        super(id_persona, dni, nombre, apellido, direccion, fechaNac, empFechaNac);
        this.cargo = cargo;
        this.id_usuario = id_usuario;
    }


    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    
    
}
