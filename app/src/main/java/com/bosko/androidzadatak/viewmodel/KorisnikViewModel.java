package com.bosko.androidzadatak.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.bosko.androidzadatak.entity.Korisnik;
import com.bosko.androidzadatak.repository.KorisnikRepository;

import java.util.List;

public class KorisnikViewModel extends AndroidViewModel {

    private KorisnikRepository repository;
    private LiveData<List<Korisnik>> allKorisnik;


    public KorisnikViewModel(@NonNull Application application) {
        super(application);
        repository = new KorisnikRepository(application);
        allKorisnik = repository.getAllKorisnik();
    }

    public void insert(Korisnik korisnik) {
        repository.insert(korisnik);
    }



    public void update(Korisnik korisnik) {
        repository.update(korisnik);
    }

    public void delete(Korisnik korisnik) {
        repository.delete(korisnik);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public LiveData<List<Korisnik>> getAllKorisnik() {
        return allKorisnik;
    }
}
