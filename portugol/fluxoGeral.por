programa
{
  inclua biblioteca Util --> u

	funcao inicio()
	{
    cadeia usuario, senha
    logico login=falso
    logico sistema=verdadeiro
    logico logininicio=falso
    logico quantidadevalida=falso
    logico valido
    logico compra
    inteiro opcao, quantidade, item, sub_opcao
    inteiro codmarmita[] = { 1, 2, 3, 4, 5}
    cadeia nomemarmita[] = {"Frango com Arroz    ", "Carne Moída com Purê", "Macarrão à Bolonhesa", "Strogonoff de Frango", "Arroz Carreteiro    "}
    inteiro quantidademarmita[] = {15, 12, 10, 14, 16}
    real valormarmita[] = {18.90, 19.90, 17.50, 21.00, 19.50}

    //Verifica a forma de entrada e sua validade e retorna  sempre que qualquer erro ocorrer ou não for validado o login
    enquanto (nao logininicio){
      sistema = verdadeiro
      login = falso
      escreva("______Entrada Como______\n")

      escreva("\n1 - Cliente\n") // 1 - 1
      escreva("2 - Funcionário\n") // 2 - 2
      escreva("3 - Gerente\n") // 3 - 3
      escreva("4 - Encerrar\n")

      escreva("\nOpção: ")
      leia(opcao)
      limpa()


      //Inicia as funcionalidades do sistema como cliente
      escolha (opcao){

        caso 1:

          escreva("Entrando como Cliente...\n")
          u.aguarde(2000)
          limpa()
          //Faz autenticação de login como cliente, seja indentificando-se ou não
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
                //Faz a autenticação do login identificado
                sistema = verdadeiro
                enquanto (nao login) {
                  escreva("Login: ") leia(login)
                  escreva("Senha: ") leia(senha)
                  limpa()
                        
                  se (login == "1" e senha == "1"){
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
            //Faz a tabulação do cardápio disponível
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
                  //Faz a verificação da validade da marmita em estoque e efetua a compra se a validação for correta
                  faca {

                    escreva("\nDigite o código da marmita desejada ou digite '0' para voltar: ")
                    leia(item)valido=falso

                    para (inteiro posicao = 0; posicao < 5; posicao++){

                    se (codmarmita[posicao] == item){

                      valido=verdadeiro
                      escreva("\nItem - ", nomemarmita[posicao], "\n")

                      faca  {

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
                  limpa()

                pare            
                  
              }
            }
        pare
          
        caso 2:
          

          escreva("Entrando como funcionário...\n")
          u.aguarde(2000)
          limpa()
  
          escreva("______Funcionário______\n")

          //Faz a autenticação do login do Funcionário
          login = falso
          enquanto(nao login){
            
            escreva("\nUsuario: ") leia(usuario)
            escreva("Senha: ") leia(senha)

            se (usuario == "2" e senha == "2"){
              login = verdadeiro
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

                escreva("_____Notificações_____\n")
                escreva("\nSem notificações encontradas\n")

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
      
                para (inteiro posicao = 0; posicao < 5; posicao++){
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

                        para (inteiro posicao = 0; posicao < 5; posicao++){

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

                        para (inteiro posicao = 0; posicao < 5; posicao++){

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
                escreva("\nSem pedidos realizados\n")

                escreva("\nEm 3 segundos será redirecinado...")
                u.aguarde(3500)
                limpa()

              pare

              caso 4:
                //Encerra o Sistema
                logininicio=verdadeiro      
                escreva("Encerrando sistema...\n")
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

        pare

        caso 3:

          escreva("Entrando como gerente...\n")
          u.aguarde(2000)
          limpa()
        
          escreva("______Gerente______\n")

          //Faz a autenticação do login do gerente no sistema
          enquanto(nao login){

            escreva("\nUsuario: ") leia(usuario)
            escreva("Senha: ") leia(senha)

            se (usuario == "3" e senha == "3"){
            login = verdadeiro
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
          //Valida a ação que o gerente deseja fazer no sistema
          enquanto (sistema){
          
            escreva("_____Ações_____\n")

            escreva("\n1 - Notificacao\n")
            escreva("2 - Estoque\n")
            escreva("3 - Pedidos\n")
            escreva("4 - Gerenciar Funcionarios\n")
            escreva("5 - Encerrar Sistema\n")

            escreva("\nOpcao: ")
            leia(opcao)
            limpa()

            escolha (opcao){

              caso 1:

                escreva("Abrindo Notificações...\n")
                u.aguarde(2000)
                limpa()

                escreva("_____Notificações_____\n")
                escreva("\nSem notificações encontradas\n")

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

                para (inteiro posicao = 0; posicao < 5; posicao++){
                escreva (codmarmita[posicao], "\t\t", nomemarmita[posicao], "\t\t", quantidademarmita[posicao], "\t\t\tR$", valormarmita[posicao], "\n")
                }

                escreva("_______________________________________\n")

                escreva("\n1 - Adicionar item ao estoque\n")
                escreva("2 - Remover item do estoque\n")
                escreva("3 - Criar item\n")
                escreva("4 - Excluir item\n")

                escreva("\nOpcao: ")
                leia(opcao)

                escolha(opcao){
                              
                  caso 1:

                    faca{

                      escreva("\nCodigo do item: ")
                      leia(item) valido=falso

                      para (inteiro posicao = 0; posicao < 5; posicao++){

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

                    faca{

                      escreva("\nCodigo do item: ")
                      leia(item) valido=falso

                      para (inteiro posicao = 0; posicao < 5; posicao++){

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

                  pare

                  caso 3:

                    limpa()

                    escreva("No momento ainda não funciona ...")
                    u.aguarde(2000)
                    limpa()

                    escreva("Em 3 segundos será redirecinado...")
                    u.aguarde(3500)
                    limpa()
                        
                  pare

                  caso 4:

                    limpa()
                        
                    escreva("No momento ainda não funciona...")
                    u.aguarde(2000)
                    limpa()

                    escreva("Em 3 segundos será redirecinado...")
                    u.aguarde(3500)
                    limpa()

                  pare

                  caso contrario:

                    limpa()
                    escreva("Opção Inválida!")
                    u.aguarde(2000)
                    limpa()

                  pare
                      }
              
              pare

              caso 3:
                        
                escreva("Abrindo Pedidos...\n")
                u.aguarde(2000)
                limpa()

                escreva("_____Pedidos_____\n")
                escreva("\nSem pedidos realizados\n")

                escreva("\nEm 3 segundos será redirecinado...")
                u.aguarde(3500)
                limpa()

              pare

              caso 4:
              
                escreva("______Gerir Equipe______\n")

                escreva("\n1 - Adicionar usuário\n")
                escreva("2 - Remover usuário\n")
                escreva("3 - Alterar acesso\n")

                escreva("\nOpção: ")
                leia(opcao)
                limpa()

                escolha (opcao) {

                  caso 1:
                    
                    escreva("No momento ainda não funciona ...")
                    u.aguarde(2000)
                    limpa()

                    escreva("Em 3 segundos será redirecinado...")
                    u.aguarde(3500)
                    limpa()
                    
                  pare
                          
                  caso 2:
                    
                    escreva("No momento ainda não funciona ...")
                    u.aguarde(2000)
                    limpa()

                    escreva("Em 3 segundos será redirecinado...")
                    u.aguarde(3500)
                    limpa()
                    
                  pare
                        
                  caso 3:
                    
                    escreva("No momento ainda não funciona ...")
                    u.aguarde(2000)
                    limpa()

                    escreva("Em 3 segundos será redirecinado...")
                    u.aguarde(3500)
                    limpa()
                    
                  pare
                          
                  caso contrario:

                    escreva("Opção inválida no menu de equipe.\n")
                    u.aguarde(2000)
                    limpa()

                    escreva("Em 3 segundos será redirecinado...")
                    u.aguarde(3500)
                    limpa()

                  pare
                }
              pare

              caso 5:
                //Retorna para o Inicío
                escreva("Voltando para tela de inicio...\n")
                sistema = falso
                u.aguarde(2000)
                limpa()

              pare

            }
          }
        pare
        
        caso 4:
          //Encerra o programa
          limpa()
          escreva("Saindo...\n")
          sistema = falso
          u.aguarde(2000)
          limpa()
          logininicio=verdadeiro

        pare

        caso contrario:

          limpa()
          escreva("Opção Inválida\n")
          u.aguarde(2000)
          limpa()

        pare

      }
    }

    escreva("\n___Sistema Encerrado___\n")

  }
}    
