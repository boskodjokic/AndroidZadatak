package com.bosko.androidzadatak;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.bosko.androidzadatak.dao.KorisnikDao;
import com.bosko.androidzadatak.dao.KorisnikZaposleniDao;
import com.bosko.androidzadatak.dao.KupacDao;
import com.bosko.androidzadatak.dao.MagacinDao;
import com.bosko.androidzadatak.dao.ZaposleniDao;
import com.bosko.androidzadatak.dao.ZaposleniMagacinDao;
import com.bosko.androidzadatak.entity.Korisnik;
import com.bosko.androidzadatak.entity.Kupac;
import com.bosko.androidzadatak.entity.Magacin;
import com.bosko.androidzadatak.entity.Zaposleni;
import com.bosko.androidzadatak.entity.relations.KorisnikZaposleniCross;
import com.bosko.androidzadatak.entity.relations.ZaposleniMagacinCross;

import java.util.Arrays;


@Database(entities = {
        Korisnik.class,
        Kupac.class,
        Magacin.class,
        Zaposleni.class,
        ZaposleniMagacinCross.class,
        KorisnikZaposleniCross.class
}, version = 1)
@TypeConverters(MyTypeConverters.class)
public abstract class ZadatakDatabase extends RoomDatabase {

    private static ZadatakDatabase instance;

    public abstract KorisnikDao korisnikDao();
    public abstract KorisnikZaposleniDao korisnikZaposleniDao();
    public abstract KupacDao kupacDao();
    public abstract MagacinDao magacinDao();
    public abstract ZaposleniDao zaposleniDao();
    public abstract ZaposleniMagacinDao zaposleniMagacinDao();


    public static synchronized ZadatakDatabase getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ZadatakDatabase.class, "zadatak_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static Callback roomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private KorisnikDao korisnikDao;
        private KupacDao kupacDao;
        private ZaposleniDao zaposleniDao;

        private PopulateDbAsyncTask(ZadatakDatabase db) {
            korisnikDao = db.korisnikDao();
            zaposleniDao = db.zaposleniDao();
            kupacDao = db.kupacDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            korisnikDao.insert(new Korisnik("Name", "User", "pass", Arrays.asList(), Arrays.asList()));
            zaposleniDao.insert(new Zaposleni("Zapsleni", "Prezime", "pass", Arrays.asList(), Arrays.asList()));
            kupacDao.insert(new Kupac("kupac1", "123456", "okokp", Arrays.asList()));
            return null;
        }
    }

}
