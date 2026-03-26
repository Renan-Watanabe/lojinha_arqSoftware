package com.lojinha.model;

public class cliente {
    private int id;
    private String nome;

    public cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {return nome;}
    public int getId() {return id;}
}
