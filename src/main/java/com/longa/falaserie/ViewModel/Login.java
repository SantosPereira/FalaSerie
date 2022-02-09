package com.longa.falaserie.ViewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.longa.falaserie.R;
import com.longa.falaserie.conexao.Conexao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
        editText = (EditText) findViewById(R.id.inputLogin);
    }

    public void realizaLogin(View view) {
        this.emailEd = (EditText) findViewById(R.id.inputLogin);
        this.email = this.emailEd.getText().toString();

        this.senhaEd = (EditText) findViewById(R.id.inputSenha);
        this.senha = this.senhaEd.getText().toString();

        System.out.println(this.email);
        System.out.println(this.senha);

        Map<String,String> parametros = new HashMap<String,String>();
        parametros.put("email", this.email);
        parametros.put("senha", this.senha);

        //Agora só enviar isso pra API
        Tarefa tarefa = new Tarefa(parametros);
        tarefa.execute();

        String respostaDaRequisicao = "logado";
        if (respostaDaRequisicao.equals("logado")) {
            Intent in =  new Intent(Login.this, Listagem.class);
            startActivity(in);
        }
    }

    private class Tarefa extends AsyncTask<String, String, String> {
        public String params;

        public Tarefa(Map<String, String> parametros) {
            this.params = parametros.toString();
        }

        @Override
        protected String doInBackground(String... strings) {
            String retorno = null;
            try {
                retorno = Conexao.req("POST","https://series.audax.mobi/api/", params);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return retorno;
        }

        @Override
        protected void onPostExecute(String r) {
            editText.setText(r);
            //System.out.println(r);
        }
    }
}

// https://pokeapi.co/api/v2/pokemon/1/