package es.iesnervion.avazquez.contactos.Clases;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;

import es.iesnervion.avazquez.contactos.Interfaces.Contacto;
import es.iesnervion.avazquez.contactos.R;

public class ContactoImpl implements Contacto,
        Comparable,
        Serializable    //esto es pa pasar un obj a otra actividad, para hacer el Master/Details

{
    private String nombre = "DefaultName";
    private String apellidos = "Default Surname";
    private GregorianCalendar fechaNacimiento = new GregorianCalendar(1900, 0, 1);
    private String biografia = "";
    private int imgResource = R.drawable.imgdefault;
    private boolean isFavorito = false;

    public ContactoImpl(String nombre, String apellidos, GregorianCalendar fechaNacimiento, String biografia, int imgResource) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.biografia = biografia;
        this.imgResource = imgResource;
    }

    public ContactoImpl(String nombre, String apellidos, GregorianCalendar fechaNacimiento, String biografia, int imgResource, boolean isFavorito) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.biografia = biografia;
        this.imgResource = imgResource;
        this.isFavorito = isFavorito;
    }

    public ContactoImpl(String nombre, String apellidos, boolean isFavorito) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.isFavorito = isFavorito;
    }

    public ContactoImpl() {
    }

    public ContactoImpl(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public ContactoImpl(String nombre, String apellidos, GregorianCalendar fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    public ContactoImpl(String nombre, String apellidos, GregorianCalendar fechaNacimiento, int imgResource) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.imgResource = imgResource;
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

    public boolean isFavorito() {
        return isFavorito;
    }

    public void setFavorito(boolean favorito) {
        isFavorito = favorito;
    }

    //metodo añadido

    public String obtenerFechaNacimientoCorta(){
        String dateFormatted;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setCalendar(getFechaNacimiento());
        dateFormatted = sdf.format(getFechaNacimiento().getTime());

        return dateFormatted;

    }


    @Override
    public int compareTo(Object o) {
        int resultado = 0;
        if(o != null){
        if(o instanceof ContactoImpl){
                ContactoImpl otro = (ContactoImpl) o;
                resultado = this.getNombre().compareTo(otro.getNombre());

            }
        }
        return resultado;
    }
}
