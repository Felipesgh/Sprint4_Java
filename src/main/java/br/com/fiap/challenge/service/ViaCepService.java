package br.com.fiap.challenge.service;

import br.com.fiap.challenge.api.Endereco;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ViaCepService {

    private static final String VIACEP_URL = "https://viacep.com.br/ws/";

    public Endereco buscarPorCep(String cep) throws Exception {
        if (cep == null) {
            throw new IllegalArgumentException("CEP não pode ser nulo");
        }
        cep = cep.replaceAll("\\D", ""); // remove non-digits
        if (cep.length() != 8) {
            throw new IllegalArgumentException("CEP inválido. Deve conter 8 dígitos.");
        }
        String target = VIACEP_URL + cep + "/json/";
        URL url = new URL(target);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);

        int status = conn.getResponseCode();
        BufferedReader in;
        if (status >= 200 && status < 300) {
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        } else {
            in = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        }
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            content.append(line);
        }
        in.close();
        conn.disconnect();

        Gson gson = new Gson();
        Endereco endereco = gson.fromJson(content.toString(), Endereco.class);
        return endereco;
    }
}
