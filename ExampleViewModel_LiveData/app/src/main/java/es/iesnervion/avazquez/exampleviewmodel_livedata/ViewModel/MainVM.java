package es.iesnervion.avazquez.exampleviewmodel_livedata.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import es.iesnervion.avazquez.exampleviewmodel_livedata.Utilidad.Utilidad;


public class MainVM extends ViewModel {

    //El live data sera una lista de strings
    private MutableLiveData<ArrayList<String>> lista ;


    //getter
    public LiveData<ArrayList<String>> getLista(){
        if(this.lista == null){
            lista = new MutableLiveData<>();
            //inisialisa las cosas
            lista.setValue(new ArrayList<String>());
            Utilidad.cargarLista(lista);

        }
        return lista;
    }

    public void setLista(ArrayList<String> lista){
        this.lista.setValue(lista);
    }


}
