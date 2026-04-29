programa {
  
  inclua biblioteca Util --> u 
  
  funcao inicio() {
    cadeia cliente, senha
    logico login=falso
    logico sistema=verdadeiro
    logico valido
    logico compra
    inteiro opcao, quantidade, item
    inteiro codmarmita[] = { 001, 002, 003, 004, 005}
    cadeia nomemarmita[] = {"Frango com Arroz     ", "Carne Moída com Purê", "Macarrão à Bolonhesa", "Strogonoff de Frango", "Arroz Carreteiro    "}
    inteiro quantidademarmita[] = {15, 12, 10, 14, 16}
    real valormarmita[] = {18.90, 19.90, 17.50, 21.00, 19.50}

    escreva("Entrando como Cliente...\n")
    u.aguarde(2000)
    limpa()

    faca {
      
        escreva("_____Cliente_____\n")

        escreva("\nDeseja se identificar?\n")
              
        escreva("\n1 - Não\n")
        escreva("2 - Sim\n")

        escreva("\nOpção: ")
        leia(opcao)
        limpa()
    
      escolha (opcao){
        
        caso 1:

          escreva("\nContinuando para sistema de compra...\n")
          login=verdadeiro
          limpa()

          pare
                  
        caso 2:
          enquanto (nao login) {
            escreva("Login: ") leia(cliente)
            escreva("Senha: ") leia(senha)
            limpa()
                  
            se (cliente == "1" e senha == "1"){
              login = verdadeiro
              escreva("Login realizado com sucesso!\n")
              u.aguarde(2000)
              limpa()
            }
            
            senao {
              escreva("Login Inválido!\n")
              escreva("Digite novamente!\n")
              u.aguarde(2000)
              limpa()
            }
          }
          pare

        caso contrario:

          limpa()
          escreva("Opção Inválida\n")
          u.aguarde(2000)
          limpa()
        
        pare
      }
    } enquanto(nao login)
    
      
      enquanto(sistema){
      
        escreva("_____________!!! Marmitas !!!_____________\n")
          
        escreva("\n")
          
        para (inteiro posicao = 0; posicao < 5; posicao++){
          escreva (codmarmita[posicao], "\t\t", nomemarmita[posicao], "\t\t", quantidademarmita[posicao], "\t\t\tR$", valormarmita[posicao], "\n")
        }

        escreva("__________________________________________\n")

          escreva("\nDeseja comprar?\n")

          escreva("\n1 - Sim\n")
          escreva("2 - Não\n")

          escreva("\nOpção: ")
          leia(opcao)

          escolha (opcao){
            caso 1:

              faca {

                escreva("\nDigite o código da marmita desejada ou digite '0' para voltar: ")
                leia(item)valido=falso

                para (inteiro posicao = 0; posicao < 5; posicao++){

                se (codmarmita[posicao] == item){

                  valido=verdadeiro
                  escreva("\nItem - ", nomemarmita[posicao], "\n")

              faca{

                compra=falso
                escreva("\nInforme a quantidade que deseja comprar ou digite '0' para voltar: ")
                leia(quantidade)
                      
                se (quantidade <= quantidademarmita[posicao] e quantidade > 0){

                quantidademarmita[posicao] = quantidademarmita[posicao] - quantidade
                escreva("\nItem comprado com sucesso!\n")compra=verdadeiro
                u.aguarde(2000)
                limpa()

                pare
                
                }senao se (quantidade == 0){
                  escreva("\nRetornando...\n")
                  compra=verdadeiro
                }
                  
                senao{
                  escreva("\nQuantidade em estoque insuficiente\n")
                }
                
                } enquanto(nao compra)
                  }

                  } se (item == 0){
                    escreva("\nRetornando...\n")
                    valido=verdadeiro
                    u.aguarde(2000)
                    limpa()
                  }

                  se (nao valido){
                    escreva("\nCódigo de item não encontrado!\n")
                  }
                
                } enquanto(nao valido)
                pare

            caso 2:
                limpa()
                escreva("Saindo...\n")
                sistema = falso
                u.aguarde(2000)
                limpa()

                pare

            caso contrario:
                
                limpa()
                escreva("Opção Inválida\n")
                u.aguarde(2000)
                limpa()            }
          }
          escreva("\n___Sistema Encerrado___\n")
  }
}
