package com.bosko.androidzadatak.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;


import com.bosko.androidzadatak.ZadatakDatabase;
import com.bosko.androidzadatak.dao.KorisnikDao;
import com.bosko.androidzadatak.dao.ZaposleniDao;
import com.bosko.androidzadatak.entity.Korisnik;
import com.bosko.androidzadatak.entity.Zaposleni;

import java.util.List;

public class ZaposleniRepository {

    private ZaposleniDao zaposleniDao;
    private LiveData<List<Zaposleni>> allZaposleni;
    private List<String> name;

public ZaposleniRepository(Application application) {
    ZadatakDatabase database = ZadatakDatabase.getInstance(application);
    zaposleniDao = database.zaposleniDao();
    allZaposleni = zaposleniDao.getAllZaposleni();
}


    public void insert(Zaposleni zaposleni) {
        new ZaposleniRepository.InsertZaposleniAsyncTask(zaposleniDao).execute(zaposleni);
    }

    public void update(Zaposleni zaposleni) {
        new ZaposleniRepository.UpdateZaposleniAsyncTask(zaposleniDao).execute(zaposleni);
    }

    public void delete(Zaposleni zaposleni) {
        new ZaposleniRepository.DeleteZaposleniAsyncTask(zaposleniDao).execute(zaposleni);
    }

    public void deleteAll() {
        new ZaposleniRepository.DeleteAllZaposleniAsyncTask(zaposleniDao).execute();
    }
    public List<String> getName() {
        return name;
    }

    public LiveData<List<Zaposleni>> getAllZaposleni() {
        return allZaposleni;
    }



    private static class InsertZaposleniAsyncTask extends AsyncTask<Zaposleni, Void, Void> {

        private ZaposleniDao zaposleniDao;

        private InsertZaposleniAsyncTask(ZaposleniDao zaposleniDao){
            this.zaposleniDao = zaposleniDao;
        }
        @Override
        protected Void doInBackground(Zaposleni... zaposlenis) {
            zaposleniDao.insert(zaposlenis[0]);
            return null;
        }
    }

    private static class UpdateZaposleniAsyncTask extends AsyncTask<Zaposleni, Void, Void> {

        private ZaposleniDao zaposleniDao;

        private UpdateZaposleniAsyncTask(ZaposleniDao zaposleniDao){
            this.zaposleniDao = zaposleniDao;
        }
        @Override
        protected Void doInBackground(Zaposleni... zaposlenis) {
            zaposleniDao.update(zaposlenis[0]);
            return null;
        }
    }

    private static class DeleteZaposleniAsyncTask extends AsyncTask<Zaposleni, Void, Void> {

        private ZaposleniDao zaposleniDao;

        private DeleteZaposleniAsyncTask(ZaposleniDao zaposleniDao){
            this.zaposleniDao = zaposleniDao;
        }
        @Override
        protected Void doInBackground(Zaposleni... zaposlenis) {
            zaposleniDao.delete(zaposlenis[0]);
            return null;
        }
    }

    private static class DeleteAllZaposleniAsyncTask extends AsyncTask<Void, Void, Void> {

        private ZaposleniDao zaposleniDao;

        private DeleteAllZaposleniAsyncTask(ZaposleniDao zaposleniDao){
            this.zaposleniDao = zaposleniDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            zaposleniDao.deleteAllZaposleni();
            return null;
        }
    }
}
