package com.bosko.androidzadatak.entity;

import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.bosko.androidzadatak.MyTypeConverters;

import java.util.List;

@Entity(tableName = "magacin_table")
public class Magacin {

    @PrimaryKey(autoGenerate = true)
    private int magacin_id;

    private String name;

    @TypeConverters(MyTypeConverters.class)
    private List<Zaposleni> zaposleniList;


    public Magacin(String name, List<Zaposleni> zaposleniList) {
        this.name = name;
        this.zaposleniList = zaposleniList;
    }

    public void setId(int id) {
        this.magacin_id = id;
    }

    public String getName() {
        return name;
    }

    public int getMagacin_id() {
        return magacin_id;
    }

    public List<Zaposleni> getZaposleniList() {
        return zaposleniList;
    }

    public void setMagacin_id(int magacin_id) {
        this.magacin_id = magacin_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setZaposleniList(List<Zaposleni> zaposleniList) {
        this.zaposleniList = zaposleniList;
    }
}
