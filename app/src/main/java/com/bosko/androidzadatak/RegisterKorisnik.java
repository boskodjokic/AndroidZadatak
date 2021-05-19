package com.bosko.androidzadatak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bosko.androidzadatak.dao.KorisnikDao;
import com.bosko.androidzadatak.dao.ZaposleniDao;
import com.bosko.androidzadatak.entity.Korisnik;
import com.bosko.androidzadatak.entity.Zaposleni;

public class RegisterKorisnik extends AppCompatActivity {

    private EditText name, user, password;
    private Button registerBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_korisnik);

        name = findViewById(R.id.etName);
        user = findViewById(R.id.etUser);
        password = findViewById(R.id.etPass);
        registerBtn = findViewById(R.id.btnReg);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Korisnik korisnik = new Korisnik();

                korisnik.setName(name.getText().toString());
                korisnik.setUser(user.getText().toString());
                korisnik.setPassword(password.getText().toString());

                if (validateInput(korisnik)) {

                    ZadatakDatabase database = ZadatakDatabase.getInstance(getApplicationContext());

                    KorisnikDao korisnikDao = database.korisnikDao();

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            korisnikDao.insert(korisnik);
                            Toast.makeText(RegisterKorisnik.this, "User Registered", Toast.LENGTH_SHORT).show();
                        }
                    }).start();

                } else {
                    Toast.makeText(RegisterKorisnik.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean validateInput(Korisnik korisnik) {

        if (korisnik.getName().isEmpty() || korisnik.getUser().isEmpty() ||
                korisnik.getPassword().isEmpty()) {
            return false;
        }
        return true;
    }
}