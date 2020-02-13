package es.iesnervion.avazquez.examenandroidroomfragments.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import es.iesnervion.avazquez.examenandroidroomfragments.room.DAOs.AtletaDAO;
import es.iesnervion.avazquez.examenandroidroomfragments.room.entities.Atleta;

@Database(entities = {Atleta.class},
        version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract AtletaDAO atletaDAO();


    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context){
        if(INSTANCE == null) {
            synchronized (AppDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "atletasDB.db")
                            .fallbackToDestructiveMigration()   //para que borre to cuando cambio algo y no pete por falta de migracion
                            .allowMainThreadQueries()   //solo pa proba
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
