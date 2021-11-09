package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance (strategy=InheritanceType.TABLE_PER_CLASS)
public class Persona implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)       
    protected int id_persona;
            
    @Basic
     protected String dni;
     protected String nombre;
     protected String apellido;
     protected String direccion;
    
    @Temporal (TemporalType.DATE)
    protected Date fechaNac;
    
    @Temporal (TemporalType.DATE)
    protected Date empFechaNac;

    public Persona() {
    }

    public Persona(int id_persona, String dni, String nombre, String apellido, String direccion, Date fechaNac, Date empFechaNac) {
        this.id_persona = id_persona;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.fechaNac = fechaNac;
        this.empFechaNac = empFechaNac;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getEmpFechaNac() {
        return empFechaNac;
    }

    public void setEmpFechaNac(Date empFechaNac) {
        this.empFechaNac = empFechaNac;
    }

    
}
