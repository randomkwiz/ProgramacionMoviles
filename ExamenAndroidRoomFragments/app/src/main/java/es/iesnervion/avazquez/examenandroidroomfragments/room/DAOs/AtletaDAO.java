package es.iesnervion.avazquez.examenandroidroomfragments.room.DAOs;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import es.iesnervion.avazquez.examenandroidroomfragments.room.entities.Atleta;

@Dao
public interface AtletaDAO {

    @Insert
    public long insertarAtleta(Atleta atleta);

    @Query("SELECT * FROM Atleta")
    public LiveData<List<Atleta>> getAllAtletasLD();

    @Query("SELECT * FROM Atleta")
    public List<Atleta> getAllAtletas();

    @Query("SELECT * FROM Atleta where id = :idAtleta")
    public LiveData<Atleta> getAtletaLD(int idAtleta);

    @Query("SELECT * FROM Atleta where id = :idAtleta")
    public Atleta getAtleta(int idAtleta);

}
