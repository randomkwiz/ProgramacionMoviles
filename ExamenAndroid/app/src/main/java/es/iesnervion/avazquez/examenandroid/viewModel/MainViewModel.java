package es.iesnervion.avazquez.examenandroid.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import es.iesnervion.avazquez.examenandroid.entities.ProductoInformatico;

public class MainViewModel extends ViewModel {

    MutableLiveData<String> itemSeleccionado;
    MutableLiveData<ArrayList<String>> listaItems;

    public MainViewModel() {
        this.itemSeleccionado = new MutableLiveData<>();
        this.listaItems = new MutableLiveData<>();
        cargarLista();
    }

    private void cargarLista() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Impresoras");
        lista.add("Portátiles");
        lista.add("Todo");
        setListaItems(lista);
    }

    public LiveData<String> getItemSeleccionado() {
        if(this.itemSeleccionado == null){
            this.itemSeleccionado = new MutableLiveData<>();
        }
        return itemSeleccionado;
    }

    public void setItemSeleccionado(String itemSeleccionado) {
        this.itemSeleccionado.setValue(itemSeleccionado);
    }

    public LiveData<ArrayList<String>> getListaItems() {
        if(this.listaItems == null){
            this.listaItems = new MutableLiveData<>();
        }
        return listaItems;
    }

    public void setListaItems(ArrayList<String> listaItems) {
        this.listaItems.setValue(listaItems);
    }
}
