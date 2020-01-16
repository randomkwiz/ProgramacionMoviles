package es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import es.iesnervion.avazquez.ejemploconfragmentlivedataviewmodel.entities.ContactImpl;


@Database(entities = {ContactImpl.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ContactDAO contactDAO();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (AppDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "ContactosDB.db")
                            .allowMainThreadQueries()   //solo para pruebas
                            .build();
                }
            }
        }


        return INSTANCE;
    }
}
