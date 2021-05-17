package com.bosko.androidzadatak.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.bosko.androidzadatak.MyTypeConverters;

import java.util.List;

@Entity(tableName = "kupac_table")
public class Kupac {

    @PrimaryKey(autoGenerate = true)
    private int kupac_id;

    private String name;

    private String pib;

    private String sifra;
    @TypeConverters(MyTypeConverters.class)
    private List<Zaposleni> zaposleniList;


    public Kupac(String name, String pib, String sifra, List<Zaposleni> zaposleniList) {
        this.name = name;
        this.pib = pib;
        this.sifra = sifra;
        this.zaposleniList = zaposleniList;
    }

    public void setId(int id) {
        this.kupac_id = id;
    }

    public String getName() {
        return name;
    }

    public String getPib() {
        return pib;
    }

    public String getSifra() {
        return sifra;
    }

    public int getKupac_id() {
        return kupac_id;
    }

    public List<Zaposleni> getZaposleniList() {
        return zaposleniList;
    }

    public void setKupac_id(int kupac_id) {
        this.kupac_id = kupac_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public void setZaposleniList(List<Zaposleni> zaposleniList) {
        this.zaposleniList = zaposleniList;
    }
}
