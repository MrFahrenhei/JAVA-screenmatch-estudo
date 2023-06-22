package br.com.alura.screenmatch.calculo;

public class FiltroRecomendacao {
    private String recomendacao;

    public void filtra(Classificavel classificavel){
        int nota = classificavel.getClassificacao();
        if (nota >= 4){
            System.out.println("Está entre os preferidos");
        }else if (nota >= 2){
            System.out.println("Muito bem avaliado no momento");
        }else{
            System.out.println("Veja depois");
        }
    }
}
