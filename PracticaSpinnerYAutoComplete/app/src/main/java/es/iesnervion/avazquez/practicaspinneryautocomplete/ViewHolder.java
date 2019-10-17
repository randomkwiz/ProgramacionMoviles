package es.iesnervion.avazquez.practicaspinneryautocomplete;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    private TextView nombre;
    private ImageView imagen;

    public ViewHolder(TextView nombre, ImageView imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public ViewHolder() {
    }

    public TextView getNombre() {
        return nombre;
    }

    public void setNombre(TextView nombre) {
        this.nombre = nombre;
    }

    public ImageView getImagen() {
        return imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }
}
