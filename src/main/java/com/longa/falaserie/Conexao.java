package com.longa.falaserie;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Conexao {

    public static String getDados() throws IOException {
        BufferedReader reader = null;
        try {
            URL url = new URL("https://pokeapi.co/api/v2/pokemon/1/");
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();

            StringBuilder stringBuilder = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));

            InputStream inputStream = httpsURLConnection.getInputStream();

            String linha;
            while ((linha = reader.readLine()) != null) {
                stringBuilder.append(linha + "\n");
            }

            return stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}

