package com.longa.falaserie.conexao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class Conexao {

    public static String req(String metodo, String caminho, String params) throws IOException {
        BufferedReader reader = null;
        try {
            // Cria a conexão
            URL url = new URL(caminho);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();

            // Escolhe o método
            httpsURLConnection.setRequestMethod(metodo);

            if (metodo.equals("POST")) {
                httpsURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                httpsURLConnection.setRequestProperty("Authorization", "Basic DDpfFDZo!@7oQIhxDb%y7JQd3LUB%@INDbVHAbP7of2@2ZZL3GYsnWUnDJ5Feq1w");

                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(true);

                OutputStream os = httpsURLConnection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));

                writer.write(params.toString());

                writer.flush();
                writer.close();
                os.close();
            }

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

