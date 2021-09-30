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
    }
    
    public void saca(double num){
        this.saldo -= num;
    }
    
    abstract void transfere(Conta conta, double num);
    
    public void toString(Conta conta){ 
        System.out.println("===============================");
        System.out.println("Proprietario: " + this.nome);
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Conta: " + this.numero);
        System.out.println("saldo: " + this.saldo);
    }
    
}
