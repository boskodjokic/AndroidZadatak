package com.bosko.androidzadatak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bosko.androidzadatak.dao.ZaposleniDao;
import com.bosko.androidzadatak.entity.Zaposleni;

public class RegisterZaposleni extends AppCompatActivity {

    private EditText name, surname, password, city;
    private Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_zaposleni);


        name = findViewById(R.id.etName);
        surname = findViewById(R.id.etSurname);
        password = findViewById(R.id.etPass);
        city = findViewById(R.id.etCity);
        registerBtn = findViewById(R.id.btnReg);


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Zaposleni zaposleni = new Zaposleni();
                zaposleni.setName(name.getText().toString());
                zaposleni.setSurname(surname.getText().toString());
                zaposleni.setPassword(password.getText().toString());
                zaposleni.setCity(city.getText().toString());
                if (validateInput(zaposleni)) {

                    ZadatakDatabase database = ZadatakDatabase.getInstance(getApplicationContext());

                    ZaposleniDao zaposleniDao = database.zaposleniDao();

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            zaposleniDao.insert(zaposleni);
                            Toast.makeText(RegisterZaposleni.this, "User Registered", Toast.LENGTH_SHORT).show();
                        }
                    }).start();

                } else {
                    Toast.makeText(RegisterZaposleni.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateInput(Zaposleni zaposleni) {

        if (zaposleni.getName().isEmpty() || zaposleni.getSurname().isEmpty() ||
                zaposleni.getPassword().isEmpty() || zaposleni.getCity().isEmpty()) {
            return false;
        }
        return true;
    }
}