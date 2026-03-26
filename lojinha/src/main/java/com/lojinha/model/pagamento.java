package com.lojinha.model;

import java.time.LocalDate;

public class pagamento {
    private int id_pagamento;
    private String forma_pagamento;
    private double valor;
    private LocalDate data_pagamento;

    public pagamento(int id_pagamento, String forma_pagamento, double valor) {
        this.id_pagamento = id_pagamento;
        this.forma_pagamento = forma_pagamento;
        this.valor = valor;
        this.data_pagamento = LocalDate.now();
    }

    public int getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(LocalDate data_pagamento) {
        this.data_pagamento = data_pagamento;
    }
}
