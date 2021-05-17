package com.bosko.androidzadatak.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.bosko.androidzadatak.entity.Korisnik;
import com.bosko.androidzadatak.entity.Zaposleni;

import java.util.List;

@Dao
public interface ZaposleniDao {

    @Insert
    void insert(Zaposleni zaposleni);

    @Update
    void update(Zaposleni zaposleni);

    @Delete
    void delete(Zaposleni zaposleni);

    @Query("DELETE FROM ZAPOSLENI_TABLE")
    void deleteAllZaposleni();

    @Query("SELECT * FROM zaposleni_table")
    LiveData<List<Zaposleni>> getAllZaposleni();
}
