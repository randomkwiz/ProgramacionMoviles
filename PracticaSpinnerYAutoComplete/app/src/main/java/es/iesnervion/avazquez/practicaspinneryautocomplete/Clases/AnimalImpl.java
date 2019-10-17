package es.iesnervion.avazquez.practicaspinneryautocomplete.Clases;

import es.iesnervion.avazquez.practicaspinneryautocomplete.Interfaces.Animal;
import es.iesnervion.avazquez.practicaspinneryautocomplete.R;

public class AnimalImpl implements Animal {

    String nombre;
    int imagen;

    public AnimalImpl(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public AnimalImpl(String nombre) {
        this.nombre = nombre;
        this.imagen = R.drawable.dogbone;
    }

    public AnimalImpl() {
        this.nombre = "Default";
        this.imagen = R.drawable.dogbone;
    }

    //getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
