package es.iesnervion.avazquez.practicaroomfragments.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import es.iesnervion.avazquez.practicaroomfragments.R;
import es.iesnervion.avazquez.practicaroomfragments.room.AppDatabase;
import es.iesnervion.avazquez.practicaroomfragments.room.DAO.PersonaDAO;
import es.iesnervion.avazquez.practicaroomfragments.room.entities.Mascota;
import es.iesnervion.avazquez.practicaroomfragments.room.entities.Persona;
import es.iesnervion.avazquez.practicaroomfragments.room.entities.PersonaConMascota;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //DATABASE
        AppDatabase database = AppDatabase.getDatabase(this);

        /*Prueba: CRUD Persona*/

        Persona personaPrueba = new Persona("Angela", new GregorianCalendar(1997,6,23));

        Persona personaPrueba2 = new Persona("Angel", new GregorianCalendar(1992,0,12));



        int idPersona = (int)database.personaDAO().insertarPersona(personaPrueba);
        personaPrueba = database.personaDAO().getPersonaPorID(idPersona);

        int idPersona2 = (int)database.personaDAO().insertarPersona(personaPrueba2);
        personaPrueba2 = database.personaDAO().getPersonaPorID(idPersona2);


        personaPrueba.setIdPareja(idPersona2);
        personaPrueba2.setIdPareja(idPersona);

        database.personaDAO().updatePersonas(personaPrueba);
        database.personaDAO().updatePersonas(personaPrueba2);

        List<Persona> personas = database.personaDAO().getPersonas();
        //Hasta aqui bien. Se crean dos personas y se ponen mutuamente como pareja

        //Ahora creamos mascotas

        Mascota mascota1 = new Mascota("Keru", new GregorianCalendar(2015,2,23));

        int idMascota = (int) database.mascotaDAO().insertarMascota(mascota1);
        mascota1 = database.mascotaDAO().getMascotaPorID(idMascota);

        PersonaConMascota personaConMascota = new PersonaConMascota(personaPrueba.getId(), mascota1.getId());
        PersonaConMascota persona2ConMascota = new PersonaConMascota(personaPrueba2.getId(), mascota1.getId());

        database.personaConMascotaDAO().insertarPersonaConMascota(personaConMascota, persona2ConMascota);

        database.personaConMascotaDAO().getPersonaConMascotaPorIDMascota(mascota1.getId());

        //Hasta aqui tambien bien. Inserta una mascota y la relaciona con dos personas


    }
}
