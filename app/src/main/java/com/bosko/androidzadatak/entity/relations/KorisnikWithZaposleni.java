package com.bosko.androidzadatak.entity.relations;

import androidx.lifecycle.LiveData;
import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.bosko.androidzadatak.entity.Korisnik;
import com.bosko.androidzadatak.entity.Zaposleni;

import java.util.List;

public class KorisnikWithZaposleni {

    @Embedded
    private Korisnik korisnik;

    @Relation(parentColumn = "korisnik_id", entityColumn = "zaposleni_id", associateBy = @Junction(KorisnikZaposleniCross.class))
    public LiveData<List<Zaposleni>> listaZaposlenih;
}
