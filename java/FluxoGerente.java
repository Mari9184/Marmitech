import java.time.Duration;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FluxoGerente {
    public static void main(String[] args) throws InterruptedException {


        Duration espera = Duration.ofSeconds(3);

        Gerente gerente = new Gerente("gerente3", "gerente3"); //Instancia o objeto gerente, atribuindo valores aos parametros.


        ArrayList<Marmita> marmitas = new ArrayList<Marmita>(); // Instancia um objeto do tipo ArrayList, para utilizar vetor de forma dinamica
        Scanner entrada = new Scanner(System.in); // Instancia um objeto Scanner

        // Definições variaveis globais
        String opcao, login, senha, nome;
        double valor;
        int indice, quantidade;
        boolean continuar = false;

        // adiciona os valores ao array marmitas
        adicionarMarmitas(marmitas, "Frango com Arroz    ", 15, 18.90);
        adicionarMarmitas(marmitas, "Carne Moída com Purê", 12, 19.90);
        adicionarMarmitas(marmitas, "Macarrão à Bolonhesa", 10, 17.50);
        adicionarMarmitas(marmitas, "Strogonoff de Frango", 14, 21.00);
        adicionarMarmitas(marmitas, "Arroz Carreteiro    ", 16, 21.50);
        limpar(); // limpa o console

        System.out.println("Iniciando como Gerente...");
        Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
        limpar(); // limpa o console

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
            Thread.sleep(2000);
            limpar(); // limpa o console
            continue;
        }


        System.out.println("Login realizado com sucesso!!");
        Thread.sleep(2000);
        
        limpar();

        while (continuar) {

            System.out.println("________ Ações ________");
            System.out.println("\n  1 - Criar Marmita \n  2 - Remover Marmita \n  3 - Alterar quantidade  \n  4 - Sair");
            System.out.println("_______________________");

            System.out.println("\nQual opção deseja executar?");
            opcao = entrada.nextLine();

            switch (opcao) {

                case "1": 
                    // mantém o loop até digitar um valor válido
                    while (true) {     
                        limpar(); // limpa o console
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

                case "4":
                    System.out.println("Encerrando...");
                    Thread.sleep(espera.toMillis());
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida, por favor digite uma opção válida");
                    Thread.sleep(espera.toMillis());
                    limpar();
            }
        }

        entrada.close();
    }

    public static void adicionarMarmitas(ArrayList<Marmita> marmitas, String nome, int quantidade, double valor) {
        marmitas.add(new Marmita(nome, quantidade, valor));
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

// Cria a classe Gerente 
class Gerente {
    //Atributos
    String login; 
    String senha;

    public Gerente(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
}
