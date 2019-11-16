package es.iesnervion.avazquez.juegocasillasynumeros.ViewModel;

import android.app.ActionBar;
import android.app.Application;
import android.content.Context;
import android.util.SparseIntArray;


import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.AndroidViewModel;

import es.iesnervion.avazquez.juegocasillasynumeros.Clases.Tablero;
import es.iesnervion.avazquez.juegocasillasynumeros.Utilidad.Utilidad;


public class TableroViewModel extends AndroidViewModel {

    private ConstraintLayout layout ;
    private Context context;
    private Tablero tablero;
    private SparseIntArray mapeo = new SparseIntArray();

    public TableroViewModel(Application application, ConstraintLayout layout, int lado) {
        super(application);
        this.layout = layout;
        this.tablero = new Tablero(lado);
        Utilidad utilidad = new Utilidad();
        utilidad.establecerTablero(layout,application.getBaseContext(), mapeo, tablero);
    }

    public ConstraintLayout getLayout() {

        return layout;
    }

    public void setLayout(ConstraintLayout layout) {
        this.layout = layout;
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

    public Tablero getTablero() {
        return tablero;
    }
}
