//Projeto Integrador: Gerenciamento de Estoque
//Versсo java 21.0
//Grupo: Ariel Isidro Nina Saavedra, Bruno Geanini dos Reis, Gabriel Tolcsvai de Cronis, Heloísa Weiss Willwohl Sanches, Mariane Santana da Silva, Miguel Augusto de Oliveira Santos

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

public class FluxoFuncionario {
    public static void main(String[] args) throws InterruptedException {

        Duration espera = Duration.ofSeconds(2);

        ArrayList<Marmita> marmitas = new ArrayList<>(); // Instancia um objeto do tipo ArrayList, para utilizar vetor de forma dinamica
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        Scanner entrada = new Scanner(System.in); // Instancia um objeto Scanner

        // Definições variaveis globais
        String usuario, opcao, opcaoEstoque, login, senha;
        int indice, quantidade, escolha;
        boolean continuar = false, estoque;

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

        pedidos.add( new Pedido(1,"Frango com Arroz",2,18.90,37.80,"Pix"));

        System.out.println("Iniciando Sistema ...");
        Thread.sleep(espera); //Espera de 2 seg, meramente visual
        limpar(); // limpa o console

        while (true) {

            limpar();
            // Menu principal
            System.out.println("________ Entrar com: ________");
            System.out.println("\n  1 - Funcionário \n  2 - Encerrar");
            System.out.println("______________________________");
            System.out.println("\nCom qual opção deseja executar?");
            usuario = entrada.nextLine();
            limpar();

            // escolha do menu principal
            switch(usuario){
                // entra no fluxo do funcionário
                case "1"-> {
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
                                
                                System.out.println("Bem vindo, " + funcionario.nomeCompleto + "!");
                                Thread.sleep(espera);
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

                                                    if (indice > marmitas.size() || indice <= 0) {
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
    // Função para adicionar cliente, onde recebe o arraylist, e os atributo

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
            System.out.printf("Valor Unitário: R$ %.2f\n", p.valorUnitario);
            System.out.printf("Valor Total: R$ %.2f\n", p.valorTotal);
            System.out.println("Pagamento: " + p.formaPagamento);
            System.out.println("___________________");
        }
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
