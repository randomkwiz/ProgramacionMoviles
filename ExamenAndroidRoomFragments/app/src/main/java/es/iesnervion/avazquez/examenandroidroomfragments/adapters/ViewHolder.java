package es.iesnervion.avazquez.examenandroidroomfragments.adapters;

import android.widget.TextView;

public class ViewHolder {
    private TextView nombreAtleta;


    public ViewHolder(TextView nombreAtleta) {
        this.nombreAtleta = nombreAtleta;
    }

    public TextView getNombreAtleta() {
        return nombreAtleta;
    }

    public void setNombreAtleta(TextView nombreAtleta) {
        this.nombreAtleta = nombreAtleta;
    }
}
