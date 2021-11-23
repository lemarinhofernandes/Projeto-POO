package com.mycompany.CatolicaBank.model;

//Classe abstrata, classe mãe da herança
public abstract class Conta {
    String numero;
    //String agencia;
    double saldo;
    String nome;
    int tipo;

    public Conta() {
       
    }

    public Conta(String numero /*String agencia*/, String nome, int tipo) {
        this.numero = numero;
        /*this.agencia = agencia;*/
        this.nome = nome;
        
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    /*public String getAgencia() {
        return agencia;
    }*/

    /*public void setAgencia(String agencia) {
        this.agencia = agencia;
    }*/

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
    
    
    
    public void imprimeConta() {
        String tipoConta = "";
        switch (this.tipo) {
            case 1:
                tipoConta = "Conta Corrente";
                break;
            case 2:
                tipoConta = "Conta Poupança";
                break;
            case 3:
                tipoConta = "Conta Universitária";
                break;
            default:
                break;
        }
        System.out.println("===============================");
        System.out.println("Tipo de conta: " + tipoConta);
        System.out.println("Proprietario: " + this.nome);
        //System.out.println("Agencia: " + this.agencia);
        System.out.println("Conta: " + this.numero);
        System.out.println("saldo: " + this.saldo);
        
        
    }
}
