package com.longa.falaserie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class VerRegistro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_registro);

        Bundle bundle = getIntent().getExtras();
        String valor = bundle.getString("Série");

        System.out.println(valor);
    }
}