import br.com.alura.screenmatch.calculo.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculo.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Movie;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class exMain {
   // public static void main(String[] args) {
   public void exMain(){
        Movie meuFilme = new Movie("O Poderoso Chefão", 1969);
        meuFilme.setDuracaoEmMinutos(180);
        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(7);
//        System.out.println(meuFilme.getTotalDeAvaliacoes());
//        System.out.println(meuFilme.getAvaliacao());
//        System.out.println(meuFilme.pegaMedia());

        Serie lost = new Serie("Lost", 2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorTemporada(50);
        System.out.println("Maratonar Lost " + lost.getDuracaoEmMinutos());

        Movie outroFilme = new Movie("Avatar", 2023);
        outroFilme.setDuracaoEmMinutos(200);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        var filmeDoPaulo = new Movie("Dogville", 2003);
        filmeDoPaulo.setDuracaoEmMinutos(200);
        filmeDoPaulo.avalia(10);
        System.out.println("---------------");
        ArrayList<Movie> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDoPaulo);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);
        System.out.println("Tamanho da lista: "+listaDeFilmes.size());
        System.out.println(listaDeFilmes);
        for (int i = 0; i < listaDeFilmes.size(); i++){
            System.out.println((i+1)+"º filme: "+listaDeFilmes.get(i).getNome());
        }
        System.out.println("toString do filme: "+listaDeFilmes.get(0).toString());
    }
}