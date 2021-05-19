package com.bosko.androidzadatak.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.bosko.androidzadatak.entity.Korisnik;
import com.bosko.androidzadatak.entity.Zaposleni;
import com.bosko.androidzadatak.repository.ZaposleniRepository;

import java.util.List;

public class ZaposleniViewModel extends AndroidViewModel {

    private ZaposleniRepository repository;
    private LiveData<List<Zaposleni>> allZaposleni;
    private List<String> name;

    public ZaposleniViewModel(@NonNull Application application) {
        super(application);
        repository = new ZaposleniRepository(application);
        allZaposleni = repository.getAllZaposleni();
    }

    public void insert(Zaposleni zaposleni) { repository.insert(zaposleni);
    }

    public void update(Zaposleni zaposleni) {
        repository.update(zaposleni);
    }

    public void delete(Zaposleni zaposleni) {
        repository.delete(zaposleni);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public LiveData<List<Zaposleni>> getAllZaposleni() {
        return allZaposleni;
    }

    public List<String> getName() {
        return name;
    }

}
