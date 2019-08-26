package com.abigdev.belajarlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.Duration;

public class MainActivity extends AppCompatActivity {
    EditText loginNama, loginPassword;
    Button loginLogin, loginRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginNama = findViewById(R.id.loginNama);
        loginPassword = findViewById(R.id.loginPassword);

        loginLogin = findViewById(R.id.loginLogin);
        loginRegister = findViewById(R.id.loginRegister);

        loginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loginNama.getText().toString().equals("Ajeng")
                        && loginPassword.getText().toString().equals("Agung")){
                    startActivity(new Intent(MainActivity.this, Menu.class));
                }else{
                    Toast.makeText(MainActivity.this,
                            "Username atau password salah", Toast.LENGTH_SHORT).show();
                } }
        });

        loginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Register.class));
            }
        });
    }
}
