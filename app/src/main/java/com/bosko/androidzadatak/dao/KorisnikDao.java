package com.bosko.androidzadatak.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.bosko.androidzadatak.entity.Korisnik;
import com.bosko.androidzadatak.entity.Kupac;
import com.bosko.androidzadatak.entity.Zaposleni;

import java.util.List;

@Dao
public interface KorisnikDao {

    @Insert
    void insert(Korisnik korisnik);

    @Update
    void update(Korisnik korisnik);

    @Delete
    void delete(Korisnik korisnik);

    @Query("DELETE FROM KORISNIK_TABLE")
    void deleteAllKorisnik();

    @Query("SELECT * FROM korisnik_table")
    LiveData<List<Korisnik>> getAllKorisnik();


//    @Transaction
//    @Query("SELECT zaposleniList FROM KORISNIK_TABLE")
//    LiveData<List<Zaposleni>> getAllKorisnikZaposleni();

}
