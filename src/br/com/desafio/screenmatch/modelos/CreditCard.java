package br.com.desafio.screenmatch.modelos;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private final double limit;
    private double balance;
    private final List<Buy> buy;
    public CreditCard(double limit){
        this.limit = limit;
        this.balance = limit;
        this.buy = new ArrayList<>();
    }

    public boolean lancaCompra(Buy buy){
        if(this.balance > buy.getVal()){
            this.balance -= buy.getVal();
            this.buy.add(buy);
            return true;
        }
        return false;
    }
    public double getLimit() {
        return limit;
    }
    public double getBalance() {
        return balance;
    }
    public List<Buy> getBuy() {
        return buy;
    }
}
