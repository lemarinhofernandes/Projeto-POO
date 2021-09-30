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
    public void transfere(Conta conta, double num) {
        double transfReal = this.saldo + taxa();
         if(num > transfReal) {
            System.out.println("ta doido filho kk");
            return;
        }  
        this.saldo -= transfReal;
        conta.deposita(num);
        
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
        return this.saldo *0.2;    
    }
}
