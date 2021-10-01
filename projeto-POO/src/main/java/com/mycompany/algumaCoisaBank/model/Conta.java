package com.mycompany.AlgumaCoisaBank.model;
public abstract class Conta {
    protected int numero;
    protected int agencia;
    protected double saldo;
    protected String nome;

    public Conta() {
        this.saldo = 20.0;
    }

    public Conta(int numero, int agencia, String nome) {
        this.numero = numero;
        this.agencia = agencia;
        this.nome = nome;
        this.saldo = 20.0;
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
            System.out.println("ta doido filho kk");
            return;
        }  
        this.saldo -= num;
        conta.deposita(num);
    }
    
    public void toString(Conta conta){ 
    }
}