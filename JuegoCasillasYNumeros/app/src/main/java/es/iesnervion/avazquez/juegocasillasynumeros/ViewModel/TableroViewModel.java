package es.iesnervion.avazquez.juegocasillasynumeros.ViewModel;

import android.app.Application;
import android.content.Context;
import android.util.SparseIntArray;


import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.AndroidViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import es.iesnervion.avazquez.juegocasillasynumeros.Utilidad.Utilidad;


public class TableroViewModel extends AndroidViewModel {

    private ConstraintLayout layout ;
    private int lado ;
    private Context context;
    private SparseIntArray mapeo = new SparseIntArray();

    public TableroViewModel(Application application, ConstraintLayout layout, int lado) {
        super(application);
        this.layout = layout;
        this.lado = lado;
        Utilidad utilidad = new Utilidad();
        utilidad.establecerTablero(layout,lado,application.getBaseContext(), mapeo);
    }

    public ConstraintLayout getLayout() {

        return layout;
    }

    public void setLayout(ConstraintLayout layout) {
        this.layout = layout;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public SparseIntArray getMapeo() {
        return mapeo;
    }

    public void setMapeo(SparseIntArray mapeo) {
        this.mapeo = mapeo;
    }
}
