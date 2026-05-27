//Projeto Integrador: Gerenciamento de Estoque
//Versсo java 21.0
//Grupo: Ariel Isidro Nina Saavedra, Bruno Geanini dos Reis, Gabriel Tolcsvai de Cronis, Heloísa Weiss Willwohl Sanches, Mariane Santana da Silva, Miguel Augusto de Oliveira Santos

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

public class FluxoCliente {
    public static void main(String[] args) throws InterruptedException {

        Duration espera = Duration.ofSeconds(2);

        ArrayList<Cliente> clientes = new ArrayList<>(); // Instancia um objeto Cliente do tipo ArrayList, para utilizar vetor de forma dinamica
        ArrayList<Marmita> marmitas = new ArrayList<>(); // Instancia um objeto do tipo ArrayList, para utilizar vetor de forma dinamica
        ArrayList<Pedido> pedidos = new ArrayList<>();
        Scanner entrada = new Scanner(System.in); // Instancia um objeto Scanner

        // Definições variaveis globais
        String usuario, opcao, login, senha, nomeCompleto;
        int indice, quantidade;
        boolean autenticacao, sistemaCliente , menuCliente=false;

        // adiciona os valores ao array marmitas
        adicionarMarmitas(marmitas, "Frango com Arroz    ", 15, 18.90);
        adicionarMarmitas(marmitas, "Carne Moída com Purê", 4 , 19.90);
        adicionarMarmitas(marmitas, "Macarrão à Bolonhesa", 10, 17.50);
        adicionarMarmitas(marmitas, "Strogonoff de Frango", 14, 21.00);
        adicionarMarmitas(marmitas, "Arroz Carreteiro    ", 16, 21.50);
        limpar(); // limpa o console

        // adiciona os valores ao array clientes
        adicionarClientes(clientes, "cliente1@gmail.com", "1234567c", "Fulano");
        adicionarClientes(clientes, "cliente2@gmail.com", "8765432c","Beutrano");
        limpar(); // limpa o console


        System.out.println("Iniciando Sistema ...");
        Thread.sleep(espera); //Espera de 2 seg, meramente visual
        limpar(); // limpa o console

        while (true) {

            limpar();
            // Menu principal
            System.out.println("________ Entrar com: ________");
            System.out.println("\n  1 - Cliente \n  2 - Encerrar");
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
                            System.out.println("Deseja realizar o login? \n \n 1 - Sim\n 2 - Não \n 3 - Cadastrar \n 4 - Sair");
                            System.out.println("\nInforme opção que deseja executar: ");
                            String realizarLogin = entrada.nextLine();
                            limpar();

                            // verifica se o  usuario não deseja fazer login
                            if(realizarLogin.equals("2")){
                                menuCliente = true; // ativa a condição para iniciar o menu
                                break;
                            }
                            else if(realizarLogin.equals("3")){

                                System.out.println("_____ Cadastro Novo _____");

                                while (true) {
                                    System.out.println("\nDigite o seu Email:(ou 0 para sair)");
                                    login = entrada.nextLine();

                                    if (login.equals("0")) {
                                        limpar(); // limpa o console
                                        break;
                                    }

                                    if(!verificarEmail(login)){
                                        limpar(); // limpa o console
                                        System.out.println("por favor utilize um email válido!");
                                        Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                        limpar();
                                        continue;
                                    }

                                    if(cadastroExistente(clientes, login)){
                                        limpar();
                                        System.out.println("Este email já está cadastrado!");
                                        Thread.sleep(espera);
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

                                if (login.equals("0")) {
                                    System.out.println("Voltando...");
                                    Thread.sleep(espera); //Espera de 2 seg, meramente visual
                                    limpar(); // limpa o console
                                    continue;
                                }



                                adicionarClientes(clientes, login, senha, nomeCompleto);
                                limpar();

                                System.out.println("Cliente cadastrado com sucesso!");
                                Thread.sleep(espera);
                                limpar();

                            }
                            // caso digite 0, encerra o looping de login
                            else if (realizarLogin.equals("4")) {
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
                                    limpar();
                                    Thread.sleep(espera);
                                    System.out.println("Bem vindo, " + cliente.nomeCompleto + "!");
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
                                                System.out.println("Indice inexistente, por fa2vor digite um indice válido");
                                                continue;  
                                            }
                                            if (marmitas.get(indice).quantidade==0){
                                                System.out.println("Produto sem estoque");
                                                continue;
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

                                            if(quantidade == 0){
                                                break;
                                            }

                                            if(quantidade < 0){
                                                System.out.println("Digite uma quantidade maior que 0");
                                                continue;
                                            }

                                            else if(marmitas.get(indice).quantidade - quantidade < 0){
                                                limpar();
                                                System.out.println("quantidade insuficiente em estoque");
                                                Thread.sleep(espera);
                                                limpar();
                                                continue;
                                            }

                                            break;

                                        } catch(NumberFormatException e) {
                                            System.out.println("Por favor digite um número inteiro");
                                        }
                                    }

                                    if(quantidade == 0){
                                        limpar();
                                        System.out.println("Voltando...");
                                        Thread.sleep(espera);
                                        break;
                                    }

                                    double total = marmitas.get(indice).valor * quantidade;

                                    limpar();
                                    System.out.printf("\nTotal da compra: R$ %.2f\n", total);

                                    System.out.println("\n_____ PAGAMENTO _____\n \n 1 - Pix \n 2 - Cartão \n 3 - Dinheiro \n 4 - Cancelar compra");
                                    System.out.println("_______________________");

                                    System.out.println("Selecione a opção a qual deseja pagar: ");
                                    String formaPagamento = entrada.nextLine();

                                    limpar();
                                    boolean pagamentoCancelado = false;
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
                                            System.out.println("Cancelando Pagamento....");
                                            Thread.sleep(espera);
                                            System.out.println("Pagamento cancelado!!");
                                            Thread.sleep(espera);
                                            limpar();

                                            pagamentoCancelado = true;
                                        }

                                        default -> {
                                            System.out.println("\nForma de pagamento inválida.");
                                        }
                                    }

                                    if (pagamentoCancelado) {
                                        break;
                                    }

                                    System.out.println("\n_____ PAGAMENTO _____");
                                    System.out.println("Forma: " + formaPagamento);
                                    System.out.printf("Valor: R$ %.2f\n", total);
                                    Thread.sleep(espera);
                                    limpar();

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
                                    System.out.println("_________________________");

                                    Thread.sleep(espera);
                                    Thread.sleep(espera);
                                    
                                    
                                    }
                                //desativa o menu cliente encerrando o fluxo de menu
                                case "2"-> {
                                    menuCliente = false;
                                    limpar();
                                    System.out.println("Voltando...");
                                    Thread.sleep(espera);
                                    limpar();
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
    ArrayList<Cliente> clientes,
    String login
    ){

        // verifica clientes
        for(Cliente c : clientes){
            if(c.login.equalsIgnoreCase(login)){
                return true;
            }
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
    // Função para adicionar cliente, onde recebe o arraylist, e os atributos da classe clientes
     static void adicionarClientes(ArrayList<Cliente>clientes, String login, String senha, String nomeCompleto){
        clientes.add(new Cliente(login, senha, nomeCompleto));
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

//Cria a classe cliente
class Cliente {
    //Atributos
    String login;
    String senha;
    String nomeCompleto;

    // construtor
    public Cliente(String login, String senha, String nomeCompleto){
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
