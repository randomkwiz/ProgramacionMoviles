package es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.viewHolder;

import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewHolder {

    CircleImageView fotoContacto;
    TextView nombreContacto;
    TextView apellidosContacto;
    TextView fechaNacimientoContacto;

    public ViewHolder(CircleImageView fotoContacto, TextView nombreContacto, TextView apellidosContacto, TextView fechaNacimientoContacto) {
        this.fotoContacto = fotoContacto;
        this.nombreContacto = nombreContacto;
        this.apellidosContacto = apellidosContacto;
        this.fechaNacimientoContacto = fechaNacimientoContacto;
    }

    public CircleImageView getFotoContacto() {
        return fotoContacto;
    }

    public TextView getNombreContacto() {
        return nombreContacto;
    }

    public TextView getApellidosContacto() {
        return apellidosContacto;
    }

    public TextView getFechaNacimientoContacto() {
        return fechaNacimientoContacto;
    }
}
