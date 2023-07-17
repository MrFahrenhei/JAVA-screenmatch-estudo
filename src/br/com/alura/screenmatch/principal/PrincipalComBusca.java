package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroConvertionYear;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner movieTitle = new Scanner(System.in);
        System.out.println("Digite um filme para busca");
        var busca = movieTitle.nextLine();

        String address = "https://www.omdbapi.com/?t=" + busca.replace(" ", "%20") + "&apikey=c5021b4c&";

        try{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        //Gson gson = new Gson();
        //Titulo meuTitulo = gson.fromJson(json, Titulo.class);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
        System.out.println(meuTituloOmdb);
            Titulo meineTitel = new Titulo(meuTituloOmdb);
            System.out.println(meineTitel);
        }catch (NumberFormatException e){
            System.out.println(ANSI_RED+"Error:"+ANSI_RESET);
            System.out.println(ANSI_RED+e.getMessage()+ANSI_RESET);
        }catch (ErroConvertionYear e){
            System.out.println(e.getMessage());
        }
        System.out.println("Finalizado.");

    }
}
