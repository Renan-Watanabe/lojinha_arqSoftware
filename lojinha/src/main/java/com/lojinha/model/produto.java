package com.lojinha.model;

public class produto {
    private int id;
    private String nome;
    private double preco;
    private int estoque;


    public produto(int id, String nome, int estoque, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public int getId() {return id;}
    public String getNome() {return nome;}
    public double getPreco() {return preco;}
    public int getEstoque() {return estoque;}
}
