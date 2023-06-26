package br.com.desafio.screenmatch.principal;

import br.com.desafio.screenmatch.modelos.Buy;
import br.com.desafio.screenmatch.modelos.CreditCard;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reading = new Scanner(System.in);
        System.out.println("Type your credit card balance");
        double limit = reading.nextDouble();
        CreditCard card = new CreditCard(limit);
        int exit = 1;
        while(exit != 0){
            System.out.println("type product description");
            String description = reading.next();

            System.out.println("Type product price");
            double val = reading.nextDouble();

            Buy buying = new Buy(description, val);
            boolean checkoutTrue = card.lancaCompra(buying);

            if(checkoutTrue){
                System.out.println("Checkout Result");
                System.out.println("Type 0 to exit, 1 to continue");
                exit = reading.nextInt();
            }else{
                System.out.println("Saldo insuficiente");
                exit = 0;
            }
        }
        System.out.println("******************");
        System.out.println("Compras Realizadas \n");
        Collections.sort(card.getBuy());
        for (Buy c : card.getBuy()){
            System.out.println(c.getDescription() + "-"+c.getVal());
        }
        System.out.println("\n**************************");
        System.out.println("\nCredit Balance" + card.getBalance());
    }
}
