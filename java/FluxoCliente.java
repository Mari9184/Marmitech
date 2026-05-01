//Projeto Integrador: Gerenciamento de Estoque
//Versсo Portugol Webstudio
//Grupo: Ariel Isidro Nina Saavedra, Bruno Geanini dos Reis, Gabriel Tolcsvai de Cronis, Heloísa Weiss Willwohl Sanches, Mariane Santana da Silva, Miguel Augusto de Oliveira Santos

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;
public class FluxoCliente{
    public static void main(String[]args)throws InterruptedException{
        
        Duration espera = Duration.ofSeconds(2);

        ArrayList<Cliente> clientes = new ArrayList<Cliente>(); 
        ArrayList<Marmita> marmitas = new ArrayList<Marmita>();
        Scanner entrada = new Scanner(System.in);

        String opcao, login, senha;
        int indice, quantidade;
        boolean autenticacao, sistemaCliente = true, menuCliente=false;

        adicionarMarmitas(marmitas, "Frango com Arroz    ", 15, 18.90);
        adicionarMarmitas(marmitas, "Carne Moída com Purê", 12, 19.90);
        adicionarMarmitas(marmitas, "Macarrão à Bolonhesa", 10, 17.50);
        adicionarMarmitas(marmitas, "Strogonoff de Frango", 14, 21.00);
        adicionarMarmitas(marmitas, "Arroz Carreteiro    ", 16, 21.50);

        adicionarClientes(clientes, "cliente1", "cliente1");
        adicionarClientes(clientes, "cliente2", "cliente2");
        adicionarClientes(clientes, "cliente3", "cliente3");
        adicionarClientes(clientes, "cliente4", "cliente4");
        adicionarClientes(clientes, "cliente5", "cliente5");
        limpar(); 

        System.out.println("Iniciando como Cliente...");
        Thread.sleep(espera.toMillis()); 
        
        while (sistemaCliente) {  
            while(true){
                limpar(); 
                autenticacao = false;
                System.out.println("deseja realizar o login?\n1 - Sim\n2 - Não");
                String realizarLogin = entrada.nextLine();
    
                if(realizarLogin.equals("2")){
                    menuCliente = true;
                    break;
                } 
                limpar();
                System.out.print("Login: "); 
                login=entrada.nextLine();
    
                System.out.print("Senha: "); 
                senha=entrada.nextLine();
                limpar(); 
    
                for(Cliente cliente : clientes){
                    if (login.equals(cliente.login) && senha.equals(cliente.senha)){
                        autenticacao=true;
                        menuCliente = true;
                        System.out.println("Login realizado com sucesso!!");
                          Thread.sleep(espera.toMillis());
                        break;
                    } 
                }
                if (!autenticacao) {
                    System.out.println("Login ou senha inválidos!");
                      Thread.sleep(espera.toMillis()); 
                }
                break;
            }
            while(menuCliente) {
                limpar();
                System.out.println("Acessando Menu...");
                  Thread.sleep(espera.toMillis()); 

                limpar();

                visualizarMarmitas(marmitas);

                System.out.println("Deseja comprar?\n1 - Sim\n2 - Não");
                opcao = entrada.nextLine();
    
                switch (opcao) {
                    case "1":
                        limpar();
                        visualizarMarmitas(marmitas);

                        while(true){
                            try {
                                System.out.println("\nDigite o código da marmita desejada: (ou 0 para sair)");
                                String i = entrada.nextLine();
                                indice = Integer.parseInt(i);
                                indice -= 1;
                                if(indice == -1){
                                    break;
                                }
   
                                if (indice >= marmitas.size() || indice < 0){
                                    System.out.println("Indice inexistente, por favor digite um indice válido");
                                    continue;
                                }
                                break;
                            } catch(NumberFormatException e) {
                                System.out.println("Por favor digite um número inteiro");
                                continue;
                            }
                        }

                        if(indice == -1){
                            limpar(); 
                            System.out.println("voltando...");
                            Thread.sleep(espera.toMillis()); 
                            limpar(); 
                            break;
                        }
                        limpar();
                        while(true){
                            System.out.println("Marmita - " + marmitas.get(indice).nome);
                            try{
                                System.out.println("Digite a quantidade que deseja comprar: (ou 0 para sair)");
                                String quantidadeString = entrada.nextLine();
                                quantidade = Integer.parseInt(quantidadeString);

                                
                                if(quantidade<0){
                                    System.out.println("Por favor Digite um número positivo");
                                    continue;
                                }  
                                else if(marmitas.get(indice).quantidade - quantidade < 0){
                                    System.out.println("quantidade insuficiente em estoque");
                                    continue;
                                }
                                break;
                            }  catch(NumberFormatException e) {
                                System.out.println("Por favor digite um número inteiro");
                                continue;
                            }
                        }

                        if(quantidade == 0){
                            limpar(); 
                            System.out.println("voltando...");
                            limpar(); 
                            break;
                        }
                        comprarMarmitas(marmitas, indice, quantidade);
                        System.out.println("Ação bem sucedida!");
                        Thread.sleep(espera.toMillis()); 
                        break;

                    case "2":
                        menuCliente = false;
                        System.out.println("Voltando...");
                        Thread.sleep(espera.toMillis());
                        break;
                    default:
                        System.out.println("Opção inválida, por favor digite uma opção válida");
                        Thread.sleep(espera.toMillis());
                        limpar();
                }
                entrada.close();
            }
        }

    }
    public static void limpar() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("outo ao limpar o terminal: " + e.getMessage());
        }
    }
    public static void comprarMarmitas(ArrayList<Marmita> marmitas, int indice, int quantidade) {
        Marmita m = marmitas.get(indice);
        m.quantidade -= quantidade;
    }
    public static void visualizarMarmitas(ArrayList<Marmita> marmitas) {
        int visualizador;
        System.out.println(" Cod |         Sabor         | qtd | Valor ");
        System.out.println("-------------------------------------------");

        for (int i = 0; i < marmitas.size(); i++) {
            Marmita m = marmitas.get(i);
            visualizador = i + 1;
            System.out.printf("  %d  | %s |  %d  | %.2f\n", visualizador, m.nome, m.quantidade, m.valor);
        }
    }
    public static void adicionarMarmitas(ArrayList<Marmita> marmitas, String nome, int quantidade, double valor) {
        marmitas.add(new Marmita(nome, quantidade, valor));
    }
    public static void adicionarClientes(ArrayList<Cliente>clientes, String login, String senha){
        clientes.add(new Cliente(login, senha));
    }
}
class Marmita {
    String nome;
    double valor;
    int quantidade;

    public Marmita(String nome, int quantidade, double valor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }
}

class Cliente {

    String login; 
    String senha;

    public Cliente(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
}
