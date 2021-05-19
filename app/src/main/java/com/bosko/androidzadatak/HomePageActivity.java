package com.bosko.androidzadatak;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.bosko.androidzadatak.adapter.KorisnikAdapter;
import com.bosko.androidzadatak.adapter.ZaposleniAdapter;
import com.bosko.androidzadatak.dao.ZaposleniDao;
import com.bosko.androidzadatak.entity.Korisnik;
import com.bosko.androidzadatak.entity.Zaposleni;
import com.bosko.androidzadatak.repository.ZaposleniRepository;
import com.bosko.androidzadatak.viewmodel.KorisnikViewModel;
import com.bosko.androidzadatak.viewmodel.ZaposleniViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {

    private ZaposleniViewModel zaposleniViewModel;
    private Spinner spinner;
    private ZaposleniDao zaposleniDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        spinner = findViewById(R.id.spinner);

        LiveData<List<Zaposleni>> zaposleni = zaposleniViewModel.getAllZaposleni();
//        List<String> zaposleni = ZadatakDatabase.getInstance(this).zaposleniDao().zaposleniName();
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, (List<String>) zaposleni);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(spinnerAdapter);

        spinnerAdapter.addAll(String.valueOf(zaposleni));
        spinnerAdapter.notifyDataSetChanged();
//

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ZaposleniAdapter adapter = new ZaposleniAdapter();
        recyclerView.setAdapter(adapter);

        zaposleniViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(ZaposleniViewModel.class);

        zaposleniViewModel.getAllZaposleni().observe(this, new Observer<List<Zaposleni>>() {
            @Override
            public void onChanged(List<Zaposleni> zaposleniList) {
                adapter.setZaposleniList(zaposleniList);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.zadatak_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.add_korisnik:
                startActivity(new Intent(HomePageActivity.this, RegisterKorisnik.class));
                Toast.makeText(this, "Add Korisnik", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.add_zaposleni:
                startActivity(new Intent(HomePageActivity.this, RegisterZaposleni.class));
                Toast.makeText(this, "Add Zaposleni", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.add_kupac:
                Toast.makeText(this, "Add Kupac", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.add_magacin:
                Toast.makeText(this, "Add Magacin", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.show_weather:
                Toast.makeText(this, "Vreme", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void getSelectedZaposleni(View v) {
        Zaposleni zaposleni = (Zaposleni) spinner.getSelectedItem();
        displayZaposleniData(zaposleni);
    }

    private void displayZaposleniData(Zaposleni zaposleni) {
        String name = zaposleni.getName();
        String surname = zaposleni.getSurname();

        String userData = name + " " + surname;
    }
}