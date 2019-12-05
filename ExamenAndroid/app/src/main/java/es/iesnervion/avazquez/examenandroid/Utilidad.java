package es.iesnervion.avazquez.examenandroid;

import android.provider.ContactsContract;

import java.util.ArrayList;

import es.iesnervion.avazquez.examenandroid.entities.Impresora;
import es.iesnervion.avazquez.examenandroid.entities.Ordenador;
import es.iesnervion.avazquez.examenandroid.entities.ProductoInformatico;

public class Utilidad {

    /* Dada una lista de productos informaticos, devuelve
    * una lista solo con impresoras*/
    public ArrayList<ProductoInformatico> obtenerSoloImpresoras(ArrayList<ProductoInformatico> listaCompleta){
        ArrayList<ProductoInformatico> lista = new ArrayList<>();
        Impresora elemento ;
        for(int i = 0; i < listaCompleta.size(); i ++){
            if(listaCompleta.get(i) instanceof Impresora){
                elemento = (Impresora) listaCompleta.get(i);
                lista.add(elemento);
            }
        }

        return lista;

    }

    /* Dada una lista de productos informaticos, devuelve
     * una lista solo con ordenadores*/
    public ArrayList<ProductoInformatico> obtenerSoloOrdenadores(ArrayList<ProductoInformatico> listaCompleta){
        ArrayList<ProductoInformatico> lista = new ArrayList<>();
        Ordenador elemento ;
        for(int i = 0; i < listaCompleta.size(); i ++){
            if(listaCompleta.get(i) instanceof Ordenador){
                elemento = (Ordenador) listaCompleta.get(i);
                lista.add(elemento);
            }
        }

        return lista;

    }


    /*Metodo para obtener la posicion de un elemento en una lista dada su ID*/
    public int obtenerPosicionPorIDEnLista(ArrayList<ProductoInformatico> lista, int idABuscar){
        int posicion = 0;
        boolean encontrado = false;
        for(int i =0; i < lista.size() && !encontrado; i ++){
            if(lista.get(i).getId() == idABuscar){
                encontrado = true;
                posicion = i;
            }
        }

    return posicion;
    }

    /*Metodo para eliminar ordenadores con procesador INTEL de una lista dada*/
    public ArrayList<ProductoInformatico> eliminarINTEL(ArrayList<ProductoInformatico> lista){
        ArrayList<ProductoInformatico> nuevaLista = new ArrayList<>();
        for(int i =0; i < lista.size(); i ++){
            if(lista.get(i) instanceof Ordenador ){
                if(((Ordenador)lista.get(i)).getImgCPU() != R.drawable.intel){
                    nuevaLista.add(lista.get(i));
                }
            }else{
                nuevaLista.add(lista.get(i));
            }
        }
        return nuevaLista;
    }


    /*Metodo para eliminar ordenadores con procesador AMD de una lista dada*/
    public ArrayList<ProductoInformatico> eliminarAMD(ArrayList<ProductoInformatico> lista){
        ArrayList<ProductoInformatico> nuevaLista = new ArrayList<>();
        for(int i =0; i < lista.size(); i ++){
            if(lista.get(i) instanceof Ordenador ){
                if(((Ordenador)lista.get(i)).getImgCPU() != R.drawable.amd){
                    nuevaLista.add(lista.get(i));
                }else{
                    nuevaLista.add(lista.get(i));
                }
            }
        }
        return nuevaLista;
    }
}
