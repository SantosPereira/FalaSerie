package com.longa.falaserie.ViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.longa.falaserie.R;

public class Cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void cadastrar(View view) {
        Intent in =  new Intent(Cadastro.this, SucessoCadastro.class);
        startActivity(in);
    }
}