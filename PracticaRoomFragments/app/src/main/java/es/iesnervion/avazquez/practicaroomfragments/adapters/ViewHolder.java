package es.iesnervion.avazquez.practicaroomfragments.adapters;

import android.widget.TextView;

public class ViewHolder {
    private TextView nombrePersona;


    public ViewHolder(TextView nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public TextView getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(TextView nombrePersona) {
        this.nombrePersona = nombrePersona;
    }
}
