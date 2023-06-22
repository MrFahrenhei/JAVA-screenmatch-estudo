package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Movie;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalComListas {
    public static void main(String[] args) {
        Movie movieGodfather = new Movie("O Poderoso Chefão", 1969);
        movieGodfather.avalia(9);
        Movie movieAvatar = new Movie("Avatar", 2023);
        movieAvatar.avalia(3);
        var movieDogville = new Movie("Dogville", 2003);
        movieDogville.avalia(10);
        Serie tvshowLost = new Serie("Lost", 2000);
        List<Titulo> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(movieGodfather);
        listaDeFilmes.add(movieAvatar);
        listaDeFilmes.add(movieDogville);
        listaDeFilmes.add(tvshowLost);
        for(Titulo item: listaDeFilmes){
            System.out.println(item);
            if(item instanceof Movie movie && movie.getClassificacao() > 2)
                System.out.println(movie.getClassificacao());
        }

        ArrayList<String> searchForActor = new ArrayList<>();
        searchForActor.add("Adam Sandler");
        searchForActor.add("Nicolas Cage");
        searchForActor.add("John Travolta");
        System.out.println(searchForActor);
        Collections.sort(searchForActor);
        System.out.println(searchForActor);

        System.out.println("Lista de filmes ordenadas");
        Collections.sort(listaDeFilmes);
        System.out.println(listaDeFilmes);
        listaDeFilmes.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(listaDeFilmes);
    }
}
