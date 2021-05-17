package com.bosko.androidzadatak.entity.relations;

import androidx.room.Entity;

@Entity(primaryKeys = {"korisnik_id", "zaposleni_id"})
public class KorisnikZaposleniCross {

    private int korisnik_id;
    private int zaposleni_id;

    public KorisnikZaposleniCross(int korisnik_id, int zaposleni_id) {
        this.korisnik_id = korisnik_id;
        this.zaposleni_id = zaposleni_id;
    }

    public int getKorisnik_id() {
        return korisnik_id;
    }

    public void setKorisnik_id(int korisnik_id) {
        this.korisnik_id = korisnik_id;
    }

    public int getZaposleni_id() {
        return zaposleni_id;
    }

    public void setZaposleni_id(int zaposleni_id) {
        this.zaposleni_id = zaposleni_id;
    }
}
