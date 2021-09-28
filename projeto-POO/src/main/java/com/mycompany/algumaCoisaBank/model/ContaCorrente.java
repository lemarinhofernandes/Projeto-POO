package com.mycompany.AlgumaCoisaBank.model;

public class ContaCorrente extends Conta implements Taxa {

    public ContaCorrente() {
        this.saldo = 20.0;
    }

    public ContaCorrente(int numero, int agencia, String nome) {
        super(numero, agencia, nome);
        this.saldo = 20.0;
    }

    @Override
    public void toString(Conta conta) {
        System.out.println("===============================");
        System.out.println("Tipo de conta: Conta Corrente");
        System.out.println("Proprietario: " + this.nome);
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Conta: " + this.numero);
        System.out.println("saldo: " + this.saldo);
    }

    @Override
    public double taxa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
