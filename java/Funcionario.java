import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Funcionario {
    public static void main(String[] args) {
        Marmita marmita = new Marmita("salada", 10.90);

        ArrayList <Marmita> marmitas = new  ArrayList<Marmita>();
        Scanner entrada = new Scanner(System.in);

        String opcao;
        boolean continuar = true;
        
        marmitas.add(marmita);
 

        adicionarMarmitas(marmitas, "camarão", 10.90);
        adicionarMarmitas(marmitas, "Feijoada", 10.90);

        limpar();
        
        while(continuar){
            System.out.println("---------------------------\n1 - visualizar\n2 - Adicionar\n3 - Atualizar \n4 - Remover\n---------------------------");
            opcao = entrada.nextLine();
            
            switch (opcao) {
                case "1":
                    visualizarMarmitas(marmitas);
                    break;
                case "2":
                    limpar();
                    System.out.println("Digite o nome da marmita: ");
                    String nome = entrada.nextLine();
                    System.out.println("Digite o valor da marmita: ");
                    double valor = entrada.nextDouble();
                    entrada.nextLine();
                    adicionarMarmitas(marmitas, nome, valor);
                    limpar();
                    break;
                case "3":
                    System.out.println("coming soon...");
                    break;
                case "4":
                    limpar();
                    visualizarMarmitasInterno(marmitas);
                    System.out.println("Digite o indice que deseja remover: ");
                    int indice = entrada.nextInt();
                    entrada.nextLine();
                    removerMarmitas(marmitas, indice-1);
                    break;
                default:
                    System.out.println("Encerrando");
                    continuar = false;
                    break;
            }
        }

        entrada.close();
    }

    public static void adicionarMarmitas(ArrayList<Marmita> marmitas, String nome, double valor){
        marmitas.add(new Marmita(nome, valor));
    }

    public static void visualizarMarmitas(ArrayList<Marmita> marmitas){
        for(Marmita m : marmitas){
            System.out.printf("Nome: %s Preço: %.2f\n", m.nome, m.valor);
        }
    }

    public static void visualizarMarmitasInterno(ArrayList<Marmita> marmitas){
        int visualizador;
        for(int i = 0; i < marmitas.size(); i++){
            Marmita m = marmitas.get(i);
            visualizador = i+1;
            System.out.printf("%d - Nome: %s Preço: %.2f\n", visualizador, m.nome, m.valor);
        }
    }

    public static void removerMarmitas(ArrayList<Marmita> marmitas, int indice){
        marmitas.remove(indice);
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
