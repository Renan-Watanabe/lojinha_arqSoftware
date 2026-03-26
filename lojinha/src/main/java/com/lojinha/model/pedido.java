package com.lojinha.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class pedido {
    private int id_pedido;
    private cliente cliente;
    private LocalDate data;
    private List<item_pedido> itens = new ArrayList<>();
    private String status;
    private double valor_total;
    private pagamento pagamento;

    public pedido(int id, cliente cliente) {
        this.id_pedido = id_pedido;
        this.cliente = cliente;
        this.data = LocalDate.now();
        this.status = "Pendente";
    }

    public void adicionarItem(produto produto, int quantidade) {
        int novoItemId = itens.size() + 1;
        this.itens.add(new item_pedido(novoItemId, produto, quantidade));
        System.out.println(quantidade + "x " + produto.getNome() + " adicionado com sucesso!");
    }

    public void removerItem(int produtoId) {
        boolean removido = itens.removeIf(item -> item.getId_produto().getId() == produtoId);
        if (removido) {
            System.out.println("Produto de id: " + produtoId + " removido do carrinho");
        } else {
            System.out.println("Produto não encontrado no carrinho");
        }
    }

    public double calcularTotal(){
        this.valor_total = itens.stream().mapToDouble(i -> i.getValor_unitario() * i.getQuantidade()).sum();
        return this.valor_total;
    }

    public void exibirCarrinho() {
        System.out.println("\n---ITENS NO CARRINHO---");
        if( itens.isEmpty() ) {
            System.out.println("Seu carrinho está vazio!");
        } else {
            for (item_pedido item : itens) {
                System.out.println("- " + item.getId_produto().getNome() + " | Qtd: " + item.getQuantidade() + " | Subtotal: R$ " + (item.getValor_unitario() * item.getQuantidade()));
            }
            System.out.println("TOTAL ATUAL: R$ " +calcularTotal());
        }
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId(int id_pedido) {
        this.id_pedido = this.id_pedido;
    }

    public void setPagamento(pagamento pagamento) {
        this.pagamento = pagamento;
        this.status = "Pago";
    }

    public pagamento getPagamento() {
        return pagamento;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }
}
