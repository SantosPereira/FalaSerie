package com.longa.falaserie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SucessoCadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucesso_cadastro);
    }

    public void ok(View view) {
        Intent in =  new Intent(SucessoCadastro.this, Listagem.class);
        startActivity(in);
    }
}