package es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;

import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.entities.ContactImpl;

@Dao
public interface ContactDAO {

    @Insert
    public void insertContact(ContactImpl contact);

    @Insert
    public void insertContactList(ArrayList<ContactImpl> contactArrayList);

    @Query("SELECT * FROM Contactos")
    public ContactImpl[] cargarUsuarios();


    @Query("SELECT * FROM CONTACTOS " +
            " WHERE NOMBRE = :nombre " +
            "AND APELLIDOS = :apellidos " +
            " LIMIT 1 "
    )
    public ContactImpl obtenerContactoPorNombreYApellidos(String nombre, String apellidos);


    //con nombre || ' ' || apellidos no funciona

    @Query("SELECT * FROM CONTACTOS " +
            " WHERE nombre || ' ' || apellidos = :texto " +
            " LIMIT 1 "
    )
    public ContactImpl obtenerContactoPorNombre(String texto);

}
