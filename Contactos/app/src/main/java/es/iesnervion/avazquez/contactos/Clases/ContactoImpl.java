package es.iesnervion.avazquez.contactos.Clases;

import java.util.GregorianCalendar;

import es.iesnervion.avazquez.contactos.Interfaces.Contacto;

public class ContactoImpl implements Contacto {
    private String nombre;
    private String apellidos;
    private GregorianCalendar fechaNacimiento;
    private String biografia;
    private String foto;


    public ContactoImpl(String nombre, String apellidos, GregorianCalendar fechaNacimiento, String biografia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.biografia = biografia;
    }

    public ContactoImpl(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public ContactoImpl() {
        this.nombre = "";
        this.apellidos = "";
        this.fechaNacimiento = null;
        this.biografia = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
