import java.time.Duration;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class funcionario {
    public static void main(String[] args) throws InterruptedException {


        Duration espera = Duration.ofSeconds(3);

        Marmita marmita = new Marmita("Frango com Arroz    ", 15, 18.90);

        ArrayList<Marmita> marmitas = new ArrayList<Marmita>();
        Scanner entrada = new Scanner(System.in);

        String opcao, login, senha;
        int indice;
        boolean continuar = false;

        marmitas.add(marmita);

        adicionarMarmitas(marmitas, "Carne Moída com Purê", 12, 19.90);
        adicionarMarmitas(marmitas, "Macarrão à Bolonhesa", 10, 17.50);
        adicionarMarmitas(marmitas, "Strogonoff de Frango", 14, 21.00);
        adicionarMarmitas(marmitas, "Arroz Carreteiro    ", 16, 21.50);

        limpar();

        System.out.println("Iniciando como Gerente...");
        Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
        limpar();

        System.out.print("Login: "); login=entrada.next();
        System.out.print("Senha: "); senha=entrada.next();
        limpar();
        if (login.equals("1") && senha.equals("1")){
        continuar=true;

        System.out.println("Login realizado com sucesso!!");
        Thread.sleep(2000);
        
        limpar();

        }else{
            System.out.println("login Invalido!\nDigite novamente\n");
            Thread.sleep(2000);
            limpar();
        }

        while (continuar) {

            System.out.println("________ Ações ________");
            System.out.println("\n  1 - Criar Marmita \n  2 - Remover Marmita \n  3 - Alterar quantidade  \n  4 - Sair");
            System.out.println("_______________________");

            System.out.println("\nQual opção deseja executar?");
            opcao = entrada.nextLine();

            switch (opcao) {

                case "1":

                    limpar();
                    visualizarMarmitas(marmitas);
                    System.out.println("\nDigite o nome da marmita: ");
                    String nome = entrada.nextLine();

                    System.out.println("\nDigite a quantidade deste sabor: ");
                    int quantidade = entrada.nextInt();

                    System.out.println("\nDigite o valor da marmita: ");
                    double valor = entrada.nextDouble();
                    entrada.nextLine();

                    adicionarMarmitas(marmitas, nome, quantidade, valor);
                    limpar();
                    break;

                case "2":

                    limpar();
                    visualizarMarmitas(marmitas);

                    System.out.println("\nDigite o cod do item que deseja remover: ");
                    indice = entrada.nextInt();
                    entrada.nextLine();

                    removerMarmitas(marmitas, indice - 1);

                    limpar();

                    System.out.println("Ação bem sucedida!");
                    Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
                    limpar();

                    System.out.println("O estoque se encontra assim:\n");
                    visualizarMarmitas(marmitas);
                    Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
                    limpar();

                    break;

                case "3":
                   
                    limpar();
                    visualizarMarmitas(marmitas);

                    System.out.println("\nDigite o cod do item que deseja alterar ");
                    indice = entrada.nextInt();
                    entrada.nextLine();

                    System.out.println("\nDigite a quantidade adiconar ex: (+10) / (-10)");
                    quantidade = entrada.nextInt();
                    entrada.nextLine();

                    updateMarmitas(marmitas, indice - 1, quantidade);

                    limpar();

                    System.out.println("Ação bem sucedida!");
                    Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
                    limpar();

                    System.out.println("O estoque se encontra assim:\n");
                    visualizarMarmitas(marmitas);
                    Thread.sleep(espera.toMillis()); //Espera de 2 seg, meramente visual
                    limpar();

                    break;

                case "5":

                    System.out.println("Encoutando...");
                    Thread.sleep(espera.toMillis());
                    continuar = false;
                    break;
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
