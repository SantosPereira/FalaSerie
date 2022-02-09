package com.longa.falaserie.ViewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.longa.falaserie.R;

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