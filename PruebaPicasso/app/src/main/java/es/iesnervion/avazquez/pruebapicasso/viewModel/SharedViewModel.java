package es.iesnervion.avazquez.pruebapicasso.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<ArrayList<String>> listaURLs;
    private MutableLiveData<String> razaElegida;

    //Constructor
    public SharedViewModel() {
        this.listaURLs = new MutableLiveData<>();
        this.razaElegida = new MutableLiveData<>();
    }

    //getters y setters
    public LiveData<String> getRazaElegida(){
        if(this.razaElegida == null){
            this.razaElegida = new MutableLiveData<>();
        }
        return this.razaElegida;
    }

    public void setRazaElegida(String razaElegida){
        this.razaElegida.setValue(razaElegida);
    }

    public LiveData<ArrayList<String>> getListaURLs(){
        if(this.listaURLs == null){
            this.listaURLs = new MutableLiveData<>();
            cargarListaURLs();
        }

        return this.listaURLs;
    }

    private void cargarListaURLs() {
        //TODO this
    }


}
