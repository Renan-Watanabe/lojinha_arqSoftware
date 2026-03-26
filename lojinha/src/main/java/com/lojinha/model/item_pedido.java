package com.lojinha.model;

public class item_pedido {
    private int item_id;
    private produto id_produto;
    private int quantidade;
    private double valor_unitario;

    public item_pedido(int item_id, produto produto, int quantidade) {
        this.item_id = item_id;
        this.id_produto = produto;
        this.quantidade = quantidade;
        this.valor_unitario = produto.getPreco();
    }

    public double getValor_unitario() {return valor_unitario;}
    public produto getId_produto() {return id_produto;}
    public int getQuantidade() {return quantidade;}
}
