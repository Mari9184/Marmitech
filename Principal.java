import java.lang.NumberFormatException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        int confirmarCpf = 0;
        int[] navigation = new int[5];
        String cpf;

        while(true){
            do {
                try {
                    System.out.println("Deseja digitar o cpf?\n1 - Sim\n2 - Não");
                    String input = entrada.nextLine();
                    confirmarCpf = Integer.parseInt(input);
                } catch(NumberFormatException e) {
                    System.out.println("Por favor digite 1 ou 2");
                    confirmarCpf = 0;
                    continue;
                }
    
                if(confirmarCpf == 1 || confirmarCpf == 2){
                    break;
                }
            } while(true);
    
    
            if(confirmarCpf == 1){
                try{
                    System.out.println("Digite o cpf:");
                    cpf = entrada.nextLine();

                    if(cpf.contains(".") || cpf.contains("-")){
                        cpf = cpf.replaceAll("\\D", "");
                    }

                    if (cpf.equals("00000000000") ||
                        cpf.equals("11111111111") ||
                        cpf.equals("22222222222") || cpf.equals("33333333333") ||
                        cpf.equals("44444444444") || cpf.equals("55555555555") ||
                        cpf.equals("66666666666") || cpf.equals("77777777777") ||
                        cpf.equals("88888888888") || cpf.equals("99999999999") ||
                        (cpf.length() != 11)){
                            System.out.println("CPF inválido");
                            continue;
                        }
                    char dig10, dig11;
                    int sm, i, r, num, peso;

                    // Calculo do 1o. Digito Verificador
                    sm = 0;
                    peso = 10;
                    for (i=0; i<9; i++) {
                    // converte o i-esimo caractere do CPF em um numero:
                    // por exemplo, transforma o caractere "0" no inteiro 0
                    // (48 eh a posicao de "0" na tabela ASCII)
                    num = (int)(cpf.charAt(i) - 48);
                    sm = sm + (num * peso);
                    peso = peso - 1;
                    }

                    r = 11 - (sm % 11);
                    if ((r == 10) || (r == 11))
                        dig10 = '0';
                    else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

                        // Calculo do 2o. Digito Verificador
                    sm = 0;
                    peso = 11;
                    for(i=0; i<10; i++) {
                    num = (int)(cpf.charAt(i) - 48);
                    sm = sm + (num * peso);
                    peso = peso - 1;
                    }

                    r = 11 - (sm % 11);
                    if ((r == 10) || (r == 11))
                        dig11 = '0';
                    else dig11 = (char)(r + 48);

                    // Verifica se os digitos calculados conferem com os digitos informados.
                    if ((dig10 != cpf.charAt(9)) || (dig11 != cpf.charAt(10))){
                        System.out.println("Cpf Inválido");
                        continue;
                    } 
                    System.out.println("cpf válido");
                } catch(Exception e){
                        System.out.println("Valor inválido:");
                        continue;
            } 
            } else {
                System.out.println("aaa");
        } 
    }
    
    }
}

