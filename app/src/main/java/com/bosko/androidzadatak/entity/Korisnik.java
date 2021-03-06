package com.bosko.androidzadatak.entity;

import androidx.lifecycle.LiveData;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.bosko.androidzadatak.MyTypeConverters;

import java.util.List;

@Entity(tableName = "korisnik_table")
public class Korisnik {

    @PrimaryKey(autoGenerate = true)
    private int korisnik_id;
    private String name;
    private String user;
    private String password;
    @TypeConverters(MyTypeConverters.class)
    private List<Zaposleni> zaposleniList;
    @TypeConverters(MyTypeConverters.class)
    private List<Kupac> kupacList;

    public Korisnik() {
    }

    public Korisnik(String name, String user, String password, List<Zaposleni> zaposleniList, List<Kupac> kupacList) {
        this.name = name;
        this.user = user;
        this.password = password;
        this.zaposleniList = zaposleniList;
        this.kupacList = kupacList;
    }

    public int getKorisnik_id() {
        return korisnik_id;
    }

    public void setKorisnik_id(int korisnik_id) {
        this.korisnik_id = korisnik_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Zaposleni> getZaposleniList() {
        return zaposleniList;
    }

    public void setZaposleniList(List<Zaposleni> zaposleniList) {
        this.zaposleniList = zaposleniList;
    }

    public List<Kupac> getKupacList() {
        return kupacList;
    }

    public void setKupacList(List<Kupac> kupacList) {
        this.kupacList = kupacList;
    }
}
