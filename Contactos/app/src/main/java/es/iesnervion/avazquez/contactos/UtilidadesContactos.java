package es.iesnervion.avazquez.contactos;

import java.util.ArrayList;

import es.iesnervion.avazquez.contactos.Clases.ContactoImpl;

public class UtilidadesContactos {

    public static ContactoImpl encontrarContactoPorNombreYApellidos(ArrayList<ContactoImpl> listaContactos, String nombreCompleto){
        ContactoImpl contactoBuscado = new ContactoImpl();
        String nombreCompletoEnLista;
        for(int i =0; i < listaContactos.size(); i++) {
            nombreCompletoEnLista = listaContactos.get(i).toString();
            if (nombreCompletoEnLista.equals(nombreCompleto)) {
                contactoBuscado = listaContactos.get(i);
            }
        }

        return contactoBuscado;
    }
}
