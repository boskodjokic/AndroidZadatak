package com.bosko.androidzadatak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bosko.androidzadatak.adapter.KorisnikAdapter;
import com.bosko.androidzadatak.adapter.ZaposleniAdapter;
import com.bosko.androidzadatak.dao.KorisnikDao;
import com.bosko.androidzadatak.entity.Korisnik;
import com.bosko.androidzadatak.entity.Zaposleni;
import com.bosko.androidzadatak.repository.KorisnikRepository;
import com.bosko.androidzadatak.viewmodel.KorisnikViewModel;
import com.bosko.androidzadatak.viewmodel.ZaposleniViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

private ZaposleniViewModel zaposleniViewModel;

    private KorisnikRepository repository;

    private EditText logUser;
    private EditText logPass;
    private Button logButton;

    private String username = "Admin";
    private String pass = "Admin";

    boolean isValid = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_item);


        logUser = findViewById(R.id.logUser);
        logPass = findViewById(R.id.logPass);
        logButton = findViewById(R.id.logButton);

        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputUser = logUser.getText().toString();
                String inputPass = logPass.getText().toString();

                if (inputUser.isEmpty() || inputPass.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Username i password polje ne mogu biti prazni", Toast.LENGTH_SHORT).show();
                } else {
                    isValid = validate(inputUser, inputPass);

                    if(!isValid) {
                        Toast.makeText(MainActivity.this, "Uneti podaci nisu ispravni", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Logovanje uspesno", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private boolean validate(String name, String password) {
        if (name.equals(username) && password.equals(pass)) {
            return true;
        }
        return false;
    }


}