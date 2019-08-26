package com.abigdev.belajarlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RegisterBerhasil extends AppCompatActivity {
    TextView isiRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_berhasil);

        isiRegister = findViewById(R.id.isiRegister);

        Intent intent = getIntent();
        isiRegister.setText(intent.getStringExtra("reg"));
    }
}
