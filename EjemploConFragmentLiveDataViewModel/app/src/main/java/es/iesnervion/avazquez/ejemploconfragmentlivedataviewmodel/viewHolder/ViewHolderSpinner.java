package es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.viewHolder;

import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewHolderSpinner {
    private CircleImageView imagen;
    private TextView nombreCompleto;

    public ViewHolderSpinner(CircleImageView imagen, TextView nombreCompleto) {
        this.imagen = imagen;
        this.nombreCompleto = nombreCompleto;
    }

    public ViewHolderSpinner() {
    }

    public CircleImageView getImagen() {
        return imagen;
    }

    public void setImagen(CircleImageView imagen) {
        this.imagen = imagen;
    }

    public TextView getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(TextView nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}
