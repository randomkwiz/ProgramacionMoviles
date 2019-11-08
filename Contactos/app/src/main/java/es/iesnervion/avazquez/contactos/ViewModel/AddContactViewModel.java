package es.iesnervion.avazquez.contactos.ViewModel;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import es.iesnervion.avazquez.contactos.Clases.ContactoImpl;
import es.iesnervion.avazquez.contactos.UtilidadesContactos;

public class AddContactViewModel extends ViewModel {

    private ContactoImpl contactoCreado;
    private ArrayList<ContactoImpl> contactoArrayList = UtilidadesContactos.rellenarListaContactos();
    private GregorianCalendar dateNow = new GregorianCalendar();    //me servira para definir la fecha maxima

    public ContactoImpl getContactoCreado() {
        return contactoCreado;
    }

    public void setContactoCreado(ContactoImpl contactoCreado) {
        this.contactoCreado = contactoCreado;
    }

    public ArrayList<ContactoImpl> getContactoArrayList() {
        return contactoArrayList;
    }

    public void setContactoArrayList(ArrayList<ContactoImpl> contactoArrayList) {
        this.contactoArrayList = contactoArrayList;
    }

    public GregorianCalendar getDateNow() {
        return dateNow;
    }

    public void setDateNow(GregorianCalendar dateNow) {
        this.dateNow = dateNow;
    }
}
