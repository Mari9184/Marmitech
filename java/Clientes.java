import java.io.IOException;
import java.lang.ProcessBuilder;
import java.util.ArrayList;
import java.util.Scanner;
public class NewProject{
    public static void limpar(){
        try{
            new ProcessBuilder("cmd","/c", "cls").inheritIO().start().waitFor();
        }catch(Exception e){
            System.out.println("Erro ao limpar o terminal: " + e.getMessage());
        }
    }
    public static void main(String[]args)throws InterruptedException{
        Scanner e=new Scanner(System.in);
        
        String cliente,senha;
        boolean login=false;
        boolean sistema=true;
        boolean valido;
        boolean compra;
        int opcao, quantidade, item;
        
        ArrayList<Integer> arrayCodMarmita=new ArrayList<Integer>();
        arrayCodMarmita.add(001);
        arrayCodMarmita.add(002);
        arrayCodMarmita.add(003);
        arrayCodMarmita.add(004);
        arrayCodMarmita.add(005);
        
        ArrayList<String> arrayNomeMarmita=new ArrayList<String>();
        arrayNomeMarmita.add("Frango com Arroz");
        arrayNomeMarmita.add("Carne Moída com Purê");
        arrayNomeMarmita.add("Macarrão à Bolonhesa");
        arrayNomeMarmita.add("Strogonoff de Frango");
        arrayNomeMarmita.add("Arroz Carreteiro");
        
        ArrayList<Integer> arrayQuantidade=new ArrayList<Integer>();
        arrayQuantidade.add(15);
        arrayQuantidade.add(12);
        arrayQuantidade.add(10);
        arrayQuantidade.add(14);
        arrayQuantidade.add(16);
        
        ArrayList<Double> arrayValorMarmita=new ArrayList<Double>();
        arrayValorMarmita.add(18.90);
        arrayValorMarmita.add(19.90);
        arrayValorMarmita.add(17.50);
        arrayValorMarmita.add(21.00);
        arrayValorMarmita.add(19.50);
        
        System.out.println("entrando como cliente...");
        try{
            Thread.sleep(2000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        
        do {
            System.out.println("_________Cliente__________");
            System.out.println("deseja se identificar?");
            System.out.println("1-Nâo \n2-Sim");
            System.out.print("Opção:");opcao=e.nextInt();
            limpar();
            
            switch(opcao){
                case 1:
                    System.out.println("Continuando para sistema de compra...");
                    login=true;
                    limpar();
                    break;
                case 2:
                    while(!login){
                        System.out.print("Login: "); cliente=e.next();
                        System.out.print("Senha: "); senha=e.next();
                        limpar();
                        if (cliente.equals("1") && senha.equals("1")){
                            login=true;
                            System.out.println("Login realizado com sucesso!!");
                            Thread.sleep(2000);
                            limpar();
                        }else{
                            System.out.println("login Invalido!\nDigite novamente\n");
                            Thread.sleep(2000);
                            limpar();
                        }
                    }
                    break;    
                default:
                    limpar();
                    System.out.println("Opção Invalida");
                    Thread.sleep(2000);
                    limpar();
                    break;
            }
        }while(!login);
        while(sistema){
            System.out.println("______________!!!Marmitas!!!______________");
            System.out.println("\n");
            for(int posicao=0;posicao<5;posicao++){
                System.out.println(
                    arrayCodMarmita.get(posicao) + "|"+
                    arrayNomeMarmita.get(posicao) + "|"+ 
                    arrayQuantidade.get(posicao) + "|"+
                    arrayValorMarmita.get(posicao)
                );
            }
            System.out.println("_____________________________");
            System.out.println("Deseja comprar?");
            System.out.println("1 - Sim\n2 - Não");
            System.out.print("Opção: "); opcao=e.nextInt();
            
            switch(opcao){
                case 1:
                    do{
                        System.out.println("Digite o código da marmita desejada ou digite '0' para voltar: ");item=e.nextInt();
                        valido=false;
                        for(int posicao=0;posicao<5;posicao++){
                            if(arrayCodMarmita.get(posicao)==item){
                                valido=true;
                                System.out.println("Item - "+arrayNomeMarmita.get(posicao)+"\n");
                                compra=false;
                                do{
                                    System.out.println("Informea a quantidade que deseja comprarou digite '0' para voltar: ");quantidade=e.nextInt();
                                    if (quantidade<=arrayQuantidade.get(posicao) && quantidade>0){
                                        arrayQuantidade.set(posicao, arrayQuantidade.get(posicao)-quantidade);//nao sei se fiz certo//
                                        
                                        System.out.println("Item comprado com sucesso!");
                                        Thread.sleep(2000);
                                        limpar();
                                        compra=true;
                                        break;
                                    }else if(quantidade==0){
                                        System.out.println("Retornando...");
                                        compra=true;
                                    }else{
                                        System.out.println("Quantidade em estoque insuficiente");
                                    }                                    
                                }while(!compra);
                                
                            }
                        }
                        if (item==0){
                            System.out.println("Retornando...");
                            valido=true;
                            Thread.sleep(2000);
                            limpar();
                            
                        }
                    
                        if(!valido){
                            System.out.println("Código de item não encontrado!");
                        }
                    }while(!valido);
                    break;
                case 2: 
                    limpar();
                    System.out.println("Saindo...");
                    sistema=false;
                    Thread.sleep(2000);
                    limpar();
                    break;
                
                default:
                    limpar();
                    System.out.println("Opção Inválida");
                    Thread.sleep(2000);
                    limpar();
                    break;
            }
            System.out.println("Sistema Encerrado");
        }
        e.close();
    }
}
