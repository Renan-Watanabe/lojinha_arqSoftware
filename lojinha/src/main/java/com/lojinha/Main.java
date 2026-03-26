package com.lojinha;

import com.lojinha.model.*;
import com.lojinha.repository.StoreData;
import com.lojinha.service.PaymentGateway;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cliente cliente = StoreData.clientes.get(0);
        pedido pedido = new pedido(2026, cliente);

        boolean executando = true;

        System.out.println("Bem-vindo, " + cliente.getNome() + "!");

        while (executando) {
            System.out.println("\n--- MENU DA LOJINHA ---");
            System.out.println("1. Listar Produtos");
            System.out.println("2. Adicionar ao carrinho");
            System.out.println("3. Remover do carrinho");
            System.out.println("4. Ver carrinho");
            System.out.println("5. Finalizar compra");
            System.out.println("0. Sair");
            System.out.print("Digite algum desses para esoclher sua ação: ");

            int opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("\nCatálogo");
                    StoreData.produtos.forEach(p ->
                            System.out.println(p.getId() + " - " + p.getNome() + " (R$ " + p.getPreco() + ") Quantidade em Estoque: "  + p.getEstoque()));
                    break;

                case 2:
                    System.out.println("Digite o ID do produto a ser adicionado: ");
                    int idAdd = sc.nextInt();
                    produto pAdd = StoreData.produtos.stream().filter(p -> p.getId() == idAdd).findFirst().orElse(null);
                    if (pAdd != null) {
                        System.out.println("Quantidade: ");
                        int qtd = sc.nextInt();
                        pedido.adicionarItem(pAdd, qtd);
                    } else{
                        System.out.println("Produto não encontrado!");
                    }
                    break;

                case 3:
                    System.out.println("Digite o ID do produto a ser removido: ");
                    int idRevomer = sc.nextInt();
                    pedido.removerItem(idRevomer);
                    break;

                case 4:
                    pedido.exibirCarrinho();
                    break;

                case 5:
                    double total = pedido.calcularTotal();
                    if (total > 0) {
                        System.out.println("Total do pedido: R$ " + total);

                        if( PaymentGateway.getInstance().processar(total)) {
                            System.out.println("Sucesso! Compra oficializada.");
                            pagamento pag = new pagamento(999, "API Exerna", total);
                            pedido.setPagamento(pag);

                            executando = false;
                        } else {
                            System.out.println("Falha no pagamento. Tente novamente ou remova os itens do carrinho.");
                        }
                    } else {
                        System.out.println("Seu carrinho está vazio!");
                    }
                    break;

                case 0:
                    System.out.println("Saindo.. Volte Sempre!!");
                    executando = false;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        sc.close();
    }
}