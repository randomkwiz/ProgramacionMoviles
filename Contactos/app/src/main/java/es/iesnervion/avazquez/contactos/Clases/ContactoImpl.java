package es.iesnervion.avazquez.contactos.Clases;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;

import es.iesnervion.avazquez.contactos.Interfaces.Contacto;

public class ContactoImpl implements Contacto {
    private String nombre;
    private String apellidos;
    private GregorianCalendar fechaNacimiento;
    private String biografia;
    private int imgResource;

    public ContactoImpl(String nombre, String apellidos, GregorianCalendar fechaNacimiento, String biografia, int imgResource) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.biografia = biografia;
        this.imgResource = imgResource;
    }

    public ContactoImpl(String nombre, String apellidos, GregorianCalendar fechaNacimiento, String biografia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.biografia = biografia;
    }

    public ContactoImpl(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = new GregorianCalendar();
    }

    public ContactoImpl() {
        this.nombre = "DefaultName";
        this.apellidos = "DefaultLastName";
        this.fechaNacimiento = new GregorianCalendar();
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

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }


    //metodo añadido

    public String obtenerFechaNacimientoCorta(){
        String dateFormatted;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setCalendar(getFechaNacimiento());
        dateFormatted = sdf.format(getFechaNacimiento().getTime());

        return dateFormatted;

    }
}
