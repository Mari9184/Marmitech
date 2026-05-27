//Projeto Integrador: Gerenciamento de Estoque
//Versсo Portugol webStudio
//Grupo: Ariel Isidro Nina Saavedra, Bruno Geanini dos Reis, Gabriel Tolcsvai de Cronis, Heloísa Weiss Willwohl Sanches, Mariane Santana da Silva, Miguel Augusto de Oliveira Santos


programa
{
  inclua biblioteca Util --> u

	funcao inicio()
	{
    cadeia usuario, senha
    logico login=falso
    logico sistema=verdadeiro
    logico quantidadevalida=falso
    logico valido
    inteiro opcao, quantidade, item
    inteiro cardapiodisponivel = 5
    inteiro codmarmita[100] = {1, 2, 3, 4, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    cadeia nomemarmita[100] = {"Frango com Arroz    ", "Carne Moída com Purê", "Macarrão à Bolonhesa", "Strogonoff de Frango", "Arroz Carreteiro    ", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}
    inteiro quantidademarmita[100] = {15, 12, 10, 14, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    real valormarmita[100] = {18.90, 19.90, 17.50, 21.00, 19.50, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}
    inteiro codpedido[100] 
    cadeia nomepedido[100] 
    inteiro quantidadpedido[100]
    real valorpedido[100]
    cadeia pagamentopedido[100] 
    inteiro totalpedidos = 0 
    cadeia loginfuncionario[100] = {"2@2","0","0","0","0","0","0","0","0","0"}
    cadeia senhafuncionario[100] = {"2","0","0","0","0","0","0","0","0","0"}
    inteiro totalfuncionarios = 1 
    

    //Verifica a forma de entrada e sua validade e retorna  sempre que qualquer erro ocorrer ou não for validado o login
        
    escreva("Entrando como funcionário...\n")
    u.aguarde(2000)
    limpa()

    escreva("______Funcionário______\n")

    //Faz a autenticação do login do Funcionário        
    login = falso
    enquanto(nao login){
      escreva("\nEmail: ") leia(usuario)
      escreva("Senha: ") leia(senha)

      login = falso
      para(inteiro i = 0; i < totalfuncionarios; i++){
        se(usuario == loginfuncionario[i] e senha == senhafuncionario[i]){
          login = verdadeiro

        }
      }
      se(login){
        limpa()
      }

      senao{
        limpa()
        escreva("Login Inválido!\n")
        u.aguarde(2000)

        limpa()
        escreva("Digite novamente:\n")
      }
    }
    escreva("Login realizado com sucesso!\n")
    u.aguarde(2000)
    limpa()        


    //Valida a ação que o Funcionário deseja fazer no sistema
    enquanto (sistema){

      escreva("_____Ações_____\n")

      escreva("\n1 - Notificação\n")
      escreva("2 - Estoque\n")
      escreva("3 - Pedidos\n")
      escreva("4 - Encerrar\n")

      escreva("\nOpcao: ")
      leia(opcao)
      limpa()

      escolha (opcao){

        caso 1:
          
          escreva("Abrindo Notificações...\n")
          u.aguarde(2000)
          limpa()


          logico temNotificacao
          temNotificacao = falso
          
          escreva("_____NOTIFICACOES_____\n\n")
          
          para (inteiro i = 0; i < cardapiodisponivel; i++) {
            se (quantidademarmita[i] < 10) {
              escreva("Estoque baixo: ", nomemarmita[i]," | Quantidade: ", quantidademarmita[i], "\n")
              temNotificacao = verdadeiro
            }
          }

          se (temNotificacao == falso) {
            escreva("Não há notificações no momento.\n")
          }

          escreva("\nEm 3 segundos será redirecinado...")
          u.aguarde(3500)
          limpa()
                    
        pare
        caso 2:
                    
          escreva("Abrindo Estoque...\n")
          u.aguarde(2000)
          limpa()

          escreva("_____________Gerir Estoque_____________\n")

          escreva("\n")

          para (inteiro posicao = 0; posicao < cardapiodisponivel; posicao++){
          escreva (codmarmita[posicao], "\t\t", nomemarmita[posicao], "\t\t", quantidademarmita[posicao], "\t\t\tR$", valormarmita[posicao], "\n")
          }

          escreva("_______________________________________\n")

          escreva("\n1 - Adicionar item ao estoque\n")
          escreva("2 - Remover item do estoque\n")

          escreva("\nOpcao: ")
          leia(opcao)

            escolha(opcao){
            
              caso 1:
                //Faz a autenticação do item em estoque e verifica a validade para adicionar quantidade
                faca{

                  escreva("\nCodigo do item: ")
                  leia(item) valido=falso

                  para (inteiro posicao = 0; posicao < cardapiodisponivel; posicao++){
                  se(codmarmita[posicao] == item){
                  valido=verdadeiro

                  escreva("\nItem a adicionar - ", nomemarmita[posicao], "\n")
                                  
                  escreva("\nQuantidade a adicionar: ")
                  leia(quantidade)
                  limpa()

                  quantidademarmita[posicao] = quantidademarmita[posicao] + quantidade
                  escreva("\nItem adicionado com sucesso!\n")
                  u.aguarde(2000)
                  limpa()

                  escreva("\nNovo estoque: ", nomemarmita[posicao], "\t\t", quantidademarmita[posicao], "\n")
                  u.aguarde(3500)
                  limpa()

                  escreva("\nEm 3 segundos será redirecinado...")
                  u.aguarde(3500)
                  limpa()

                  pare
                  }

                  }se (nao valido){

                    escreva("Código de item não encontrado!\n")                      
                  }
                }enquanto(nao valido)

              pare
              caso 2:
                //Faz a autenticação do item em estoque e verifica a validade para retirar quantidade
                faca{

                  escreva("\nCodigo do item: ")
                  leia(item) valido=falso

                  para (inteiro posicao = 0; posicao < cardapiodisponivel; posicao++){

                    se(codmarmita[posicao] == item){

                      valido=verdadeiro
                      escreva("\nItem encontrado: ", nomemarmita[posicao], "\n")
                      quantidadevalida=falso
                                  
                      enquanto (nao quantidadevalida){

                        escreva("\nQuantidade para retirar: ")
                        leia(quantidade)                  
                        se(quantidade <= quantidademarmita[posicao] e quantidade > 0){

                          quantidadevalida=verdadeiro
                          quantidademarmita[posicao] = quantidademarmita[posicao] - quantidade
                          escreva("\nItem removido com sucesso!\n")
                          u.aguarde(2000)
                          limpa()

                          escreva("\nNovo estoque: ", nomemarmita[posicao], "\t\t", quantidademarmita[posicao], "\n")
                          u.aguarde(3500)
                          limpa()

                          escreva("\nEm 3 segundos será redirecinado...")
                          u.aguarde(3500)
                          limpa()
                                    
                          pare
                        }
          
                        senao{
                                      
                          escreva("Quantidade invállida!")
                          u.aguarde(2000)
                          limpa()
                        
                        }
                      }
                    }
                    
                  }se (nao valido){   
                      escreva("Código de item não encontrado!\n")

                  }
                }enquanto(nao valido)

            }
        pare

        caso 3:                                  
          escreva("Abrindo Pedidos...\n")
          u.aguarde(2000)
          limpa()

          escreva("_____Pedidos_____\n")

          se(totalpedidos == 0){

            escreva("\nSem pedidos realizados\n")

          }

          senao{

            para(inteiro i = 0; i < totalpedidos; i++){

              escreva("\nPedido: ", codpedido[i], "\n")
              escreva("Produto: ", nomepedido[i], "\n")
              escreva("Quantidade: ", quantidadpedido[i], "\n")
              escreva("Valor Total: R$", valorpedido[i], "\n")
              escreva("Pagamento: ", pagamentopedido[i], "\n")

              escreva("-------------------------\n")
            }
          }

          faca{

            escreva("\nDigite 0 para voltar: ")
            leia(opcao)

            se(opcao != 0){
              escreva("\nDigite apenas 0 para voltar!\n")
            }

          } enquanto(opcao != 0)

          escreva("\nVoltando...\n")
          u.aguarde(2000)
          limpa()

        pare
        caso 4:
          escreva("Voltando para tela de inicio...\n")
          sistema = falso
          u.aguarde(2000)
          limpa()
        pare

        caso contrario:
                  
          escreva("Opção Inválida!")
          u.aguarde(2000)
          limpa()

        pare

      }
    } 
  }
}   


