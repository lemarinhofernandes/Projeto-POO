package com.mycompany.AlgumaCoisaBank.model;

public class ContaPoupanca extends Conta implements Taxa{

    public ContaPoupanca() {
        this.saldo = 20.0;
    }

    public ContaPoupanca(int numero, int agencia, String nome) {
        super(numero, agencia, nome);
        this.saldo = 20.0;
    }

    @Override
    public void transfere(Conta conta, double num) {
        super.transfere(conta, num);
         double transfReal = this.saldo + taxa();
         if(num > transfReal) {
            System.out.println("Impossivel realizar operação");
        }  else {
            this.saldo -= transfReal;
            conta.deposita(num);
         }
    }
    
    @Override
    public void toString(Conta conta) {
        super.toString(conta);
        System.out.println("===============================");
        System.out.println("Tipo de conta: Conta poupança");
        System.out.println("Proprietario: " + this.nome);
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Conta: " + this.numero);
        System.out.println("saldo: " + this.saldo);
    }
    
    @Override
    public double taxa() {
        return this.saldo *0.1;
    }
}
