package com.bosko.androidzadatak.entity.relations;

import androidx.room.Entity;

@Entity(primaryKeys = {"zaposleni_id", "magacin_id"})
public class ZaposleniMagacinCross {

    private int zaposleni_id;
    private int magacin_id;

    public ZaposleniMagacinCross(int zaposleni_id, int magacin_id) {
        this.zaposleni_id = zaposleni_id;
        this.magacin_id = magacin_id;
    }

    public int getZaposleni_id() {
        return zaposleni_id;
    }

    public void setZaposleni_id(int zaposleni_id) {
        this.zaposleni_id = zaposleni_id;
    }

    public int getMagacin_id() {
        return magacin_id;
    }

    public void setMagacin_id(int magacin_id) {
        this.magacin_id = magacin_id;
    }
}


