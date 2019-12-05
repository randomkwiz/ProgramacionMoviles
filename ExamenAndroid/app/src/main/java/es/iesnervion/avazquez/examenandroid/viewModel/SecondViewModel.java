package es.iesnervion.avazquez.examenandroid.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import es.iesnervion.avazquez.examenandroid.R;
import es.iesnervion.avazquez.examenandroid.entities.Impresora;
import es.iesnervion.avazquez.examenandroid.entities.Ordenador;
import es.iesnervion.avazquez.examenandroid.entities.ProductoInformatico;

public class SecondViewModel extends ViewModel {

    MutableLiveData<String> opcionElegida;
    MutableLiveData<ProductoInformatico> productoSeleccionado;
    MutableLiveData<ArrayList<ProductoInformatico>> listaProductos;

    public SecondViewModel() {
        this.productoSeleccionado = new MutableLiveData<>();
        this.listaProductos = new MutableLiveData<>();
        this.opcionElegida = new MutableLiveData<>();
        cargarProductos();
    }

    //getters y setters
    public LiveData<String> getOpcionElegida(){
        if (this.opcionElegida == null){
            this.opcionElegida = new MutableLiveData<>();
        }
        return this.opcionElegida;
    }

    public void setOpcionElegida(String opcionElegida){
        this.opcionElegida.setValue(opcionElegida);
    }

    public LiveData<ProductoInformatico> getProductoSeleccionado(){
        if(this.productoSeleccionado == null){
            this.productoSeleccionado = new MutableLiveData<>();
        }
        return this.productoSeleccionado;
    }

    public void setProductoSeleccionado(ProductoInformatico productoSeleccionado){
        this.productoSeleccionado.setValue(productoSeleccionado);
    }

    public LiveData<ArrayList<ProductoInformatico>> getListaProductos(){
        if(this.listaProductos == null){
            this.listaProductos = new MutableLiveData<>();
        }
        return this.listaProductos;
    }

    public void setListaProductos(ArrayList<ProductoInformatico> listaProductos){
        this.listaProductos.setValue(listaProductos);
    }


    public void cargarProductos(){
        //Aqui cargo la lista
        ArrayList<ProductoInformatico> lista = new ArrayList<>();

        lista.add(new Impresora(1,true, R.drawable.hp5010,"HP 5010", "Tinta"));
        lista.add(new Ordenador(2,true, R.drawable.hp255g7, "HP 255 G7", R.drawable.amd));
        lista.add(new Impresora(3,false, R.drawable.canonts705,"Canon TS 705", "Laser"));
        lista.add(new Ordenador(4,true, R.drawable.acera315, "Acer A315", R.drawable.intel));

        listaProductos.setValue(lista);

    }
}
