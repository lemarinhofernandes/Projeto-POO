package com.mycompany.AlgumaCoisaBank.model;
public class ContaUniversitaria extends Conta {

    public ContaUniversitaria() {
        this.saldo = 20.0;
    }

    public ContaUniversitaria(int numero, int agencia, String nome) {
        this.saldo = 20.0;
    }

    @Override
    public void toString(Conta conta) {
        super.toString(conta);
        System.out.println("===============================");
        System.out.println("Tipo de conta: Conta Universitaria");
        System.out.println("Proprietario: " + this.nome);
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Conta: " + this.numero);
        System.out.println("saldo: " + this.saldo);
    }
    
}
