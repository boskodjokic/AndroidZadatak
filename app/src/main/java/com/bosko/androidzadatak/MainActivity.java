package com.bosko.androidzadatak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bosko.androidzadatak.adapter.KorisnikAdapter;
import com.bosko.androidzadatak.entity.Korisnik;
import com.bosko.androidzadatak.viewmodel.KorisnikViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private KorisnikViewModel korisnikViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        KorisnikAdapter adapter = new KorisnikAdapter();
        recyclerView.setAdapter(adapter);

        korisnikViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(KorisnikViewModel.class);

        korisnikViewModel.getAllKorisnik().observe(this, new Observer<List<Korisnik>>() {
            @Override
            public void onChanged(List<Korisnik> notes) {
                adapter.setKorisniks(notes);
            }
        });
    }
}