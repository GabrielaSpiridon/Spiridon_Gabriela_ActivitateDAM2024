package com.example.seminar4;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Garsoniera.class}, version = 1)
public abstract class GarsonieraDatabase extends RoomDatabase {
    public abstract GarsonieraDAO garsonieraDAO();
}