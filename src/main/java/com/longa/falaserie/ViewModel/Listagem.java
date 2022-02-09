package com.longa.falaserie.ViewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.longa.falaserie.R;

public class Listagem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);
    }

    public void cadastrarSerie(View view) {
        Intent in =  new Intent(Listagem.this, Cadastro.class);
        startActivity(in);
    }

    public void verSerie(View view) {
        Intent in =  new Intent(Listagem.this, VerRegistro.class);
        Bundle bundle = new Bundle();
        bundle.putString("Série", "Série que cliquei");
        in.putExtras(bundle);
        startActivity(in);
    }

    public void pesquisar(View view) {
        Intent in =  new Intent(Listagem.this, Pesquisar.class);
        startActivity(in);
    }
}