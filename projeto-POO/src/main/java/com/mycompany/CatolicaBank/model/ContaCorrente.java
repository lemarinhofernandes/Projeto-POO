package com.mycompany.CatolicaBank.model;

//classe filha
public class ContaCorrente extends Conta implements Taxa {

    public ContaCorrente() {
        
    }

    public ContaCorrente(String numero/*, String agencia*/, String nome, int tipo) {
        super(numero/*, agencia*/, nome, tipo);        
        
    }

    
    //polimorfismo: cada classe fila implementa um transfere diferente
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
    
    
    //metodos abstratos implementados
    @Override
    public void imprime(Conta conta) {
        System.out.println("===============================");
        System.out.println("Tipo de conta: Conta Corrente");
        System.out.println("Proprietario: " + this.nome);
        //System.out.println("Agencia: " + this.agencia);
        System.out.println("Conta: " + this.numero);
        System.out.println("Transferido: " + this.saldo);
    }
    
    //metodo da interface implementados
        @Override
        public double taxa() {
            return this.saldo *0.2;  
        }
}
