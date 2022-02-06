package com.longa.falaserie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.net.HttpURLConnection;

import javax.net.ssl.HttpsURLConnection;

public class Login extends AppCompatActivity {

    private EditText emailEd;
    private EditText senhaEd;

    private String email;
    private String senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void realizaLogin(View view) {
        this.emailEd = (EditText) findViewById(R.id.inputLogin);
        this.email = this.emailEd.getText().toString();

        this.senhaEd = (EditText) findViewById(R.id.inputSenha);
        this.senha = this.senhaEd.getText().toString();

        //Agora só enviar isso pra API
    }

    public void telaCadastroUsuario(View view) {

    }
}

