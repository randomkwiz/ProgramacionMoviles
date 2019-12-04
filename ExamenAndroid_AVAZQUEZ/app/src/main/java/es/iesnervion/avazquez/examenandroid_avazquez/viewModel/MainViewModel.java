package es.iesnervion.avazquez.examenandroid_avazquez.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Object>> lista ;
    private MutableLiveData<Object> elemento;

    //Constructor
    public MainViewModel() {
        this.lista = new MutableLiveData<>();
        this.elemento = new MutableLiveData<>();
    }
    //getters y setters
    public LiveData<Object>getElemento(){
        if(this.elemento == null){
            this.elemento = new MutableLiveData<>();
        }
        return this.elemento;
    }

    public void setElemento(Object elemento){
        this.elemento.setValue(elemento);
    }


    //Getter y setter lista
    public LiveData<ArrayList<Object>> getList(){
        if(this.lista == null){
            this.lista = new MutableLiveData<>();

        }

        return this.lista;
    }

    public void setList(ArrayList<Object> lista) {
        this.lista.setValue(lista);
    }

    /*Si haces un método de cargarLista, no olvides poner el setValue al final*/
}
