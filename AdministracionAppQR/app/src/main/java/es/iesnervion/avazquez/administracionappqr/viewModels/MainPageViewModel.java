package es.iesnervion.avazquez.administracionappqr.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MainPageViewModel extends ViewModel {

    MutableLiveData<String> itemSeleccionado;
    MutableLiveData<ArrayList<String>> listaItems;

    public MainPageViewModel() {
        this.itemSeleccionado = new MutableLiveData<>();
        this.listaItems = new MutableLiveData<>();
        cargarLista();
    }

    private void cargarLista() {
        ArrayList<String> lista = new ArrayList<>();

        //Una pregunta con cuatro respuestas posibles y sólo una correcta
        lista.add("Pregunta tipo test");

        //Una pregunta con cuatro respuestas posibles (que son imágenes) y sólo una correcta
        lista.add("Pregunta tipo test con imágenes");

        //Muestra un texto (sin imagen) y los alumnos responden en un folio
        lista.add("Pregunta de respuesta libre");

        //Muestra un texto y una imagen y los alumnos responden en un folio
        lista.add("Pregunta de imagen con respuesta libre");
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
