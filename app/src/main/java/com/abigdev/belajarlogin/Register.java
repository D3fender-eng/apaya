package com.abigdev.belajarlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Register extends AppCompatActivity {
    EditText registerNama, registerAlamat, registerTelpon;
    TextView registerTanggalLahir;
    RadioGroup registerKelaminGroup;
    Button registerRegsiter, registerBatal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerNama = findViewById(R.id.registerNama);
        registerAlamat = findViewById(R.id.registerAlamat);
        registerTelpon = findViewById(R.id.registerTelpon);
        registerTanggalLahir = findViewById(R.id.registerTanggalLahir);
        registerKelaminGroup = findViewById(R.id.registerKelaminGroup);
        registerRegsiter = findViewById(R.id.registerRegister);
        registerBatal = findViewById(R.id.registerBatal);

        registerBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        registerRegsiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioButton simpandulu;
                simpandulu = findViewById(registerKelaminGroup.getCheckedRadioButtonId());
                String pesan = "";
                pesan = "Nama : " + registerNama.getText().toString()
                        + "\nAlamat : " + registerAlamat.getText().toString()
                        + "\nTelpon : " + registerTelpon.getText().toString()
                        + "\nTanggal Lahir : " + registerTanggalLahir.getText().toString()
                        + "\nJenis Kelamin : " + simpandulu.getText().toString();

                Intent intent = new Intent(Register.this,
                        RegisterBerhasil.class);
                intent.putExtra("reg", pesan);
                startActivity(intent);

            }
        });

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        registerTanggalLahir.setText(simpleDateFormat.format(calendar.getTime()));

        registerTanggalLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar1 = Calendar.getInstance();
                int tahun = calendar1.get(Calendar.YEAR);
                int bulan = calendar1.get(Calendar.MONTH);
                int tanggal = calendar1.get(Calendar.DAY_OF_YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(Register.this
                        , new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        registerTanggalLahir.setText(String.valueOf(i2)
                        +"-"+String.valueOf(i1+1)
                        +"-"+String.valueOf(i));
                    }
                }, tahun-1, bulan, tanggal);
                datePickerDialog.show();
            }
        });

    }
}
