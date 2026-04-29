import java.io.IOException;
import java.util.ArrayList;

public class Funcionario {
    public static void main(String[] args) {
        Marmita marmita = new Marmita("salada", 10.90);

        ArrayList <Marmita> marmitas = new  ArrayList<Marmita>();
        
        marmitas.add(marmita);
 

        adicionar(marmitas, "camarão", 10.90);
        adicionar(marmitas, "Feijoada", 10.90);
        
        while(true){

            
        }
    }

    public static void adicionar(ArrayList<Marmita> marmitas, String nome, double valor){
        marmitas.add(new Marmita(nome, valor));
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
