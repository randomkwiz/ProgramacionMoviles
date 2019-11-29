package es.iesnervion.avazquez.centroeducativo.entities;

import java.util.GregorianCalendar;

import es.iesnervion.avazquez.centroeducativo.R;

public abstract class Persona {
    private String nombre;
    private String apellido;
    private int imgSrc;
    private GregorianCalendar fechaNacimiento;
    private boolean isFavorito;

    //Constructores


    public Persona() {
    }

    public Persona(String nombre, String apellido, int imgSrc, boolean isFavorito) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.imgSrc = imgSrc;
        this.fechaNacimiento = new GregorianCalendar(1900,0,1);
        this.isFavorito = isFavorito;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
        this.apellido = "";
        this.fechaNacimiento = new GregorianCalendar(1900,0,1);
        this.imgSrc = R.drawable.user;
        this.isFavorito = false;
    }

    public Persona(String nombre, String apellido, int imgSrc) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.imgSrc = imgSrc;
        this.fechaNacimiento = new GregorianCalendar(1900,0,1);
        this.isFavorito = false;
    }

    public Persona(String nombre, String apellido, int imgSrc, GregorianCalendar fechaNacimiento, boolean isFavorito) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.imgSrc = imgSrc;
        this.fechaNacimiento = fechaNacimiento;
        this.isFavorito = isFavorito;
    }

    //Getters y setters
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

    public int getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(int imgSrc) {
        this.imgSrc = imgSrc;
    }

    public boolean isFavorito() {
        return isFavorito;
    }

    public void setFavorito(boolean favorito) {
        isFavorito = favorito;
    }

    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
