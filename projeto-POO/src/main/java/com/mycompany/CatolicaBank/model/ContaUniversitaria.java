package com.mycompany.CatolicaBank.model;

//classe filha
public class ContaUniversitaria extends Conta {

    public ContaUniversitaria() {
        this.saldo = 20.0;
    }

    public ContaUniversitaria(int numero, int agencia, String nome, int tipo) {
        super(numero, agencia, nome, tipo);
        this.saldo = 20.0;
    }
    
    //polimorfismo: cada classe fila implementa um transfere diferente
    @Override
    public void transfere(Conta conta, double num) {
        super.transfere(conta, num);
         if(num > this.saldo) {
            System.out.println("Impossivel realizar operação");
        } else {
            this.saldo -= num;
            conta.deposita(num);
         }
    }

    //metodos abstratos implementados
    @Override
    public void imprime(Conta conta) {
        System.out.println("===============================");
        System.out.println("Tipo de conta: Conta Universitaria");
        System.out.println("Proprietario: " + this.nome);
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Conta: " + this.numero);
        System.out.println("saldo: " + this.saldo);
    }
    
}
