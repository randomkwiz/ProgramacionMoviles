package es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.viewModel;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.R;
import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.entities.ContactImpl;

public class SharedVM extends ViewModel {

    private MutableLiveData<ArrayList<ContactImpl>> listaContactos ;
    private MutableLiveData<ContactImpl> contactoSeleccionado;

    public SharedVM() {
        this.listaContactos = new MutableLiveData<>();
        cargarListaContactos();

        this.contactoSeleccionado = new MutableLiveData<>();
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
        if(this.listaContactos == null){
            this.listaContactos = new MutableLiveData<>();
            cargarListaContactos();
        }

        return listaContactos;
    }

    private void cargarListaContactos() {
        ArrayList<ContactImpl> contactList = new ArrayList<>();
        contactList.add(new ContactImpl("Angela","Vazquez Dominguez", new GregorianCalendar(1997, 6, 23), "Esta es mi biografia", R.drawable.femaleimg, true));
        contactList.add(new ContactImpl("Նժդեհ", "Եղիազարյան", new GregorianCalendar(1990, 3, 15), "Սա իմ կենսագրությունն է", R.drawable.maleimg, true));
        contactList.add(new ContactImpl("Pepito", "Perez Perez", new GregorianCalendar(1995, 2, 19), "Esta es mi biografia", R.drawable.redhairmale, false));
        contactList.add(new ContactImpl("Maria Isabel", "Martin Gamarra", new GregorianCalendar(1997, 5, 28), "Esta es mi biografia", R.drawable.femaleimg, true));
        contactList.add(new ContactImpl("Iván", "Moreno Romero", new GregorianCalendar(1996, 3, 4), "Esta es mi biografia", R.drawable.maleimg, true));
        contactList.add(new ContactImpl("Gonzalo", "Gómez Alba", new GregorianCalendar(1997, 7, 15), "Esta es mi biografia", R.drawable.maleimg, true));
        contactList.add(new ContactImpl("Angel", "Luna Duran", new GregorianCalendar(1992, 1, 12), "Esta es mi biografia", R.drawable.maleimg, true));
        contactList.add(new ContactImpl("Miguel Angel", "Longa Garcia", false));
        contactList.add(new ContactImpl("Joaquines", "Bello Hidalgo", false));
        contactList.add(new ContactImpl("Ariana", "Bello Hidalgo", new GregorianCalendar(1993, 12, 25), "Esta es mi biografia", R.drawable.femaleimg, false));
        contactList.add(new ContactImpl("Manuel", "Limon", new GregorianCalendar(1990, 5, 29), "Esta es mi biografia", R.drawable.maleimg, false));


        long seed = System.nanoTime();
        Collections.shuffle(contactList, new Random(seed));

        listaContactos.setValue(contactList);

    }

}

