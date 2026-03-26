package com.lojinha.service;

import java.util.Random;

public class PaymentGateway {
    private static PaymentGateway instance;

    //Previne que alguém fora dessa classe possa dar "new"
    private PaymentGateway(){
        System.out.println("Fazendo conexão com o servidor externo de pagementos...");
    }

    //Acesso global a instância
    public static synchronized PaymentGateway getInstance(){

        if(instance == null){
            instance = new PaymentGateway();
        }
        return instance;
    }

    public boolean processar(double valor){
        System.out.println("Processando pagamento de R$ " + valor);
        //Simulação de latência de rede
        try {Thread.sleep(1000);} catch (InterruptedException e) {}

        //Gera um número aleatório para simular alguma em caso de falha
        boolean sucesso = new Random().nextDouble() > 0.2;
        return sucesso;
    }
}
