package com.bosko.androidzadatak.entity.relations;

import androidx.lifecycle.LiveData;
import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.bosko.androidzadatak.entity.Korisnik;
import com.bosko.androidzadatak.entity.Zaposleni;

import java.util.List;

public class ZaposleniWithKorisnik {

    @Embedded
    private Zaposleni zaposleni;

    @Relation(parentColumn = "zaposleni_id", entityColumn = "korisnik_id", associateBy = @Junction(KorisnikZaposleniCross.class))
    public List<Korisnik> listaKorisnika;
}
