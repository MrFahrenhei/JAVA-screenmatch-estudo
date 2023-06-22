package br.com.alura.screenmatch.calculo;
import br.com.alura.screenmatch.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal = 0;

    public int getTempoTotal() {
        return this.tempoTotal;
    }

//    public void inclui(Movie movie){
//        this.tempoTotal += movie.getDuracaoEmMinutos();
//    }
//    public void inclui(Serie serie){
//        this.tempoTotal += serie.getDuracaoEmMinutos();
//    }
    public void inclui(Titulo titulo){
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
