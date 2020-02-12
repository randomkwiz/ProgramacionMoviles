package es.iesnervion.avazquez.practicaroomfragments.room.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

import es.iesnervion.avazquez.practicaroomfragments.room.POJO.PersonaConRedesSociales;
import es.iesnervion.avazquez.practicaroomfragments.room.entities.Persona;
import es.iesnervion.avazquez.practicaroomfragments.room.entities.PersonaConMascota;

@Dao
public interface PersonaDAO {

    @Insert
    public long insertarPersona(Persona personas);

    @Update
    public void updatePersonas(Persona... personas);

    @Delete
    public void deletePersonas(Persona... personas);

    @Query("SELECT * FROM Persona WHERE id = :idPersona")
    public Persona getPersonaPorID(int idPersona);

    @Query("SELECT * FROM Persona")
    public List<Persona> getPersonas();

    //Uso el POJO aqui para que me traiga directamente todas las personas con toda la lista de sus redes sociales
    @Query("SELECT * FROM Persona")
    public List<PersonaConRedesSociales> getAllPersonasConRedesSociales();

    //Uso el POJO aqui para que me traiga directamente todas las personas con toda la lista de sus redes sociales
    @Query("SELECT * FROM Persona WHERE id = :idPersona")
    public PersonaConRedesSociales getPersonaConRedesSociales(int idPersona);
}
