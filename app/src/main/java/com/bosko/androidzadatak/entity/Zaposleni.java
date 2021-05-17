package com.bosko.androidzadatak.entity;

import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.bosko.androidzadatak.MyTypeConverters;

import java.util.List;

@Entity(tableName = "zaposleni_table")
public class Zaposleni {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "korisnik_id")
    private int zaposleni_id;

    private String name;

    private String surname;

    private String password;
    @TypeConverters(MyTypeConverters.class)
    private List<Kupac> kupacList;
    @TypeConverters(MyTypeConverters.class)
    private List<Magacin> magacinList;

    public Zaposleni(String name, String surname, String password, List<Kupac> kupacList, List<Magacin> magacinList) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.kupacList = kupacList;
        this.magacinList = magacinList;
    }

    public void setId(int id) {
        this.zaposleni_id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public List<Kupac> getKupacList() {
        return kupacList;
    }

    public List<Magacin> getMagacinList() {
        return magacinList;
    }

    public int getZaposleni_id() {
        return zaposleni_id;
    }

    public void setZaposleni_id(int zaposleni_id) {
        this.zaposleni_id = zaposleni_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setKupacList(List<Kupac> kupacList) {
        this.kupacList = kupacList;
    }

    public void setMagacinList(List<Magacin> magacinList) {
        this.magacinList = magacinList;
    }
}
