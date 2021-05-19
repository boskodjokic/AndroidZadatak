package com.bosko.androidzadatak.entity.relations;

import androidx.lifecycle.LiveData;
import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.bosko.androidzadatak.entity.Magacin;
import com.bosko.androidzadatak.entity.Zaposleni;

import java.util.List;

public class ZaposleniWithMagacin {

    @Embedded
    private Zaposleni zaposleni;

    @Relation(parentColumn = "zaposleni_id", entityColumn = "magacin_id", associateBy = @Junction(ZaposleniMagacinCross.class))
    private List<Magacin> listaMagacina;
}
