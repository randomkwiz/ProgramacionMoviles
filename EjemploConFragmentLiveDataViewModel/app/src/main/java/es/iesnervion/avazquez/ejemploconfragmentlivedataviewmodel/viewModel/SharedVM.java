package es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.AppDatabase;
import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.R;
import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.entities.ContactImpl;

public class SharedVM extends AndroidViewModel {    //hago extends androidviewmodel pq necesito el context

    private MutableLiveData<ArrayList<ContactImpl>> listaContactos ;
    private MutableLiveData<ContactImpl> contactoSeleccionado;
    private MutableLiveData<ContactImpl> contactoCreado;
    private GregorianCalendar fechaActual;
    private MutableLiveData<Boolean> isAddBtnPressed;

    //Constructor
    public SharedVM(@NonNull Application application) {
        super(application);

        this.listaContactos = new MutableLiveData<>();
        this.listaContactos.setValue(new ArrayList<ContactImpl>());
        cargarListaContactos();

        this.contactoSeleccionado = new MutableLiveData<>();
        this.contactoCreado = new MutableLiveData<>();
        this.fechaActual = new GregorianCalendar();
        this.isAddBtnPressed = new MutableLiveData<>();
        this.isAddBtnPressed.setValue(false);

    }

    //getters y setters

    public LiveData<Boolean> isAddBtnPressed(){
        if(this.isAddBtnPressed == null){
            this.isAddBtnPressed = new MutableLiveData<>();
        }
        return this.isAddBtnPressed;
    }
    public void setIsAddBtnPressed(Boolean isAddBtnPressed){
        this.isAddBtnPressed.setValue(isAddBtnPressed);
    }


    public LiveData<ContactImpl>getContactoCreado(){
        if(this.contactoCreado == null){
            this.contactoCreado = new MutableLiveData<>();
        }
        return this.contactoCreado;
    }
    public void setContactoCreado(ContactImpl contactoCreado){
        this.contactoCreado.setValue(contactoCreado);
    }


    public GregorianCalendar getFechaActual(){
        return this.fechaActual;
    }


    public LiveData<ContactImpl>getContactoSeleccionado(){
        if(this.contactoSeleccionado == null){
            this.contactoSeleccionado = new MutableLiveData<>();
        }
        return this.contactoSeleccionado;
    }

    public void setContactoSeleccionado(ContactImpl contactoSeleccionado){
        this.contactoSeleccionado.setValue(contactoSeleccionado);
    }

    public LiveData<ArrayList<ContactImpl>> getContactList(){
        if(this.listaContactos == null || this.listaContactos.getValue() == null){
            this.listaContactos = new MutableLiveData<>();

            cargarListaContactos();
        }

        return listaContactos;
    }

    public void setListaContactos(ArrayList<ContactImpl> listaContactos) {
        this.listaContactos.setValue(listaContactos);
    }

    //Metodo añadido
    public void cargarListaContactos() {

        ContactImpl contacts[] = AppDatabase.getDatabase(getApplication().getBaseContext()).contactDAO().cargarUsuarios();
        List<ContactImpl> contactList = Arrays.asList(contacts);
        ArrayList<ContactImpl> contactArrayList = new ArrayList<>(contactList);
        listaContactos.setValue(contactArrayList);

    }

}

