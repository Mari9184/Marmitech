import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Funcionario {
    public static void main(String[] args) {
        Marmita marmita = new Marmita("salada", 10.90);

        ArrayList <Marmita> marmitas = new  ArrayList<Marmita>();
        Scanner entrada = new Scanner(System.in);

        String opcao;
        
        marmitas.add(marmita);
 

        adicionar(marmitas, "camarão", 10.90);
        adicionar(marmitas, "Feijoada", 10.90);

        limpar();
        
        while(true){
            System.out.println("---------------------------\n1 - visualizar\n2 - Adicionar\n3 - Atualizar \n4 - Remover\n---------------------------");
            opcao = entrada.nextLine();
            
            switch (opcao) {
                case "1":
                    visualizar(marmitas);
                    break;
                case "2":
                    System.out.println("Digite o nome da marmita: ");
                    String nome = entrada.nextLine();
                    System.out.println("Digite o valor da marmita: ");
                    double valor = entrada.nextDouble();
                    adicionar(marmitas, nome, valor);
                default:
                    break;
            }
        }
    }

    public static void adicionar(ArrayList<Marmita> marmitas, String nome, double valor){
        marmitas.add(new Marmita(nome, valor));
    }

    public static void visualizar(ArrayList<Marmita> marmitas){
        for(Marmita m : marmitas){
            System.out.printf("Nome: %s Preço: %.2f\n", m.nome, m.valor);
        }
    }

    public static void limpar(){
         try {
            if (System.getProperty("os.name").contains("Windows")) {
                // Para Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Para Linux e MacOS
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao limpar o terminal: " + e.getMessage());
        }
    }
}

class Marmita{
    String nome;
    double valor;

    public Marmita(String nome, double valor){
        this.nome = nome;
        this.valor = valor;
    }
}
