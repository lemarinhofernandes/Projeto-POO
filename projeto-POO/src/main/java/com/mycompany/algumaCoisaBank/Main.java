package com.mycompany.algumaCoisaBank;

import com.mycompany.AlgumaCoisaBank.model.Conta;
import com.mycompany.AlgumaCoisaBank.model.ContaCorrente;
import com.mycompany.AlgumaCoisaBank.model.ContaPoupanca;
import com.mycompany.AlgumaCoisaBank.model.ContaUniversitaria;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Scanner lerString = new Scanner(System.in);
        ArrayList<Conta> contas = new ArrayList();
        Conta dudu = new ContaCorrente(2134, 22222, "Dudu");
        Conta jose = new ContaPoupanca(1234, 22222, "Jose");
        contas.add(dudu);
        contas.add(jose);
        int opcao;
        int n = contas.size();
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
                   contas.forEach((Conta lista) -> lista.toString(lista));
                   break;
               case 3:
                   //Entra numa conta e realiza as operações desejadas
                   //precisa implementar saporra ai ainda kkk
                   int numEncontrar = numEncontrar(ler);
                   for(int i=0; i < n; i++) {
                       if(numEncontrar == contas.get(i).getNumero())
                           menuOperacoes(contas.get(i), contas);
                       break;
                   }
                   break;
               case 4:
                   //Procura e exclui uma conta a partir do index no "for"
                   int numExcluir = numEncontrar(ler);
                   for(int i=0; i < n; i++) {
                       if(numExcluir == contas.get(i).getNumero())
                           contas.remove(i);
                   }
                   break;
           }
        }while(opcao!=0);
        
    }

    private static void menu() {
        System.out.println("=== BEM VINDO ===");
        System.out.println("1 - Cria conta");
        System.out.println("2 - Lista contas");
        System.out.println("3 - Entrar em uma conta");
        System.out.println("4 - Exclui conta cadastrada");
        System.out.println("0 - sair");
        System.out.println("escolha: ");

    }

    private static int numEncontrar(Scanner ler) {
        int num;
        System.out.println("Digite o numero da conta que voce deseja encontrar: ");
        return num = ler.nextInt();
    }

    private static void adicionaConta(ArrayList<Conta> contas, Scanner ler, Scanner lerString) {
        System.out.println("Digite a agencia: ");
        int agencia = ler.nextInt();
        System.out.println("Digite o numero da conta: ");
        int numero = ler.nextInt();
        System.out.println("Informe o nome do proprietario: ");
        String nome = lerString.nextLine();
        System.out.println("tipo conta\n1 - corrente\n2 - poupanca\n3 - salario");
        int tipo = ler.nextInt();
        switch (tipo) {
            case 1:
                Conta corrente = new ContaCorrente(numero, agencia, nome);
                corrente.toString(corrente);
                contas.add(corrente);
                break;
            case 2:
                Conta poupanca = new ContaPoupanca(numero, agencia, nome);
                poupanca.toString(poupanca);
                contas.add(poupanca);
                break;
            default:
                Conta salario = new ContaUniversitaria(numero, agencia, nome);
                salario.toString(salario);
                contas.add(salario);
                break;
        }
    }

    private static void menuOperacoes(Conta get, ArrayList<Conta> contas) {
        System.out.println("=== MENU DE OPERAÇÕES ===");
        System.out.println("1 - deposito");
        System.out.println("2 - saque");
        System.out.println("3 - transferencia");
        System.out.println("Escolha: ");
    }
}
