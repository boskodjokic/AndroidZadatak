package com.bosko.androidzadatak.entity.relations;


import androidx.lifecycle.LiveData;
import androidx.room.Embedded;
import androidx.room.Relation;

import com.bosko.androidzadatak.entity.Kupac;
import com.bosko.androidzadatak.entity.Zaposleni;

import java.util.List;

public class ZaposleniKupac {

    @Embedded
    private Zaposleni zaposleni;

    @Relation(
            parentColumn = "zaposleni_id",
            entityColumn = "kupac_id"
    )
    public LiveData<List<Kupac>> listaKupaca;
}
