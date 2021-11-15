package com.mycompany.CatolicaBank.model;

//Classe abstrata, classe mãe da herança
public abstract class Conta {
    int numero;
    int agencia;
    double saldo;
    String nome;
    int tipo;

    public Conta() {
        this.saldo = 20.0;
    }

    public Conta(int numero, int agencia, String nome, int tipo) {
        this.numero = numero;
        this.agencia = agencia;
        this.nome = nome;
        this.saldo = 20.0;
        this.tipo = tipo;
    }
    
    public int getTipo() {
        return tipo;
    }
    
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public void deposita(double num){
        this.saldo += num;
        System.out.println("R$" + num + " depositados.");
    }
    
    public void saca(double num){
        if(this.saldo < num) {
            System.out.println("Impossivel realizar operação");
            return;
        }
        this.saldo -= num;
        System.out.println("Saldo atual: R$" + this.saldo);
    }
    
    public void transfere(Conta conta, double num){
        if(num > this.saldo) {
            System.out.println("Impossivel realizar operação");
            return;
        }  
        this.saldo -= num;
        conta.deposita(num);
    }
    
    //metodo abstrato pras classes filhas implementarem
    abstract void imprime(Conta conta);
}
