package com.mycompany.CatolicaBank;

import com.mycompany.CatolicaBank.model.Conta;
import com.mycompany.CatolicaBank.model.ContaCorrente;
import com.mycompany.CatolicaBank.model.ContaPoupanca;
import com.mycompany.CatolicaBank.model.ContaUniversitaria;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Scanner lerString = new Scanner(System.in);
        ArrayList<Conta> contas = new ArrayList();
        ContaCorrente luis = new ContaCorrente(2134, 22222, "Luis", 1);
        ContaPoupanca daniel = new ContaPoupanca(1234, 22222, "Daniel", 2);
        ContaUniversitaria bruno = new ContaUniversitaria(1111, 22222, "Bruno", 3);
        contas.add(luis);
        contas.add(daniel);
        contas.add(bruno);
        int opcao;
        int tam = contas.size();
        int numConta;
        
        do{
           menu();
           opcao = ler.nextInt();
           switch(opcao){
               case 1:
                   //Adiciona uma nova conta
                    adicionaConta(contas, ler, lerString);
                    break;
               case 2:
                   //Lista todas as contas cadastradas
                   System.out.println("Contas:");
                   contas.forEach((Conta conta) -> listar(conta));
                   break;

               case 3:
                   //Entra numa conta e realiza as operações desejadas
                   numConta = numEncontrar(ler);
                   for (Conta conta : contas) {
                       if(numConta == conta.getNumero()) {
                           Operacoes(conta, contas, ler, tam);
                       }
                   };
                   break;
               case 4:
                   //Procura e exclui uma conta a partir do index no "for"
                   numConta = numEncontrar(ler);
                   for(int i=0; i < tam; i++) {
                       if(numConta == contas.get(i).getNumero())
                           contas.remove(i);
                   }
                   break;
           }
        }while(opcao!=0);
        
        
        
    }
    
    //menus
    private static void menu() {
        System.out.println("=== BEM VINDO ===");
        System.out.println("1 - Cria conta");
        System.out.println("2 - Lista contas");
        System.out.println("3 - Entrar em uma conta");
        System.out.println("4 - Exclui conta cadastrada");
        System.out.println("0 - sair");
        System.out.println("escolha: ");

    }
    private static void menuOperacoes(Conta usuario) {
        System.out.println("=== MENU DE OPERAÇÕES ===");
        System.out.println("Seja bem vindo, " + usuario.getNome() + ".");
        System.out.println("1 - deposito");
        System.out.println("2 - saque");
        System.out.println("3 - transferencia");
        System.out.println("4 - Info");
        System.out.println("0 - sair");
        System.out.println("Escolha: ");
    }
    private static void menuTipoContas() {
        System.out.println("tipo conta\n1 - corrente\n2 - poupanca\n3 - universitaria");
    }
    
    //funções
    private static int numEncontrar(Scanner ler) {
        System.out.println("Digite o numero da conta que voce deseja encontrar: ");
        return ler.nextInt();
    }
    private static void listar(Conta conta) {
        switch (conta.getTipo()) {
            case 1:
                {
                    ContaCorrente lista = (ContaCorrente) conta;
                    lista.toString(lista);
                    break;
                }
            case 2:
                {
                    ContaPoupanca lista = (ContaPoupanca) conta;
                    lista.toString(lista);
                    break;
                }
            case 3:
                {
                    ContaUniversitaria lista = (ContaUniversitaria) conta;
                    lista.toString(lista);
                    break;
                }
            default:
                break;
        }
    }
   

    //Paginas
    private static void adicionaConta(ArrayList<Conta> contas, Scanner ler, Scanner lerString) {
        System.out.println("Digite a agencia: ");
        int agencia = ler.nextInt();
        System.out.println("Digite o numero da conta: ");
        int numero = ler.nextInt();
        System.out.println("Informe o nome do proprietario: ");
        String nome = lerString.nextLine();
        menuTipoContas();
        int tipo = ler.nextInt();
        switch (tipo) {
            case 1:
                ContaCorrente corrente = new ContaCorrente(numero, agencia, nome, tipo);
                corrente.toString(corrente);
                contas.add(corrente);
                break;
            case 2:
                ContaPoupanca poupanca = new ContaPoupanca(numero, agencia, nome, tipo);
                poupanca.toString(poupanca);
                contas.add(poupanca);
                break;
            default:
                ContaUniversitaria universitaria = new ContaUniversitaria(numero, agencia, nome, tipo);
                universitaria.toString(universitaria);
                contas.add(universitaria);
                break;
        }
    }
    private static void Operacoes(Conta usuario, ArrayList<Conta> contas, Scanner ler, int tam) {
        int operacao;
        double valor;
        do{
            menuOperacoes(usuario);
            operacao = ler.nextInt();
            switch(operacao){
                case 1:
                    System.out.println("Informe o valor depositado:");
                    valor = ler.nextDouble();
                    usuario.deposita(valor);
                    break;
                case 2:
                    System.out.println("Informe o valor a sacar:");
                    valor = ler.nextDouble();
                    usuario.saca(valor);
                    break;
                case 3:
                    System.out.println("Digite o numero da conta que deseja fazer transferencia:");
                    int numConta = ler.nextInt();
                    for (int i = 0; i < tam; i++) {
                        if(numConta == contas.get(i).getNumero()){
                            System.out.println("Saldo atual: R$" + usuario.getSaldo());
                            System.out.println("Digite o valor que quer transferir para " + contas.get(i).getNome() +":");
                            valor = ler.nextDouble();
                            usuario.transfere(contas.get(i), valor);
                        }
                    }
                    break;
                case 4:
                    listar(usuario);
                    break;
            }
        }while(operacao !=0);
    }      
    
}
