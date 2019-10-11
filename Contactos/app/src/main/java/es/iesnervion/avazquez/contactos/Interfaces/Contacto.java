package es.iesnervion.avazquez.contactos.Interfaces;

import java.util.GregorianCalendar;

public interface Contacto {

    public String getNombre();

    public void setNombre(String nombre);

    public String getApellidos();

    public void setApellidos(String apellidos);

    public GregorianCalendar getFechaNacimiento();

    public void setFechaNacimiento(GregorianCalendar fechaNacimiento);

    public String getBiografia();

    public void setBiografia(String biografia);

    public String getFoto();

    public void setFoto(String foto) ;
}
