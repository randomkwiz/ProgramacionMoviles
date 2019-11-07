package es.iesnervion.avazquez.contactos.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import es.iesnervion.avazquez.contactos.Clases.ContactoImpl;
import es.iesnervion.avazquez.contactos.UtilidadesContactos;

public class MainViewModel extends ViewModel {
//En el ViewModel solo van los datos, todas las imagenes y los adaptadores se quedan en la activity
    private ArrayList<ContactoImpl> contactoArrayList = UtilidadesContactos.rellenarListaContactos();


    //hacerlo mas adelante con LiveData


    public ArrayList<ContactoImpl> getContactoArrayList() {
        return contactoArrayList;
    }

    public void setContactoArrayList(ArrayList<ContactoImpl> contactoArrayList) {
        this.contactoArrayList = contactoArrayList;
    }
}
