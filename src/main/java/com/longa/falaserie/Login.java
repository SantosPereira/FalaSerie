package com.longa.falaserie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.text.BreakIterator;

import javax.net.ssl.HttpsURLConnection;

public class Login extends AppCompatActivity {

    private EditText emailEd;
    private EditText senhaEd;

    private String email;
    private String senha;

    public EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void botao (View view){
        Button botao = (Button) findViewById(R.id.button6);
        editText = (EditText) findViewById(R.id.inputLogin);

        Tarefa tarefa = new Tarefa();
        System.out.println(tarefa.execute());

    }


    private class Tarefa extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            String retorno = null;
            try {
                retorno = Conexao.getDados();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return retorno;
        }

        @Override
        protected void onPostExecute(String r) {
            editText.setText(r);
        }
    }












    public void realizaLogin(View view) {
        this.emailEd = (EditText) findViewById(R.id.inputLogin);
        this.email = this.emailEd.getText().toString();

        this.senhaEd = (EditText) findViewById(R.id.inputSenha);
        this.senha = this.senhaEd.getText().toString();

        System.out.println(this.email);
        System.out.println(this.senha);

        //Agora só enviar isso pra API
        String respostaDaRequisicao = "logado";
        if (respostaDaRequisicao.equals("logado")) {
            Intent in =  new Intent(Login.this, Listagem.class);
            startActivity(in);
        }

    }

    public void telaCadastroUsuario(View view) {
        Intent in =  new Intent(Login.this, Cadastro.class);
        startActivity(in);
    }
}

