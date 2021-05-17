package com.bosko.androidzadatak;


import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.bosko.androidzadatak.entity.Kupac;
import com.bosko.androidzadatak.entity.Magacin;
import com.bosko.androidzadatak.entity.Zaposleni;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class MyTypeConverters {

    @TypeConverter
    public String fromZaposleniList(List<Zaposleni> zaposleniList) {
        if (zaposleniList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Zaposleni>>() {}.getType();
        String json = gson.toJson(zaposleniList, type);
        return json;
    }

    @TypeConverter
    public List<Zaposleni> toZaposleniList(String zaposleniListString) {
        if (zaposleniListString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Zaposleni>>() {}.getType();
        List<Zaposleni> zaposleniList = gson.fromJson(zaposleniListString, type);
        return zaposleniList;
    }

    @TypeConverter
    public String fromKupacList(List<Kupac> kupacList) {
        if (kupacList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Kupac>>() {}.getType();
        String json = gson.toJson(kupacList, type);
        return json;
    }

    @TypeConverter
    public List<Kupac> toKupacList(String kupacListString) {
        if (kupacListString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Kupac>>() {}.getType();
        List<Kupac> kupacList = gson.fromJson(kupacListString, type);
        return kupacList;
    }

    @TypeConverter
    public String fromMagacinList(List<Magacin> magacinList) {
        if (magacinList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Magacin>>() {}.getType();
        String json = gson.toJson(magacinList, type);
        return json;
    }

    @TypeConverter
    public List<Magacin> toMagacinList(String magacinListString) {
        if (magacinListString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Magacin>>() {}.getType();
        List<Magacin> magacinList = gson.fromJson(magacinListString, type);
        return magacinList;
    }

}
