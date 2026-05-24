//Projeto Integrador: Gerenciamento de Estoque
//Versсo java 21.0
//Grupo: Ariel Isidro Nina Saavedra, Bruno Geanini dos Reis, Gabriel Tolcsvai de Cronis, Heloísa Weiss Willwohl Sanches, Mariane Santana da Silva, Miguel Augusto de Oliveira Santos

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Duration espera = Duration.ofSeconds(2);

        Gerente gerente = new Gerente("gerente3", "gerente3"); //Instancia o objeto gerente, atribuindo valores aos parametros.
        ArrayList<Cliente> clientes = new ArrayList<>(); // Instancia um objeto Cliente do tipo ArrayList, para utilizar vetor de forma dinamica
        ArrayList<Marmita> marmitas = new ArrayList<>(); // Instancia um objeto do tipo ArrayList, para utilizar vetor de forma dinamica
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        Scanner entrada = new Scanner(System.in); // Instancia um objeto Scanner

        // Definições variaveis globais
        String usuario, opcao, opcaoEstoque, login, senha, nome;
        double valor;
        int indice, quantidade, escolha;
        boolean continuar = false, autenticacao, estoque, sistemaCliente , menuCliente=false, gerirFuncionario;

        // adiciona os valores ao array marmitas
        adicionarMarmitas(marmitas, "Frango com Arroz    ", 15, 18.90);
        adicionarMarmitas(marmitas, "Carne Moída com Purê", 4 , 19.90);
        adicionarMarmitas(marmitas, "Macarrão à Bolonhesa", 10, 17.50);
        adicionarMarmitas(marmitas, "Strogonoff de Frango", 14, 21.00);
        adicionarMarmitas(marmitas, "Arroz Carreteiro    ", 16, 21.50);
        limpar(); // limpa o console

        // adiciona os valores ao array clientes
        adicionarClientes(clientes, "cliente1", "1234");
        adicionarClientes(clientes, "cliente2", "5678");
        limpar(); // limpa o console

        // adicionando Funcionarios ao array funcionarios

        adicionarFuncionario(funcionarios, "Funcionario1", "1234");
        adicionarFuncionario(funcionarios, "Funcionario2", "5678");
        limpar();

        System.out.println("Iniciando Sistema ...");
        Thread.sleep(espera); //Espera de 2 seg, meramente visual
        limpar(); // limpa o console

        while (true) {

            limpar();
            // Menu principal
            System.out.println("________ Entrar com: ________");
            System.out.println("\n  1 - Cliente \n  2 - Funcionário \n  3 - Gerente \n  4 - Encerrar");
            System.out.println("______________________________");
            System.out.println("\nCom qual opção deseja executar?");
            usuario = entrada.nextLine();
            limpar();

            // escolha do menu principal
            switch(usuario){
                // opção para iniciar o usuario
                case "1"-> {
                    System.out.println("Iniciando como Cliente...");
                    sistemaCliente = true;
                    Thread.sleep(espera);//Espera de 2 seg, meramente visual
                    // mantem o cliente rodando
                    while (sistemaCliente) {
                        while(true){
                            limpar(); // limpa o console
                            autenticacao = false; // define a autenticacao como falso
                            //questiona a opção do usuário para acessar, ou sair do fluxo
                            System.out.println("Deseja realizar o login?(ou 0 para sair)\n \n 1 - Sim\n 2 - Não \n 3 - Não tenho Login");
                            System.out.println("\nInforme opção que deseja executar: ");
                            String realizarLogin = entrada.nextLine();

                            // verifica se o  usuario não deseja fazer login
                            if(realizarLogin.equals("2")){
                                menuCliente = true; // ativa a condição para iniciar o menu
                                break;
                            }
                            else if(realizarLogin.equals("3")){

                                System.out.println("_____ Cadastro Novo _____");

                                System.out.println("\nLogin: ");
                                login = entrada.nextLine();

                                System.out.println("\nsenha");
                                senha = entrada.nextLine();

                                adicionarClientes(clientes, login, senha);
                                limpar();

                                System.out.println("Cliente cadastrado com sucesso!");
                                Thread.sleep(espera);
                                limpar();

                            }
                            // caso digite 0, encerra o looping de login
                            else if (realizarLogin.equals("0")) {
                                limpar();
                                System.out.println("Voltando...");
                                Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                sistemaCliente = false; // desativa o fluxo de cliente
                                break;

                            } else if(!realizarLogin.equals("1")){
                                System.out.println("Opção inválida, Digite um numero válido");
                                Thread.sleep(espera); //Espera de 1 seg, meramente visual
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
                                    Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                    break;
                                }
                            }
                            //verifica se autenticacao é falsa e informa que o login está inválido
                            if (!autenticacao) {
                                System.out.println("Login ou senha inválidos!");
                                Thread.sleep(espera); //Espera de 2 seg, meramente visual
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
                            Thread.sleep(espera); //Espera de 2 seg, meramente visual

                            limpar(); // limpa o console

                            //apresenta a lista de marmitas
                            visualizarMarmitas(marmitas);

                            //recebe a entrada para utilizar na escolha do menu
                            System.out.println("\nDeseja comprar?\n1 - Sim\n2 - Não");
                            opcao = entrada.nextLine();

                            switch (opcao) {
                                // entra na opção de compra
                                case "1"-> {
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
                                                
                                            }
                                            break;
                                            // verifica se o número digitado é inteiro
                                        } catch(NumberFormatException e) {
                                            System.out.println("Por favor digite um número inteiro");
                                            
                                        }
                                    }
                                    // verifica se o valor digitado foi 0 (como formata diminuindo 1, o valor 0 digitado pelo usuario vira -1)
                                    if(indice == -1){
                                        limpar(); // limpa o console
                                        System.out.println("voltando...");
                                        Thread.sleep(espera); //Espera de 2 seg, meramente visual
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
                                                
                                            }
                                            else if(marmitas.get(indice).quantidade - quantidade < 0){
                                                System.out.println("quantidade insuficiente em estoque");
                                                
                                            }
                                            break;
                                        }  catch(NumberFormatException e) {
                                                System.out.println("Por favor digite um número inteiro");
                                                
                                        }
                                    }

                                    double total = marmitas.get(indice).valor * quantidade;

                                    limpar();
                                    System.out.printf("\nTotal da compra: R$ %.2f\n", total);

                                    System.out.println("\n_____ PAGAMENTO _____\n \n 1 - Pix \n 2 - Cartão \n 3 - Dinheiro \n 4 - Cancelar compra");
                                    System.out.println("_______________________");

                                    System.out.println("Selecione a opção a qual deseja pagar: ");
                                    String formaPagamento = entrada.nextLine();

                                    limpar();
                                    switch (formaPagamento) {

                                        case "1"-> {
                                            formaPagamento = "Pix";
                                            System.out.println("\nGerando QR Code Pix...");
                                            Thread.sleep(espera);
                                            limpar();
                                            }

                                        case "2"-> {
                                            formaPagamento = "Cartão";
                                            System.out.println("\nProcessando cartão...");
                                            Thread.sleep(espera);
                                            limpar();
                                            }

                                        case "3"-> {
                                            formaPagamento = "Dinheiro";
                                            System.out.println("\nPagamento em dinheiro...");
                                            Thread.sleep(espera);
                                            limpar();
                                            }

                                        case "4"-> {
                                            System.out.println("\nPagamento cancelado.");
                                            }

                                        default -> {
                                            System.out.println("\nForma de pagamento inválida.");
                                            }
                                    }

                                    System.out.println("\n_____ PAGAMENTO  _____");
                                    System.out.println("Forma: " + formaPagamento);
                                    System.out.printf("Valor: R$ %.2f\n", total);
                                    Thread.sleep(espera);
                                    limpar();

                                    // valida se digitou 0 para sair
                                    if(quantidade == 0){
                                        System.out.println("Voltando...");
                                        Thread.sleep(espera);
                                        continuar = false;
                                        break;
                                    }
                                    comprarMarmitas(marmitas, indice, quantidade); // executa a função para realizar a compra e subtrair a quantidade em sistema


                                    Pedido pedido = new Pedido(
                                        pedidos.size() + 1,
                                        marmitas.get(indice).nome,
                                        quantidade,
                                        marmitas.get(indice).valor,
                                        total,
                                        formaPagamento
                                    );

                                    pedidos.add(pedido);

                                    System.out.println("\n_____ NOTA FISCAL _____");
                                    System.out.println("Pedido: " + pedido.codigo);
                                    System.out.println("Produto: " + pedido.nomeMarmita);
                                    System.out.println("Quantidade: " + pedido.quantidade);
                                    System.out.printf("Valor Unitário: R$ %.2f\n", pedido.valorUnitario);
                                    System.out.printf("Valor Total: R$ %.2f\n", pedido.valorTotal);
                                    System.out.println("Pagamento: " + pedido.formaPagamento);
                                    System.out.println("Status: Pago");
                                    System.out.println("_________________________");

                                    Thread.sleep(espera);
                                    
                                    }
                                //desativa o menu cliente encerrando o fluxo de menu
                                case "2"-> {
                                    menuCliente = false;
                                    System.out.println("Voltando...");
                                    Thread.sleep(espera);
                                    }
                                // pede uma opção válida em caso de digitar algo fora das opções
                                default-> {
                                    System.out.println("Opção inválida, por favor digite uma opção válida");
                                    Thread.sleep(espera);
                                    limpar();
                                }
                            }
                        }
                    }
                }
                // entra no fluxo do funcionário
                case "2"-> {
                    System.out.println("Iniciando como Funcionario...");
                    Thread.sleep(espera); //Espera de 2 seg, meramente visual
                    limpar(); // limpa o console

                    // inicia looping de login
                    while(true){
                        System.out.print("Login: ");
                        login=entrada.nextLine();

                        System.out.print("Senha: ");
                        senha=entrada.nextLine();
                        limpar(); // limpa o console

                        // valida se os dados digitados condizem com o funcionário cadastrado
                        boolean funcionarioAutenticado = false;

                        for (Funcionario funcionario : funcionarios) {
                            if (login.equals(funcionario.login) && senha.equals(funcionario.senha)) {
                                funcionarioAutenticado = true;
                                continuar = true;
                                break;
                            }
                        }
                        if (funcionarioAutenticado) {
                            break;
                        }
                        System.out.println("login Invalido!\nDigite novamente\n");
                        Thread.sleep(espera); //Espera de 2 seg, meramente visual
                        limpar(); // limpa o console
                        
                    }


                    System.out.println("Login realizado com sucesso!!");
                    Thread.sleep(espera); //Espera de 2 seg, meramente visual

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
                            case "1"-> {

                                System.out.println("Abrindo Notificações...");
                                Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                limpar();

                                verificarNotificacao(marmitas);

                                while (true) {
                                    try {
                                        System.out.println("\nDigite 0 para voltar: ");
                                        escolha = Integer.parseInt(entrada.nextLine());

                                        if (escolha == 0) {
                                            limpar();
                                            System.out.println("voltando...");
                                            Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                            limpar();
                                            break;
                                        } else {
                                            System.out.println("Digite apenas 0 para voltar");
                                        }

                                    } catch (NumberFormatException e) {
                                        System.out.println("Digite apenas 0 para voltar");
                                    }
                                }
                                limpar();

                                }

                            // abre o estoque
                            case "2"-> {

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
                                        case "1"-> {

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
                                                        Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                                        limpar();
                                                        break;
                                                    } else {
                                                        System.out.println("Digite apenas 0 para voltar");
                                                    }

                                                } catch (NumberFormatException e) {
                                                    System.out.println("Digite apenas 0 para voltar");
                                                }
                                            }

                                            }
                                        // alteração de marmitas
                                        case "2"-> {

                                            limpar();
                                            visualizarMarmitas(marmitas);

                                            // mantém executando até informar um indice válido
                                            while (true) {
                                                try {
                                                    System.out.println("\nDigite o cod do item (ou 0 para sair)");
                                                    indice = Integer.parseInt(entrada.nextLine());

                                                    if (indice > marmitas.size() || indice < 0) {
                                                        System.out.println("Indice inválido");
                                                        
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
                                                        
                                                    }
                                                    break;

                                                } catch (NumberFormatException e) {
                                                    System.out.println("Digite um número inteiro");
                                                }
                                            }

                                            updateMarmitas(marmitas, indice - 1, quantidade); // função que atualiza a quantidade da marmita

                                            limpar();
                                            System.out.println("Ação bem sucedida!");
                                            Thread.sleep(espera); //Espera de 2 seg, meramente visual

                                            visualizarMarmitas(marmitas);
                                            Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                            limpar();

                                            }

                                        // encerra o menu do estoque
                                        case "3"-> {
                                            System.out.println("Voltando...");
                                            Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                            limpar();
                                            estoque = false;
                                            }

                                        // opção inválida
                                        default-> {
                                            System.out.println("Opção inválida");
                                            Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                            limpar();
                                        }

                                    }
                                }
                            }

                                
                            // abre pedidos
                            case "3"-> {

                                System.out.println("Abrindo Pedidos...");
                                Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                limpar();

                                visualizarPedidos(pedidos);

                                while (true) {
                                    try {
                                        System.out.println("\nDigite 0 para voltar: ");
                                        escolha = Integer.parseInt(entrada.nextLine());

                                        if (escolha == 0) {
                                            limpar();
                                            System.out.println("voltando...");
                                            Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                            limpar();
                                            break;
                                        } else {
                                            System.out.println("Digite apenas 0 para voltar");
                                        }

                                    } catch (NumberFormatException e) {
                                        System.out.println("Digite apenas 0 para voltar");
                                    }
                                }
                                limpar();

                                }

                            // desativa o menu de funcionario voltando para o fluxo principal
                            case "4"-> {
                                System.out.println("Voltando...");
                                Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                limpar();
                                continuar = false;
                                }

                        }
                    }
                }

                // abre o fluxo de gerente
                case "3"-> {
                    System.out.println("Iniciando como Gerente...");
                    Thread.sleep(espera); //Espera de 2 seg, meramente visual
                    limpar(); // limpa o console

                    // inicia lopping de entrar na conta do gerente
                    while(true){
                        System.out.print("Login: ");
                        login=entrada.nextLine();

                        System.out.print("Senha: ");
                        senha=entrada.nextLine();
                        limpar(); // limpa o console

                        if (login.equals(gerente.login) && senha.equals(gerente.senha)){
                            continuar=true;
                            break;
                        }
                        System.out.println("login Invalido!\nDigite novamente\n");
                        Thread.sleep(espera); //Espera de 2 seg, meramente visual
                        limpar(); // limpa o console
                        
                    }

                    System.out.println("Login realizado com sucesso!!");
                    Thread.sleep(espera); //Espera de 2 seg, meramente visual

                    limpar();
                    // inicia o looping do menu do gerente
                    while (continuar) {

                        limpar();
                        System.out.println("________ Ações ________");
                        System.out.println("\n  1 - Notificação \n  2 - Estoque \n  3 - Pedidos  \n  4 - Gerenciar Funcionarios \n  5 - Encerrar");
                        System.out.println("_______________________");

                        System.out.println("\nQual opção deseja executar?");
                        opcao = entrada.nextLine();
                        limpar();

                        switch (opcao) {
                            // abre notificações
                            case "1"-> {

                                System.out.println("Abrindo Notificações...");
                                Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                limpar();

                                verificarNotificacao(marmitas);

                                while (true) {
                                    try {
                                        System.out.println("\nDigite 0 para voltar: ");
                                        escolha = Integer.parseInt(entrada.nextLine());

                                        if (escolha == 0) {
                                            limpar();
                                            System.out.println("voltando...");
                                            Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                            limpar();
                                            break;
                                        } else {
                                            System.out.println("Digite apenas 0 para voltar");
                                        }

                                    } catch (NumberFormatException e) {
                                        System.out.println("Digite apenas 0 para voltar");
                                    }
                                }
                                limpar();

                                }
                            // abre o menu de estoque
                            case "2"-> {

                                estoque = true;

                                // inicia o looping de se manter no menu de estoque
                                while (estoque) {

                                    limpar();
                                    System.out.println("_____Ações do Estoque_____");
                                    System.out.println("\n  1 - Criar Marmita \n  2 - Remover Marmita \n  3 - Alterar quantidade  \n  4 - Sair");
                                    System.out.println("_________________________");

                                    System.out.println("\nQual opção deseja executar?");
                                    opcaoEstoque = entrada.nextLine();
                                    limpar();
                                    // escolha de opções de estoque
                                    switch (opcaoEstoque) {
                                        // realiza a criação da marmita
                                        case "1"-> {
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
                                                    Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                                    
                                                }
                                                // valida se foi digitado somente letras
                                                if(!nome.matches("[a-zA-ZÀ-ÿ\\s]+")){
                                                    limpar(); // limpa o console
                                                    System.out.println("Por favor utilize somente palavras");
                                                    Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                                    
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
                                                        
                                                    }
                                                    break;
                                                }  catch(NumberFormatException e) {
                                                    System.out.println("Por favor digite um número inteiro");
                                                    
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
                                                        
                                                    }
                                                    break;
                                                } catch(NumberFormatException e) {
                                                    System.out.println("Por favor digite um número");
                                                    
                                                }
                                            }

                                            adicionarMarmitas(marmitas, nome, quantidade, valor);
                                            limpar();
                                            }

                                        // entra no fluxo de remover a marmita
                                        case "2"-> {

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
                                                        
                                                    }
                                                    break;
                                                } catch(NumberFormatException e) {
                                                    System.out.println("Por favor digite um número inteiro");
                                                    
                                                }
                                            }

                                            if(indice == 0){
                                                limpar(); // limpa o console
                                                System.out.println("voltando...");
                                                Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                                limpar(); // limpa o console
                                                break;
                                            }

                                            removerMarmitas(marmitas, indice - 1);

                                            limpar(); // limpa o console

                                            System.out.println("Ação bem sucedida!");
                                            Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                            limpar(); // limpa o console

                                            System.out.println("O estoque se encontra assim:\n");
                                            visualizarMarmitas(marmitas);
                                            Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                            limpar(); // limpa o console

                                            }
                                        // entra no fluxo para alterar a quantidade da marmita
                                        case "3"-> {

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
                                                        
                                                    }
                                                    break;
                                                } catch(NumberFormatException e) {
                                                    System.out.println("Por favor digite um número inteiro");
                                                    
                                                }
                                            }

                                            if(indice == 0){
                                                limpar(); // limpa o console
                                                System.out.println("voltando...");
                                                Thread.sleep(espera); //Espera de 2 seg, meramente visual
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
                                                        
                                                    }
                                                    break;
                                                }  catch(NumberFormatException e) {
                                                    System.out.println("Por favor digite um número inteiro");
                                                    
                                                }
                                            }

                                            updateMarmitas(marmitas, indice - 1, quantidade);

                                            // limpar(); // limpa o console

                                            System.out.println("Ação bem sucedida!");
                                            Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                            // limpar();

                                            System.out.println("O estoque se encontra assim:\n");
                                            visualizarMarmitas(marmitas);
                                            Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                            limpar();

                                            }
                                        // encerra o fluxo do estoque
                                        case "4"-> {
                                            System.out.println("voltando...");
                                            Thread.sleep(espera);
                                            estoque = false;
                                            }
                                        // opção inválida
                                        default-> {
                                            System.out.println("Opção inválida");
                                            Thread.sleep(espera);
                                            limpar();
                                        }
                                    }
                                }
                            }

                                
                            // abre pedidos
                            case "3"-> {

                                System.out.println("Abrindo Pedidos...");
                                Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                limpar();

                                visualizarPedidos(pedidos);

                                while (true) {
                                    try {
                                        System.out.println("\nDigite 0 para voltar: ");
                                        escolha = Integer.parseInt(entrada.nextLine());

                                        if (escolha == 0) {
                                            limpar();
                                            System.out.println("voltando...");
                                            Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                            limpar();
                                            break;
                                        } else {
                                            System.out.println("Digite apenas 0 para voltar");
                                        }

                                    } catch (NumberFormatException e) {
                                        System.out.println("Digite apenas 0 para voltar");
                                    }
                                }
                                limpar();

                                }

                            // abre gerenciamento de funcionarios
                            case "4"-> {

                                gerirFuncionario = true;

                                while (gerirFuncionario){

                                    limpar();

                                    System.out.println("Entrando em Gerenciamento de Funcionarios...");
                                    Thread.sleep(espera);
                                    limpar();

                                    System.out.println("_____ Gerenciamento de Funcionarios _____");
                                    System.out.println("\n  1 - Visualizar Funcionário \n  2 - Adicionar Funcionários \n  3 - Remover Funcionário \n  4 - Voltar");
                                    System.out.println("_________________________________________");

                                    System.out.println("\nQual opção deseja executar?");
                                    opcao = entrada.nextLine();
                                    limpar();

                                    switch(opcao){

                                        case "1"-> {
                                            VisualizarFuncionarios(funcionarios);

                                            while (true) {
                                                try {
                                                    System.out.println("\nDigite 0 para voltar: ");
                                                    escolha = Integer.parseInt(entrada.nextLine());

                                                    if (escolha == 0) {
                                                        limpar();
                                                        System.out.println("voltando...");
                                                        Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                                        limpar();
                                                        break;
                                                    }
                                                    else {
                                                        System.out.println("Digite apenas 0 para voltar");
                                                    }

                                                } catch (NumberFormatException e) {
                                                    System.out.println("Digite apenas 0 para voltar");
                                                }
                                            }

                                            }

                                        case "2"-> {

                                            VisualizarFuncionarios(funcionarios);

                                            System.out.println("\nLogin do novo funcionário:");
                                            login = entrada.nextLine();

                                            System.out.println("\nSenha do novo funcionário:");
                                            senha = entrada.nextLine();

                                            adicionarFuncionario(funcionarios, login, senha);
                                            limpar();

                                            System.out.println("Funcionário cadastrado com sucesso!");
                                            Thread.sleep(espera);
                                            limpar();

                                            VisualizarFuncionarios(funcionarios);
                                            Thread.sleep(espera);
                                            limpar();

                                            }

                                        case "3"-> {

                                            limpar(); // limpa o console
                                            VisualizarFuncionarios(funcionarios);

                                            while(true){
                                                try {
                                                    System.out.println("\nDigite o cod do funcionário que deseja remover: (ou 0 para sair)");
                                                    String i = entrada.nextLine();
                                                    indice = Integer.parseInt(i);
                                                    // verifica se o indice está de acordo com o que existe no projeto
                                                    if (indice > funcionarios.size() || indice < 0){
                                                        System.out.println("Indice inexistente, por favor digite um indice válido");
                                                        
                                                    }
                                                    break;
                                                } catch(NumberFormatException e) {
                                                    System.out.println("Por favor digite um número inteiro");
                                                    
                                                }
                                            }

                                            if(indice == 0){
                                                limpar(); // limpa o console
                                                System.out.println("voltando...");
                                                Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                                limpar(); // limpa o console
                                                break;
                                            }

                                            removerFuncionarios(funcionarios, indice - 1);

                                            limpar(); // limpa o console

                                            System.out.println("Ação bem sucedida!");
                                            Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                            limpar(); // limpa o console

                                            System.out.println("O lista de funcionários se encontra assim:\n");
                                            VisualizarFuncionarios(funcionarios);
                                            Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                            limpar(); // limpa o console
                                            }
                                        case "4"-> {

                                            System.out.println("voltando...");
                                            Thread.sleep(espera);
                                            gerirFuncionario = false;
                                        }
                                    }
                                    
                                }
                            }

                                // desativa o fluxo gerente e volta para o fluxo principal
                            case "5"-> {

                                System.out.println("Voltando...");
                                Thread.sleep(espera);
                                continuar = false;
                                }
                            // opção inválida, pede para informar uma opção válida
                            default-> {
                                System.out.println("Opção inválida, por favor digite uma opção válida");
                                Thread.sleep(espera);
                                limpar();
                                }
                        }
                    }

                }
                // encerra o programa
                case "4"-> {
                    System.out.println("Encerrando...");
                    entrada.close();
                }
            }
        }
    }

    // Função para adicionar marmitas, onde recebe o arraylist, e os atributos da classe marmita
     static void adicionarMarmitas(ArrayList<Marmita> marmitas, String nome, int quantidade, double valor) {
        marmitas.add(new Marmita(nome, quantidade, valor));
    }
    // Função para adicionar cliente, onde recebe o arraylist, e os atributos da classe clientes
     static void adicionarClientes(ArrayList<Cliente>clientes, String login, String senha){
        clientes.add(new Cliente(login, senha));
    }

     static void adicionarFuncionario(ArrayList<Funcionario>funcionario, String login, String senha){
        funcionario.add(new Funcionario( login, senha));
    }

    // Função para o cliente realizar a compra, recebe o arraylist marmita, o indice da marmita escolhida e a quantidade
     static void comprarMarmitas(ArrayList<Marmita> marmitas, int indice, int quantidade) {
        Marmita m = marmitas.get(indice);
        m.quantidade -= quantidade;
    }

    // Função para vizualizar todas as marmitas, recebe o arraylist da marmita
     static void visualizarMarmitas(ArrayList<Marmita> marmitas) {
        int visualizadorMarmitas;
        System.out.println(" Cod |         Sabor         | qtd | Valor ");
        System.out.println("-------------------------------------------");

        for (int i = 0; i < marmitas.size(); i++) {
            Marmita m = marmitas.get(i);
            visualizadorMarmitas = i + 1;
            System.out.printf("  %d  | %s |  %d  | %.2f\n", visualizadorMarmitas, m.nome, m.quantidade, m.valor);
        }
    }

     static void visualizarPedidos(ArrayList<Pedido> pedidos) {

        System.out.println("_____ PEDIDOS _____");

        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido realizado.");
            return;
        }

        for (Pedido p : pedidos) {
            System.out.println("\nPedido: " + p.codigo);
            System.out.println("Produto: " + p.nomeMarmita);
            System.out.println("Quantidade: " + p.quantidade);
            System.out.printf("Valor Total: R$ %.2f\n", p.valorTotal);
            System.out.println("Pagamento: " + p.formaPagamento);
            System.out.println("___________________");
        }
    }
     static void VisualizarFuncionarios(ArrayList<Funcionario>funcionarios){
        int visualizadorFuncionarios;
        System.out.println(" Cod |      Login     | Senha ");
        System.out.println("-----------------------------");

        for (int i = 0; i < funcionarios.size(); i++ ){
            Funcionario f = funcionarios.get(i);
            visualizadorFuncionarios = i + 1;
            System.out.printf("  %d  |  %s  | %s \n",visualizadorFuncionarios, f.login,  f.senha);
        }
    }

    // Função para remover marmitas, recebe o arraylist marmita, o indice da marmita escolhida
     static void removerMarmitas(ArrayList<Marmita> marmitas, int indice) {
        marmitas.remove(indice);
    }

     static void removerFuncionarios(ArrayList<Funcionario> funcionarios, int indice){
        funcionarios.remove(indice);
    }

    // Função para realizar a atualização da quantidade da marmita, recebe o arraylist marmita, o indice da marmita escolhida e a quantidade
     static void updateMarmitas(ArrayList<Marmita> marmitas, int indice, int quantidade) {
        Marmita m = marmitas.get(indice);
        m.quantidade += quantidade;
    }

     static void verificarNotificacao(ArrayList<Marmita>marmitas){
        boolean temNotificacao = false;

        System.out.println("_____ Notificação _____\n");

        System.out.print("");

        for (int i = 0; i < marmitas.size(); i++){
            Marmita m = marmitas.get(i);

            if (m.quantidade < 5){

                System.out.println("Estoque baixo: " + m.nome + " | Quantidade: " + m.quantidade);
                temNotificacao=true;
            }
        }

        if (!temNotificacao){
        System.out.println("Sem notificações.");
    }
    }

    // Função para limpar o console
     static void limpar() {
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

class Pedido {

    int codigo;
    String nomeMarmita;
    int quantidade;
    double valorUnitario;
    double valorTotal;
    String formaPagamento;

    public Pedido(int codigo, String nomeMarmita, int quantidade, double valorUnitario,
                  double valorTotal, String formaPagamento){
        this.codigo = codigo;
        this.nomeMarmita = nomeMarmita;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
    }
}
