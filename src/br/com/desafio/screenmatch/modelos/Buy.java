package br.com.desafio.screenmatch.modelos;

public class Buy implements Comparable<Buy>{
    private String description;
    private double val;

    public Buy(String description, double val) {
        this.description = description;
        this.val = val;
    }

    public String getDescription() {
        return description;
    }

    public double getVal() {
        return val;
    }

    @Override
    public String toString() {
        return String.format("Compra: descrição %s (%f)", description, val);
    }

    @Override
    public int compareTo(Buy anotherBuy) {
        return Double.compare(this.val, anotherBuy.val);
    }
}
