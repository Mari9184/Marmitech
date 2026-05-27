//Projeto Integrador: Gerenciamento de Estoque
//Versсo java 21.0
//Grupo: Ariel Isidro Nina Saavedra, Bruno Geanini dos Reis, Gabriel Tolcsvai de Cronis, Heloísa Weiss Willwohl Sanches, Mariane Santana da Silva, Miguel Augusto de Oliveira Santos

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

public class FluxoGerente {
    public static void main(String[] args) throws InterruptedException {

        Duration espera = Duration.ofSeconds(2);

        Gerente gerente = new Gerente("gerente@gmail.com", "gerente3", "Maria Dolores"); //Instancia o objeto gerente, atribuindo valores aos parametros.
        ArrayList<Marmita> marmitas = new ArrayList<>(); // Instancia um objeto do tipo ArrayList, para utilizar vetor de forma dinamica
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        Scanner entrada = new Scanner(System.in); // Instancia um objeto Scanner

        // Definições variaveis globais
        String usuario, opcao, opcaoEstoque, login, senha, nomeCompleto, nome;
        double valor;
        int indice, quantidade, escolha;
        boolean continuar = false, estoque, gerirFuncionario;

        // adiciona os valores ao array marmitas
        adicionarMarmitas(marmitas, "Frango com Arroz    ", 15, 18.90);
        adicionarMarmitas(marmitas, "Carne Moída com Purê", 4 , 19.90);
        adicionarMarmitas(marmitas, "Macarrão à Bolonhesa", 10, 17.50);
        adicionarMarmitas(marmitas, "Strogonoff de Frango", 14, 21.00);
        adicionarMarmitas(marmitas, "Arroz Carreteiro    ", 16, 21.50);
        limpar(); // limpa o console

        // adicionando Funcionarios ao array funcionarios

        adicionarFuncionario(funcionarios, "Funcionario1@gmail.com", "1234567f","Julia Child  ");
        adicionarFuncionario(funcionarios, "Funcionario2@gmail.com", "7654321f", "Érick Jacquin");
        limpar();

        System.out.println("Iniciando Sistema ...");
        Thread.sleep(espera); //Espera de 2 seg, meramente visual
        limpar(); // limpa o console

        while (true) {

            limpar();
            // Menu principal
            System.out.println("________ Entrar com: ________");
            System.out.println("\n  1 - Gerente \n  2 - Encerrar");
            System.out.println("______________________________");
            System.out.println("\nCom qual opção deseja executar?");
            usuario = entrada.nextLine();
            limpar();

            // escolha do menu principal
            switch(usuario){

                case "1"-> {
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
                    System.out.println("Bem vindo, " + gerente.nomeCompleto + "!");
                    Thread.sleep(espera);

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
                                                    continue;
                                                }
                                                // valida se foi digitado somente letras
                                                if(!nome.matches("[a-zA-ZÀ-ÿ\\s]+")){
                                                    limpar(); // limpa o console
                                                    System.out.println("Por favor utilize somente palavras");
                                                    Thread.sleep(espera); //Espera de 2 seg, meramente visual
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
                                                    if(quantidade <= 0){
                                                    System.out.println("Digite uma quantidade maior que 0");
                                                    continue;
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
                                                    valor = Double.parseDouble(entrada.nextLine());
                                                    if(valor<0){
                                                        System.out.println("Digite somente valores positivos, se for um brinde, utilize 0");
                                                        continue;
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
                                                    if (indice > marmitas.size() || indice <= 0){
                                                        System.out.println("Indice inexistente, por favor digite um indice válido");
                                                        continue;
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
                                                        continue;
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

                                            while (true) {
                                                System.out.println("\nDigite o seu Email:(ou 0 para sair)");
                                                login = entrada.nextLine();

                                                if (login.equals("0")) {
                                                    limpar(); // limpa o console
                                                    break;
                                                }

                                                if(!verificarEmail(login)){
                                                    limpar(); // limpa o console
                                                    System.out.println("por favor utilize um email válido");
                                                    Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                                    continue;
                                                }

                                                if(cadastroExistente(funcionarios, gerente, login)){
                                                    limpar();
                                                    System.out.println("Este email já está cadastrado!");
                                                    Thread.sleep(espera);
                                                    limpar();
                                                    continue;
                                                }
                                                break;
                                            }

                                            if (login.equals("0")) {
                                                System.out.println("Voltando...");
                                                Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                                limpar(); // limpa o console
                                                continue;
                                            }

                                            // loop para validar a senha, caso digite 0 para sair, quebra o loop e volta para a tela de login
                                            while(true){
                                                System.out.println("\nDigite a sua Senha:(ou 0 para sair)");
                                                senha = entrada.nextLine();

                                                if (senha.equals("0")) {
                                                    limpar(); // limpa o console
                                                    break;
                                                }

                                                if(!verificarTamanhoSenha(senha)){
                                                    limpar(); // limpa o console
                                                    System.out.println("A senha deve ter pelo menos 8 caracteres, contendo letras e números");
                                                    Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                                    continue;
                                                }
                                                break;
                                            }
                                            if (login.equals("0")) {
                                                System.out.println("Voltando...");
                                                Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                                limpar(); // limpa o console
                                                continue;
                                            }
                                                
                                            // loop para validar o nome completo, caso digite 0 para sair, quebra o loop e volta para a tela de login
                                            while(true){
                                                System.out.println("\nDigite o seu nome completo:(ou 0 para sair)");
                                                nomeCompleto = entrada.nextLine();

                                                if (nomeCompleto.equals("0")) {
                                                    limpar(); // limpa o console
                                                    break;
                                                }
                                                if(!verificarTexto(nomeCompleto)){
                                                    limpar(); // limpa o console
                                                    System.out.println("Por favor utilize um nome válido, Somente letras e espaços");
                                                    Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                                    continue;
                                                }
                                                break;
                                            }

                                            adicionarFuncionario(funcionarios, login, senha, nomeCompleto);

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
                                                    if (indice > funcionarios.size() || indice <= 0){
                                                        System.out.println("Indice inexistente, por favor digite um indice válido");
                                                        continue;
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
                case "2"-> {
                    System.out.println("Encerrando...");
                    entrada.close();
                    System.exit(0);
                }
            }
        }
    }

     static boolean verificarString(String texto){

        if(texto == null || texto.isBlank()){
            return false;
        }

        try {
            return Double.parseDouble(texto) >= 0 || Double.parseDouble(texto) < 0;
        }catch (NumberFormatException e) {
            return true;
        }
    }

     static boolean verificarTexto(String texto){
        boolean verificacao = true;
        if(!verificarString(texto)){
            verificacao = false;
            return verificacao;
        }
        if(!texto.matches("[a-zA-ZÀ-ÿ\\s]+")){
            verificacao = false;
        }
        return verificacao;
    }

     static boolean verificarTamanhoSenha(String senha){
        boolean verificacao = true;
        if(!verificarString(senha)){
            verificacao = false;
            return verificacao;
        }
        if(senha.length() < 8){
            verificacao = false;
        }
        return verificacao;
    }

    static boolean cadastroExistente(
    ArrayList<Funcionario> funcionarios,
    Gerente gerente,
    String login
    ){


        // verifica funcionarios
        for(Funcionario f : funcionarios){
            if(f.login.equalsIgnoreCase(login)){
                return true;
            }
        }

        // verifica gerente
        if(gerente.login.equalsIgnoreCase(login)){
            return true;
        }

        return false;
    }

    public static boolean verificarEmail(String login){
        boolean emailValido = true;
        if(!verificarString(login)){
            emailValido = false;
            return emailValido;
        }
        // Expressão para validar o formato do email.
        // ^ - Início da string
        // [A-Za-z0-9+_.-]+ - Um ou mais caracteres ou símbolos permitidos antes do @
        // @ - O símbolo @
        // [A-Za-z0-9.-]+ - Um ou mais caracteres ou símbolos permitidos para o domínio
        // \. - O símbolo de ponto (.) antes do final
        // [A-Za-z]{2,} - o final deve conter pelo menos 2 caracteres, como br, com, etc.
        // $ - Fim da string
        String regexEmail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (!login.matches(regexEmail)) {
            emailValido = false;
        }
        return emailValido;
    }

    // Função para adicionar marmitas, onde recebe o arraylist, e os atributos da classe marmita
     static void adicionarMarmitas(ArrayList<Marmita> marmitas, String nome, int quantidade, double valor) {
        marmitas.add(new Marmita(nome, quantidade, valor));
    }

    static void adicionarFuncionario(ArrayList<Funcionario>funcionario, String login, String senha, String nomeCompleto){
        funcionario.add(new Funcionario( login, senha, nomeCompleto));
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
        System.out.println(" Cod |          Nome          |      Login     | Senha ");
        System.out.println("-----------------------------");

        for (int i = 0; i < funcionarios.size(); i++ ){
            Funcionario f = funcionarios.get(i);
            visualizadorFuncionarios = i + 1;
            System.out.printf("  %d  |   %s   |  %s  | %s \n", visualizadorFuncionarios, f.nomeCompleto, f.login, f.senha);        }
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
    String nomeCompleto;


    // construtor
    public Funcionario(String login, String senha, String nomeCompleto){
        this.login = login;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
    }
}

// Cria a classe Gerente
class Gerente {
    String login;
    String senha;
    String nomeCompleto;


    // construtor
    public Gerente(String login, String senha, String nomeCompleto){
    this.login = login;
    this.senha = senha;
    this.nomeCompleto = nomeCompleto;
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
