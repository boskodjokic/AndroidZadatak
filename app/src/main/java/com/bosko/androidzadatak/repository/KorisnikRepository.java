package com.bosko.androidzadatak.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.bosko.androidzadatak.ZadatakDatabase;
import com.bosko.androidzadatak.dao.KorisnikDao;
import com.bosko.androidzadatak.entity.Korisnik;

import java.util.List;

public class KorisnikRepository {

    private KorisnikDao korisnikDao;
    private LiveData<List<Korisnik>> allKorisnik;
    private LiveData<List<Korisnik>> listUser;
    private LiveData<List<Korisnik>> listPass;

    public KorisnikRepository(Application application) {
        ZadatakDatabase database = ZadatakDatabase.getInstance(application);
        korisnikDao = database.korisnikDao();
        allKorisnik = korisnikDao.getAllKorisnik();
    }

    public void insert(Korisnik korisnik) {
        new InsertKorisnikAsyncTask(korisnikDao).execute(korisnik);
    }

    public void update(Korisnik korisnik) {
        new UpdateKorisnikAsyncTask(korisnikDao).execute(korisnik);
    }

    public void delete(Korisnik korisnik) {
        new DeleteKorisnikAsyncTask(korisnikDao).execute(korisnik);
    }

    public LiveData<List<Korisnik>> listUser() { return listUser; }

    public LiveData<List<Korisnik>> listPass() {
        return listPass;
    }

    public void deleteAll() {
        new DeleteAllKorisnikAsyncTask(korisnikDao).execute();
    }

    public LiveData<List<Korisnik>> getAllKorisnik() {
        return allKorisnik;
    }

    private static class InsertKorisnikAsyncTask extends AsyncTask<Korisnik, Void, Void> {

        private KorisnikDao korisnikDao;

        private InsertKorisnikAsyncTask(KorisnikDao korisnikDao){
            this.korisnikDao = korisnikDao;
        }
        @Override
        protected Void doInBackground(Korisnik... korisniks) {
            korisnikDao.insert(korisniks[0]);
            return null;
        }
    }

    private static class UpdateKorisnikAsyncTask extends AsyncTask<Korisnik, Void, Void> {

        private KorisnikDao korisnikDao;

        private UpdateKorisnikAsyncTask(KorisnikDao korisnikDao){
            this.korisnikDao = korisnikDao;
        }
        @Override
        protected Void doInBackground(Korisnik... korisniks) {
            korisnikDao.update(korisniks[0]);
            return null;
        }
    }

    private static class DeleteKorisnikAsyncTask extends AsyncTask<Korisnik, Void, Void> {

        private KorisnikDao korisnikDao;

        private DeleteKorisnikAsyncTask(KorisnikDao korisnikDao){
            this.korisnikDao = korisnikDao;
        }
        @Override
        protected Void doInBackground(Korisnik... korisniks) {
            korisnikDao.delete(korisniks[0]);
            return null;
        }
    }

    private static class DeleteAllKorisnikAsyncTask extends AsyncTask<Void, Void, Void> {

        private KorisnikDao korisnikDao;

        private DeleteAllKorisnikAsyncTask(KorisnikDao korisnikDao){
            this.korisnikDao = korisnikDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            korisnikDao.deleteAllKorisnik();
            return null;
        }
    }

}
