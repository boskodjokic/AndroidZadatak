package com.bosko.androidzadatak.entity.relations;

import androidx.lifecycle.LiveData;
import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.bosko.androidzadatak.entity.Magacin;
import com.bosko.androidzadatak.entity.Zaposleni;

import java.util.List;

public class MagacinWithZaposleni {

    @Embedded
    private Magacin magacin;

    @Relation(parentColumn = "magacin_id", entityColumn = "zaposleni_id", associateBy = @Junction(ZaposleniMagacinCross.class))
    private List<Zaposleni> listaZaposlenih;
}
