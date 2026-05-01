//Projeto Integrador: Gerenciamento de Estoque
//Versсo Java 21.0
//Grupo: Ariel Isidro Nina Saavedra, Bruno Geanini dos Reis, Gabriel Tolcsvai de Cronis, Heloísa Weiss Willwohl Sanches, Mariane Santana da Silva, Miguel Augusto de Oliveira Santos

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

public class FluxoFuncionario {
  public static void main(String[] args) throws InterruptedException {

    Duration espera = Duration.ofSeconds(2);

    Funcionario funcionario  = new Funcionario("1", "1"); 


    ArrayList<Marmita> marmitas = new ArrayList<Marmita>(); 
    Scanner entrada = new Scanner(System.in); 

    String opcao, opcaoEstoque, login, senha;
    int indice, quantidade, escolha;
    boolean continuar = false, estoque = false;

    adicionarMarmitas(marmitas, "Frango com Arroz    ", 15, 18.90);
    adicionarMarmitas(marmitas, "Carne Moída com Purê", 12, 19.90);
    adicionarMarmitas(marmitas, "Macarrão à Bolonhesa", 10, 17.50);
    adicionarMarmitas(marmitas, "Strogonoff de Frango", 14, 21.00);
    adicionarMarmitas(marmitas, "Arroz Carreteiro    ", 16, 21.50);
    limpar(); 

    System.out.println("Iniciando como Funcionario...");
    Thread.sleep(espera.toMillis()); 
    limpar(); 

    while(true){
      System.out.print("Login: "); 
      login=entrada.nextLine();

      System.out.print("Senha: "); 
      senha=entrada.nextLine();
      limpar(); 

      if (login.equals(funcionario.login) && senha.equals(funcionario.senha)){
      continuar=true;
      break;
      }
      System.out.println("login Invalido!\nDigite novamente\n");
      Thread.sleep(espera.toMillis());
      limpar();
      continue;
    }


    System.out.println("Login realizado com sucesso!!");
    Thread.sleep(espera.toMillis());
    
    limpar();

    while (continuar) {  

      System.out.println("________ Ações ________");
      System.out.println("\n  1 - Notificação \n  2 - Estoque  \n  3 - Pedidos \n  4- Encerrar");
      System.out.println("_______________________");

      System.out.println("\nQual opção deseja executar?");
      opcao = entrada.nextLine();
      limpar();

      switch (opcao) {

        case "1":

          System.out.println("Abrindo Notificações...");
          Thread.sleep(espera.toMillis());
          limpar();

          System.out.println("_____ Notificações _____");
          System.out.println("\n Em manutenção...");

          System.out.println("\n Em alguens segundodos será redirecionado...");
          Thread.sleep(espera.toMillis());
          limpar();

        break;

        case "2":

          estoque = true;

          while (estoque) {

            System.out.println("________ Ações do Estoque ________");
            System.out.println("\n  1 - Visualizar \n  2 - Alterar quantidade  \n  3 - Encerrar");
            System.out.println("_______________________");

            System.out.println("\nQual opção deseja executar?");
            opcaoEstoque = entrada.nextLine();
            limpar();

            switch (opcaoEstoque) {

              case "1":

                limpar();
                visualizarMarmitas(marmitas);

                while (true) {
                  try {
                    System.out.println("\nDigite 0 para voltar: ");
                    escolha = Integer.parseInt(entrada.nextLine());

                    if (escolha == 0) {
                      limpar();
                      System.out.println("voltando...");
                      Thread.sleep(espera.toMillis());
                      limpar();
                      break;
                    } else {
                      System.out.println("Digite apenas 0 para voltar");
                    }

                  } catch (NumberFormatException e) {
                    System.out.println("Digite apenas 0 para voltar");
                  }
                }

                  break;

                case "2":

                  limpar();
                  visualizarMarmitas(marmitas);

                  while (true) {
                    try {
                      System.out.println("\nDigite o cod do item (ou 0 para sair)");
                      indice = Integer.parseInt(entrada.nextLine());

                      if (indice > marmitas.size() || indice < 0) {
                        System.out.println("Indice inválido");
                        continue;
                      }
                      break;

                    } catch (NumberFormatException e) {
                        System.out.println("Digite um número inteiro");
                    }
                  }

                  if (indice == 0) break;

                  while (true) {
                    try {
                      System.out.println("Digite a quantidade (+/-)");
                      quantidade = Integer.parseInt(entrada.nextLine());

                      if (marmitas.get(indice - 1).quantidade + quantidade < 0) {
                        System.out.println("Estoque insuficiente");
                        continue;
                      }
                      break;

                    } catch (NumberFormatException e) {
                      System.out.println("Digite um número inteiro");
                    }
                  }

                  updateMarmitas(marmitas, indice - 1, quantidade);

                  limpar();
                  System.out.println("Ação bem sucedida!");
                  Thread.sleep(espera.toMillis());

                  visualizarMarmitas(marmitas);
                  Thread.sleep(espera.toMillis());
                  limpar();

                  break;

                case "3": 
                  System.out.println("Encerrando...");
                  Thread.sleep(espera.toMillis());
                  estoque = false;
                  break;

                default:
                  System.out.println("Opção inválida");
                  Thread.sleep(espera.toMillis());
                  limpar();
            }
          }

          break;
        
        case "3":

          System.out.println("Abrindo Pedidos...");
          Thread.sleep(espera.toMillis());
          limpar();

          System.out.println("_____ Pedidos _____");
          System.out.println("\n Em manutenção...");

          System.out.println("\n Em alguens segundodos será redirecionado...");
          Thread.sleep(espera.toMillis());
          limpar();

          break;


        case "4":
              System.out.println("Voltando...");
              Thread.sleep(espera.toMillis());
              limpar();
              continuar = false;
          break;
      
      }

    }entrada.close();
  }

    public static void adicionarMarmitas(ArrayList<Marmita> marmitas, String nome, int quantidade, double valor) {
        marmitas.add(new Marmita(nome, quantidade, valor));
    }

    public static void visualizarMarmitas(ArrayList<Marmita> marmitas) {
        int visualizador;
        System.out.println(" Cod |        Marmitas        | qtd | Valor ");
        System.out.println("-------------------------------------------");

        for (int i = 0; i < marmitas.size(); i++) {
            Marmita m = marmitas.get(i);
            visualizador = i + 1;
            System.out.printf("  %d  | %s |  %d  | %.2f\n", visualizador, m.nome, m.quantidade, m.valor);
        }
    }

    public static void removerMarmitas(ArrayList<Marmita> marmitas, int indice) {
        marmitas.remove(indice);
    }

    public static void updateMarmitas(ArrayList<Marmita> marmitas, int indice, int quantidade) {
        Marmita m = marmitas.get(indice);
        m.quantidade += quantidade;
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
 
class Funcionario {
  
    String login; 
    String senha;

    public Funcionario(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
}
