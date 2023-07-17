package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroConvertionYear;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner movieTitle = new Scanner(System.in);
        String busca = "";
        List<Titulo> titlesList = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while(!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite um filme para busca");
            busca = movieTitle.nextLine();

            if(busca.equalsIgnoreCase("sair")){
                break;
            }
            String address = "https://www.omdbapi.com/?t=" + busca.replace(" ", "%20") + "&apikey=c5021b4c&";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(address)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();

                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);

                Titulo meineTitel = new Titulo(meuTituloOmdb);
                System.out.println(meineTitel);

               titlesList.add(meineTitel);
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "Error:" + ANSI_RESET);
                System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
            } catch (ErroConvertionYear e) {
                System.out.println(e.getMessage());
            }
        }
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titlesList));
        escrita.close();
        System.out.println(titlesList);
        System.out.println("Finalizado.");

    }
}
