package com.bosko.androidzadatak.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.bosko.androidzadatak.entity.Kupac;
import com.bosko.androidzadatak.entity.Zaposleni;

import java.util.List;

@Dao
public interface KupacDao {


    @Insert
    void insert(Kupac kupac);

    @Update
    void update(Kupac kupac);

    @Delete
    void delete(Kupac kupac);

    @Query("DELETE FROM kupac_table")
    void deleteAllKupac();

    @Query("SELECT * FROM kupac_table")
    LiveData<List<Kupac>> getAllKupac();
}
