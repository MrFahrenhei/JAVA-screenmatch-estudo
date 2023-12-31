package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecao.ErroConvertionYear;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{
    private String nome;
    private int anoDeLancamento;
    private boolean incluindoNoPlano;
    private double avaliacao;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();
        if(meuTituloOmdb.year().length() > 4){
            throw new ErroConvertionYear("Não consegui converter o ano");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 2));
    }

    public String getNome() {
        return nome;
    }
    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluindoNoPlano(boolean incluindoNoPlano) {
        this.incluindoNoPlano = incluindoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes(){
        return totalDeAvaliacoes;
    }
    public double getAvaliacao(){
        return avaliacao;
    }
    public void exibeFichaTecnica(){
        System.out.println(nome);
        System.out.println(anoDeLancamento);
    }
    public void avalia(double nota){
        avaliacao += nota;
        totalDeAvaliacoes++;
    }
    public double pegaMedia(){
        return avaliacao / totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo anotherTitle) {
        return this.getNome().compareTo(anotherTitle.getNome());
    }

    @Override
    public String toString() {
        return "(nome='" + nome + '\'' +
                ", anoDeLancamento = " + anoDeLancamento + ","
                + " duração = " + duracaoEmMinutos + ")";
    }
}
