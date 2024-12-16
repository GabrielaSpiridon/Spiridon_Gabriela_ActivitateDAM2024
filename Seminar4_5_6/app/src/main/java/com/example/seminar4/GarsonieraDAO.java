package com.example.seminar4;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface GarsonieraDAO {
    @Insert
    void insertGarsoniera(Garsoniera garsoniera);

    @Query("SELECT * FROM Garsoniera")
    List<Garsoniera> getAllGarsoniere();

    @Update
    void update(Garsoniera garsoniera);

    @Delete
    void delete(Garsoniera garsoniera);
}
