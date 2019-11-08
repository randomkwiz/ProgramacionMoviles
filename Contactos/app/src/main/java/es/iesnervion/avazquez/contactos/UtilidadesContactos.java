package es.iesnervion.avazquez.contactos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

import es.iesnervion.avazquez.contactos.Clases.ContactoImpl;
import es.iesnervion.avazquez.contactos.Interfaces.Contacto;

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

    public static ArrayList<ContactoImpl> rellenarListaContactos(){
        ArrayList<ContactoImpl> contactoArrayList = new ArrayList<>();
        contactoArrayList.add(new ContactoImpl("Angela","Vazquez Dominguez", new GregorianCalendar(1997, 6, 23), "Esta es mi biografia", R.drawable.femaleimg, true));
        contactoArrayList.add(new ContactoImpl("Նժդեհ", "Եղիազարյան", new GregorianCalendar(1990, 3, 15), "Սա իմ կենսագրությունն է", R.drawable.maleimg, true));
        contactoArrayList.add(new ContactoImpl("Pepito", "Perez Perez", new GregorianCalendar(1995, 2, 19), "Esta es mi biografia", R.drawable.redhairmale, false));
        contactoArrayList.add(new ContactoImpl("Maria Isabel", "Martin Gamarra", new GregorianCalendar(1997, 5, 28), "Esta es mi biografia", R.drawable.femaleimg, true));
        contactoArrayList.add(new ContactoImpl("Iván", "Moreno Romero", new GregorianCalendar(1996, 3, 4), "Esta es mi biografia", R.drawable.maleimg, true));
        contactoArrayList.add(new ContactoImpl("Gonzalo", "Gómez Alba", new GregorianCalendar(1997, 7, 15), "Esta es mi biografia", R.drawable.maleimg, true));
        contactoArrayList.add(new ContactoImpl("Angel", "Luna Duran", new GregorianCalendar(1992, 1, 12), "Esta es mi biografia", R.drawable.maleimg, true));
        contactoArrayList.add(new ContactoImpl("Miguel Angel", "Longa Garcia", false));
        contactoArrayList.add(new ContactoImpl("Joaquines", "Bello Hidalgo", false));
        contactoArrayList.add(new ContactoImpl("Ariana", "Bello Hidalgo", new GregorianCalendar(1993, 12, 25), "Esta es mi biografia", R.drawable.femaleimg, false));
        contactoArrayList.add(new ContactoImpl("Manuel", "Limon", new GregorianCalendar(1990, 5, 29), "Esta es mi biografia", R.drawable.maleimg, false));


        for(int i =0; i < 5000; i++){
            contactoArrayList.add(new ContactoImpl("Usu", "normal"));
        }
        //Collections.sort(contactoArrayList);
        return contactoArrayList;
    }

    public static void ordenarArrayListContactos(ArrayList<ContactoImpl> contactoArrayList){

        Collections.sort(contactoArrayList);    //lo ordeno segun el compareTo de ContactoImpl
    }
}
