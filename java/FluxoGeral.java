//Projeto Integrador: Gerenciamento de Estoque
//Versсo java 21.0
//Grupo: Ariel Isidro Nina Saavedra, Bruno Geanini dos Reis, Gabriel Tolcsvai de Cronis, Heloísa Weiss Willwohl Sanches, Mariane Santana da Silva, Miguel Augusto de Oliveira Santos

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

public class FluxoGeral {
  public static void main(String[] args) throws InterruptedException {

  Duration espera = Duration.ofSeconds(2);

  Gerente gerente = new Gerente("gerente3", "gerente3"); //Instancia o objeto gerente, atribuindo valores aos parametros.
  Funcionario funcionario = new Funcionario("funcionario2", "funcionario2"); //Instancia o objeto gerente, atribuindo valores aos parametros.

  ArrayList<Cliente> clientes = new ArrayList<Cliente>(); // Instancia um objeto Cliente do tipo ArrayList, para utilizar vetor de forma dinamica
  ArrayList<Marmita> marmitas = new ArrayList<Marmita>(); // Instancia um objeto do tipo ArrayList, para utilizar vetor de forma dinamica
  Scanner entrada = new Scanner(System.in); // Instancia um objeto Scanner

  // Definições variaveis globais
  String usuario, opcao, opcaoEstoque, login, senha, nome;
  double valor;
  int indice, quantidade, escolha;
  boolean continuar = false, autenticacao, estoque = false, sistemaCliente = false, menuCliente=false;

  // adiciona os valores ao array marmitas
  adicionarMarmitas(marmitas, "Frango com Arroz    ", 15, 18.90);
  adicionarMarmitas(marmitas, "Carne Moída com Purê", 12, 19.90);
  adicionarMarmitas(marmitas, "Macarrão à Bolonhesa", 10, 17.50);
  adicionarMarmitas(marmitas, "Strogonoff de Frango", 14, 21.00);
  adicionarMarmitas(marmitas, "Arroz Carreteiro    ", 16, 21.50);
  limpar(); // limpa o console
  
  // adiciona os valores ao array clientes
  adicionarClientes(clientes, "cliente1", "cliente1");
  adicionarClientes(clientes, "cliente2", "cliente2");
  adicionarClientes(clientes, "cliente3", "cliente3");
  adicionarClientes(clientes, "cliente4", "cliente4");
  adicionarClientes(clientes, "cliente5", "cliente5");
  limpar(); // limpa o console

  System.out.println("Iniciando Sistema ...");
  Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
  limpar(); // limpa o console
  
  while (true) { 
      
    limpar();
    // Menu principal
    System.out.println("________ Entrar como: ________");
    System.out.println("\n  1 - Cliente \n  2 - Funcionario \n  3 - Gerente  \n  4 - Encerrar");
    System.out.println("______________________________");
    System.out.println("\nCom qual opção deseja executar?");
    usuario = entrada.nextLine();
    limpar();

    // escolha do menu principal
    switch(usuario){
      // opção para iniciar o usuario
      case "1":
        System.out.println("Iniciando como Cliente...");
        sistemaCliente = true;
        Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
        // mantem o cliente rodando
        while (sistemaCliente) {  
            while(true){
                limpar(); // limpa o console
                autenticacao = false; // define a autenticacao como falso
                //questiona a opção do usuário para acessar, ou sair do fluxo
                System.out.println("Deseja realizar o login?(ou 0 para sair) \n1 - Sim\n2 - Não"); 
                String realizarLogin = entrada.nextLine();
              
                // verifica se o  usuario não deseja fazer login
                if(realizarLogin.equals("2")){
                    menuCliente = true; // ativa a condição para iniciar o menu
                    break;
                }
                // caso digite 0, encerra o looping de login
                else if (realizarLogin.equals("0")) {
                  limpar();
                  System.out.println("Voltando...");
                  Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
                  sistemaCliente = false; // desativa o fluxo de cliente
                  break;

                } else if(!realizarLogin.equals("1")){
                  System.out.println("Opção inválida, Digite um numero válido");
                  Thread.sleep(1000); //Espera de 1 seg, meramente visual
                  continue;
                }

                // entrada de daddos para realizar o acesso
                limpar();// limpa o console
                System.out.print("Login: "); 
                login=entrada.nextLine();
    
                System.out.print("Senha: "); 
                senha=entrada.nextLine();
                limpar(); // limpa o console
    
                // looping para passar por todos os objetos do arraylist
                for(Cliente cliente : clientes){
                    //verifica se os dados de entrada condizem com os armazenados
                    if (login.equals(cliente.login) && senha.equals(cliente.senha)){
                        autenticacao=true; // armazena a informação que foi autenticado um usuario
                        menuCliente = true;  // ativa a condição para iniciar o menu
                        System.out.println("Login realizado com sucesso!!");
                        Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
                        break;
                    } 
                }
                //verifica se autenticacao é falsa e informa que o login está inválido
                if (!autenticacao) {
                    System.out.println("Login ou senha inválidos!");
                    Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
                }
                break;
            }
            // verifica se o sistema cliente foi finalizado, para encerra-lo
            if (!sistemaCliente) {
              break;
            }
            // inicia o lopping do menu
            while(menuCliente) {
                // informação que está entrando no menu
                limpar(); // limpa o console
                System.out.println("Acessando Menu...");
                Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
 
                limpar(); // limpa o console
                
                //apresenta a lista de marmitas
                visualizarMarmitas(marmitas);

                //recebe a entrada para utilizar na escolha do menu
                System.out.println("\nDeseja comprar?\n1 - Sim\n2 - Não");
                opcao = entrada.nextLine();
    
                switch (opcao) {
                    // entra na opção de compra
                    case "1":
                        limpar();
                        visualizarMarmitas(marmitas);

                        // Cria o loop para manter até informar um numero inteiro
                        while(true){
                            try {
                                System.out.println("\nDigite o código da marmita desejada: (ou 0 para sair)");
                                String i = entrada.nextLine();
                                indice = Integer.parseInt(i);
                                // diminui o indice para que se iguale ao indice do vetor
                                indice -= 1;
                                if(indice == -1){
                                    break;
                                }
                                // verifica se o indice está de acordo com o que existe no projeto
                                if (indice >= marmitas.size() || indice < 0){
                                    System.out.println("Indice inexistente, por favor digite um indice válido");
                                    continue;
                                }
                                break;
                            // verifica se o número digitado é inteiro
                            } catch(NumberFormatException e) {
                                System.out.println("Por favor digite um número inteiro");
                                continue;
                            }
                        }
                        // verifica se o valor digitado foi 0 (como formata diminuindo 1, o valor 0 digitado pelo usuario vira -1)
                        if(indice == -1){
                            limpar(); // limpa o console
                            System.out.println("voltando...");
                            Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
                            limpar(); // limpa o console
                            break;
                        }

                        limpar(); // limpa o console
                        // abre o looping para comprar a marmita
                        while(true){
                            System.out.println("Marmita - " + marmitas.get(indice).nome);
                            try{
                                System.out.println("Digite a quantidade que deseja comprar: (ou 0 para sair)");
                                String quantidadeString = entrada.nextLine();
                                quantidade = Integer.parseInt(quantidadeString);

                                // validação se foi número positivo, se tem a quantidade em estoque e se é numero inteiro
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

                        // valida se digitou 0 para sair
                        if(quantidade == 0){
                          System.out.println("Voltando...");
                          Thread.sleep(espera.toMillis());
                          continuar = false;
                          break;
                        }
                        comprarMarmitas(marmitas, indice, quantidade); // executa a função para realizar a compra e subtrair a quantidade em sistema
                        System.out.println("Ação bem sucedida!");
                        Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
                        break;
                    //desativa o menu cliente encerrando o fluxo de menu
                    case "2":
                        menuCliente = false;
                        System.out.println("Voltando...");
                        Thread.sleep(espera.toMillis());
                        break;
                    // pede uma opção válida em caso de digitar algo fora das opções
                    default:
                        System.out.println("Opção inválida, por favor digite uma opção válida");
                        Thread.sleep(espera.toMillis());
                        limpar();
                }
            }
        }
        break;
      // entra no fluxo do funcionário
      case "2":
        System.out.println("Iniciando como Funcionario...");
        Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
        limpar(); // limpa o console

        // inicia looping de login
        while(true){
          System.out.print("Login: "); 
          login=entrada.next();

          System.out.print("Senha: "); 
          senha=entrada.next();
          limpar(); // limpa o console

          // valida se os dados digitados condizem com o funcionário cadastrado
          if (login.equals(funcionario.login) && senha.equals(funcionario.senha)){
            continuar=true;
          break;
          }
          System.out.println("login Invalido!\nDigite novamente\n");
          Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
          limpar(); // limpa o console
          continue;
        }


        System.out.println("Login realizado com sucesso!!");
        Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
        
        limpar();

        // entra no looping onde o funcionário pode editar
        while (continuar) {  

          System.out.println("________ Ações ________");
          System.out.println("\n  1 - Notificação \n  2 - Estoque  \n  3 - Pedidos \n  4 - Encerrar");
          System.out.println("_______________________");

          System.out.println("\nQual opção deseja executar?");
          opcao = entrada.nextLine();
          limpar();

          // abertura das escplhas das opções do funcionario
          switch (opcao) {

            // abre notificações
            case "1":

              System.out.println("Abrindo Notificações...");
              Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
              limpar();

              System.out.println("_____ Notificações _____");
              System.out.println("\n Em manutenção...");

              System.out.println("\n Em alguens segundos será redirecionado...");
              Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
              limpar();

            break;

            // abre o estoque
            case "2":

              estoque = true;
              // inicia o menu do estoque
              while (estoque) {

                System.out.println("________ Ações do Estoque ________");
                System.out.println("\n  1 - Visualizar \n  2 - Alterar quantidade  \n  3 - Encerrar");
                System.out.println("_______________________");

                System.out.println("\nQual opção deseja executar?");
                opcaoEstoque = entrada.nextLine();
                limpar();

                // escolha das opções do estoque
                switch (opcaoEstoque) {

                  // visualizar o estoque de marmitas
                  case "1":

                    limpar();
                    visualizarMarmitas(marmitas);

                    // mantém a visualização do estoque até digitar 0 
                    while (true) {
                      try {
                        System.out.println("\nDigite 0 para voltar: ");
                        escolha = Integer.parseInt(entrada.nextLine());

                        if (escolha == 0) {
                          limpar();
                          System.out.println("voltando...");
                          Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
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
                    // alteração de marmitas
                    case "2":

                      limpar();
                      visualizarMarmitas(marmitas);

                      // mantém executando até informar um indice válido
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
                      // se digitar indice 0 quebra 
                      if (indice == 0) break;

                      // mantém executando até informar uma quantidade válidade
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

                      updateMarmitas(marmitas, indice - 1, quantidade); // função que atualiza a quantidade da marmita

                      limpar();
                      System.out.println("Ação bem sucedida!");
                      Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual

                      visualizarMarmitas(marmitas); 
                      Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
                      limpar();

                      break;
                    
                    // encerra o menu do estoque
                    case "3": 
                      System.out.println("Encerrando...");
                      Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
                      estoque = false;
                      break;
                    
                    // opção inválida
                    default:
                      System.out.println("Opção inválida");
                      Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
                      limpar();
                  
                }
              }

              break;
            // abre pedidos 
            case "3":

              System.out.println("Abrindo Pedidos...");
              Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
              limpar();

              System.out.println("_____ Pedidos _____");
              System.out.println("\n Em manutenção...");

              System.out.println("\n Em alguens segundos será redirecionado...");
              Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
              limpar();

              break;

            // desativa o menu de funcionario voltando para o fluxo principal
            case "4":
                  System.out.println("Voltando...");
                  Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
                  limpar();
                  continuar = false;
              break;
          
            }
          }
            break;
      // abre o fluxo de gerente
      case "3":
        System.out.println("Iniciando como Gerente...");
        Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
        limpar(); // limpa o console
        
        // inicia lopping de entrar na conta do gerente
        while(true){
          System.out.print("Login: "); 
          login=entrada.next();

          System.out.print("Senha: "); 
          senha=entrada.next();
          limpar(); // limpa o console

          if (login.equals(gerente.login) && senha.equals(gerente.senha)){
          continuar=true;
          break;
          }
          System.out.println("login Invalido!\nDigite novamente\n");
          Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
          limpar(); // limpa o console
          continue;
        }

        System.out.println("Login realizado com sucesso!!");
        Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
    
        limpar();
        // inicia o looping do menu do gerente
        while (continuar) {

          limpar();
          System.out.println("________ Ações ________");
          System.out.println("\n  1 - Notificação \n  2 - Estoque \n  3 - Pedidos  \n  4 - Gerenciar Funcionarios \n  5 - Encerrar");
          System.out.println("_______________________");

          System.out.println("\nQual opção deseja executar?");
          opcao = entrada.next();
          limpar();

          switch (opcao) {
            // abre notificações
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
            // abre o menu de estoque
            case "2":

              estoque = true;

              // inicia o looping de se manter no menu de estoque
              while (estoque) {

                limpar();
                System.out.println("_____Ações do Estoque_____");
                System.out.println("\n  1 - Criar Marmita \\n  2 - Remover Marmita \\n  3 - Alterar quantidade  \\n  4 - Sair");
                System.out.println("_________________________");

                System.out.println("\nQual opção deseja executar?");
                opcaoEstoque = entrada.nextLine();
                limpar();
                // escolha de opções de estoque
                switch (opcaoEstoque) { 
                  // realiza a criação da marmita
                  case "1":

                    // mantém o loop até digitar um valor válido
                      while (true) {     
                        limpar(); // limpa o console

                        visualizarMarmitas(marmitas);// visualiza marmita

                        // armazena o nome desejado da marmita 
                        System.out.println("\nDigite o nome da marmita: ");
                        nome = entrada.nextLine();
                        // valida se a String está vazia
                        if(nome.trim().isEmpty()){
                          limpar(); // limpa o console
                          System.out.println("valor vazio, por favor utilize palavras");
                          Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
                          continue;
                          }
                          // valida se foi digitado somente letras
                          if(!nome.matches("[a-zA-ZÀ-ÿ\\s]+")){
                            limpar(); // limpa o console
                            System.out.println("Por favor utilize somente palavras");
                            Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
                            continue;
                          }
                          break;
                          }
                      // mantém executando até colocar um valor de quantidade válido
                      while(true){
                        try{
                          System.out.println("\nDigite a quantidade deste sabor: ");
                          String quantidadeString = entrada.nextLine();
                          quantidade = Integer.parseInt(quantidadeString);
                          if(quantidade<0){
                            System.out.println("Digite somente valores positivos, se estiver em falta, utilize 0");
                            continue;
                          }
                          break;
                        }  catch(NumberFormatException e) {
                            System.out.println("Por favor digite um número inteiro");
                            continue;
                        }
                      }
                      // mantém executando até colocar um valor válido
                      while(true){
                          try{
                            System.out.println("\nDigite o valor da marmita: ");
                            String valorString = entrada.nextLine();
                            valor = Double.parseDouble(valorString);
                            if(valor<0){
                                System.out.println("Digite somente valores positivos, se for um brinde, utilize 0");
                                continue;
                            }
                              break;
                            } catch(NumberFormatException e) {
                              System.out.println("Por favor digite um número");
                              continue;
                          }
                      }

                      adicionarMarmitas(marmitas, nome, quantidade, valor);
                      limpar();
                      break;

                  // entra no fluxo de remover a marmita
                  case "2":

                    limpar(); // limpa o console
                      visualizarMarmitas(marmitas);

                      while(true){
                        try {
                          System.out.println("\nDigite o cod do item que deseja remover: (ou 0 para sair)");
                          String i = entrada.nextLine();
                          indice = Integer.parseInt(i);
                            // verifica se o indice está de acordo com o que existe no projeto
                          if (indice > marmitas.size() || indice < 0){
                            System.out.println("Indice inexistente, por favor digite um indice válido");
                            continue;
                            }
                            break;
                        } catch(NumberFormatException e) {
                          System.out.println("Por favor digite um número inteiro");
                          continue;
                        }
                      }

                      if(indice == 0){
                        limpar(); // limpa o console
                        System.out.println("voltando...");
                        Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
                        limpar(); // limpa o console
                        break;
                      }

                      removerMarmitas(marmitas, indice - 1);

                      limpar(); // limpa o console

                      System.out.println("Ação bem sucedida!");
                      Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
                      limpar(); // limpa o console

                      System.out.println("O estoque se encontra assim:\n");
                      visualizarMarmitas(marmitas);
                      Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
                      limpar(); // limpa o console

                      break;
                  // entra no fluxo para alterar a quantidade da marmita
                  case "3":

                    limpar(); // limpa o console
                      visualizarMarmitas(marmitas);

                      // Cria o loop para manter até informar um numero inteiro
                      while(true){
                        try {
                          System.out.println("\nDigite o cod do item que deseja alterar: (ou 0 para sair)");
                          String i = entrada.nextLine();
                          indice = Integer.parseInt(i);
                          // verifica se o indice está de acordo com o que existe no projeto
                          if (indice > marmitas.size() || indice < 0){
                            System.out.println("Indice inexistente, por favor digite um indice válido");
                            continue;
                            }
                            break;
                        } catch(NumberFormatException e) {
                            System.out.println("Por favor digite um número inteiro");
                            continue;
                        }
                      }

                      if(indice == 0){
                        limpar(); // limpa o console
                        System.out.println("voltando...");
                        Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
                        limpar(); // limpa o console
                        break;
                      }

                      // executa até informar um valor válido
                      while(true){
                        try{
                          System.out.println("Digite a quantidade adicionar/retirar ex: (+10) / (-10)");
                          String q = entrada.nextLine();
                          quantidade = Integer.parseInt(q);
                          
                          if(marmitas.get(indice-1).quantidade + quantidade < 0){
                            System.out.println("quantidade insuficiente em estoque");
                            continue;
                            }
                            break;
                        }  catch(NumberFormatException e) {
                          System.out.println("Por favor digite um número inteiro");
                          continue;
                        }
                      }

                      updateMarmitas(marmitas, indice - 1, quantidade);

                      // limpar(); // limpa o console

                      System.out.println("Ação bem sucedida!");
                      Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
                      // limpar();

                      System.out.println("O estoque se encontra assim:\n");
                      visualizarMarmitas(marmitas);
                      Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
                      limpar();

                    break;
                  // encerra o fluxo do estoque
                  case "4": 
                    System.out.println("Encerrando...");
                    Thread.sleep(espera.toMillis());
                    estoque = false;
                    break;
                  // opção inválida
                  default:
                    System.out.println("Opção inválida");
                    Thread.sleep(espera.toMillis());
                    limpar();
                }
              }

              break;
            // abre pedidos
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

            // abre gerenciamento de funcionarios
            case "4":
              System.out.println("Entrando em Gerenciamento de Funcionarios...");
              Thread.sleep(espera.toMillis());
              limpar();

              System.out.println("_____ Gerenciamento de Funcionarios _____");
              System.out.println("\n Em manutenção...");

              System.out.println("\n Em alguens segundodos será redirecionado...");
              Thread.sleep(espera.toMillis());
              limpar();
              break;

            // desativa o fluxo gerente e volta para o fluxo principal
            case "5":

              System.out.println("Voltando...");
              Thread.sleep(espera.toMillis());
              continuar = false;
              break;
            // opção inválida, pede para informar uma opção válida
            default:
              System.out.println("Opção inválida, por favor digite uma opção válida");
              Thread.sleep(espera.toMillis());
              limpar();          
          }
        }
    
        break;
      // encerra o programa
      case "4":
        System.out.println("Encerrando...");
        entrada.close();
        return; // encerra o programa corretamente
      }
    }
  }
  
  
  // Função para adicionar marmitas, onde recebe o arraylist, e os atributos da classe marmita
  public static void adicionarMarmitas(ArrayList<Marmita> marmitas, String nome, int quantidade, double valor) {
    marmitas.add(new Marmita(nome, quantidade, valor));
  }
   // Função para adicionar cliente, onde recebe o arraylist, e os atributos da classe clientes
  public static void adicionarClientes(ArrayList<Cliente>clientes, String login, String senha){
    clientes.add(new Cliente(login, senha));
  }

  // Função para o cliente realizar a compra, recebe o arraylist marmita, o indice da marmita escolhida e a quantidade
  public static void comprarMarmitas(ArrayList<Marmita> marmitas, int indice, int quantidade) {
    Marmita m = marmitas.get(indice);
    m.quantidade -= quantidade;
  }

  // Função para vizualizar todas as marmitas, recebe o arraylist da marmita
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

  // Função para remover marmitas, recebe o arraylist marmita, o indice da marmita escolhida
  public static void removerMarmitas(ArrayList<Marmita> marmitas, int indice) {
    marmitas.remove(indice);
  }

  // Função para realizar a atualização da quantidade da marmita, recebe o arraylist marmita, o indice da marmita escolhida e a quantidade
  public static void updateMarmitas(ArrayList<Marmita> marmitas, int indice, int quantidade) {
    Marmita m = marmitas.get(indice);
    m.quantidade += quantidade;
  }

  // Função para limpar o console
  public static void limpar() {
    try {
      // verifica se é windows para utilizar comandos do windows, se não utiliza outro comando
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

// Cria a classe marmita
class Marmita {
    //atributos
    String nome;
    double valor;
    int quantidade;

    // construtor
    public Marmita(String nome, int quantidade, double valor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }
}

// Cria a classe Funcionario 
class Funcionario {
    String login;
    String senha;

    // construtor
    public Funcionario(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
}

// Cria a classe Gerente 
class Gerente {
    String login;
    String senha;

    // construtor
    public Gerente(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
}

//Cria a classe cliente
class Cliente {
    //Atributos
    String login; 
    String senha;

    // construtor
    public Cliente(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
}
