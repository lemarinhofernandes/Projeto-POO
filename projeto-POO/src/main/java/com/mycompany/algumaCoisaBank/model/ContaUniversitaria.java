package com.mycompany.AlgumaCoisaBank.model;
public class ContaUniversitaria extends Conta {

    public ContaUniversitaria() {
        this.saldo = 20.0;
    }

    public ContaUniversitaria(int numero, int agencia, String nome) {
        this.saldo = 20.0;
    }

    @Override
    void transfere(Conta conta, double num) {
         if(num > this.saldo) {
            System.out.println("ta doido filho kk");
            return;
        }  
        this.saldo -= num;
        conta.deposita(num);
    }
    
}
