package es.iesnervion.avazquez.exampleviewmodel_livedata.Utilidad;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class Utilidad {

    public static void cargarLista(MutableLiveData<ArrayList<String>> lista){
        lista.getValue().add("PHP");
        lista.getValue().add("Python");
        lista.getValue().add("C#");
    }
}
