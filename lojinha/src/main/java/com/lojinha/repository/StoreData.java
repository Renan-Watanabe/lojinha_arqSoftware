package com.lojinha.repository;

import com.lojinha.model.cliente;
import com.lojinha.model.produto;

import java.util.Arrays;
import java.util.List;

public class StoreData {
    public static List<cliente> clientes = Arrays.asList(
            new cliente(1, "Vitor"),
            new cliente(2, "Renan")
    );

    public static List<produto> produtos = Arrays.asList(
            new produto(101, "Teclado Mecânico", 50, 250.00),
            new produto(102, "Mouse Gamer", 30, 150.00)
    );
}
