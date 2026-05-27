//Projeto Integrador: Gerenciamento de Estoque
//Versсo Portugol webStudio
//Grupo: Ariel Isidro Nina Saavedra, Bruno Geanini dos Reis, Gabriel Tolcsvai de Cronis, Heloísa Weiss Willwohl Sanches, Mariane Santana da Silva, Miguel Augusto de Oliveira Santos


programa
{
  inclua biblioteca Util --> u

	funcao inicio()
	{
    cadeia usuario, senha
    logico autenticado = falso
    logico login=falso
    logico sistema=verdadeiro
    logico logininicio=falso
    logico quantidadevalida=falso
    logico valido
    logico compra
    logico encontrou
    inteiro opcao, quantidade, item
    inteiro maximolimite = 6
    inteiro cardapiodisponivel = 5
    inteiro codmarmita[100] = {1, 2, 3, 4, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    cadeia nomemarmita[100] = {"Frango com Arroz    ", "Carne Moída com Purê", "Macarrão à Bolonhesa", "Strogonoff de Frango", "Arroz Carreteiro    ", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}
    inteiro quantidademarmita[100] = {15, 12, 10, 14, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    real valormarmita[100] = {18.90, 19.90, 17.50, 21.00, 19.50, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}
    cadeia logincliente[100]
    cadeia senhacliente[100]
    cadeia nomecliente[100]
    inteiro totalclientes = 0
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
            escreva("3 - Não tenho login\n")
            
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

                autenticado = falso
                enquanto(nao autenticado){

                  escreva("Email: ")
                  leia(usuario)
                  escreva("Senha: ")
                  leia(senha)

                  autenticado = falso

                  para(inteiro i = 0; i < totalclientes; i++){
                    se(usuario == logincliente[i] e senha == senhacliente[i]){
                      autenticado = verdadeiro
                    }
                  }

                  se(autenticado){
                    escreva("Login realizado com sucesso!\n")
                    login = verdadeiro
                  }
                  senao{
                    escreva("Login inválido!\n")
                  }

                  se (login == "1" e senha == "1"){
                    login = verdadeiro
                    escreva("Login realizado com sucesso!\n")
                    u.aguarde(2000)
                    limpa()
                  }
                }
              limpa()
              pare
              caso 3:

                escreva("\n_____CADASTRO CLIENTE_____\n")

                escreva("\nNovo email: ")
                leia(logincliente[totalclientes])
                escreva("\nNova senha: ")
                leia(senhacliente[totalclientes])
                escreva("Informe seu Nome: ")
                leia(nomecliente[totalclientes])
                totalclientes = totalclientes + 1

                escreva("\nCadastro realizado com sucesso!\n")

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

          } enquanto(nao login)
      
          enquanto(sistema){

            escreva("_____________!!! Marmitas !!!_____________\n")
            
            escreva("\n")
            //Faz a tabulação do cardápio disponível
            para (inteiro posicao = 0; posicao < cardapiodisponivel; posicao++){
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

                    para (inteiro posicao = 0; posicao < cardapiodisponivel; posicao++){

                    se (codmarmita[posicao] == item){
                      valido=verdadeiro
                      escreva("\nItem - ", nomemarmita[posicao], "\n")

                      faca  {

                        compra=falso
                        escreva("\nInforme a quantidade que deseja comprar ou digite '0' para voltar: ")
                        leia(quantidade)
                            
                        se (quantidade <= quantidademarmita[posicao] e quantidade > 0){


                        real total 
                        cadeia formapagamento

                        total = quantidade * valormarmita[posicao]

                        limpa()
                        escreva("_____ PAGAMENTO _____\n")

                        escreva("\n1 - Pix\n")
                        escreva("2 - Cartão\n")
                        escreva("3 - Dinheiro\n")
                        escreva("4 - Cancelar Compra\n")

                        escreva("\nOpção: ")
                        leia(opcao)

                        escolha(opcao){

                          caso 1:
                            formapagamento = "Pix"
                          pare

                          caso 2:
                            formapagamento = "Cartão"
                          pare

                          caso 3:
                            formapagamento = "Dinheiro"
                          pare

                          caso 4:

                            escreva("\nCompra cancelada!\n")
                            u.aguarde(2000)
                            limpa()
                            compra = verdadeiro

                          pare

                          caso contrario:

                            escreva("\nPagamento inválido!\n")
                            u.aguarde(2000)
                            limpa()

                          pare
                        }

                        se(opcao >= 1 e opcao <= 3){

                          quantidademarmita[posicao] = quantidademarmita[posicao] - quantidade
                          
                          codpedido[totalpedidos] = totalpedidos + 1
                          nomepedido[totalpedidos] = nomemarmita[posicao]
                          quantidadpedido[totalpedidos] = quantidade
                          valorpedido[totalpedidos] = total
                          pagamentopedido[totalpedidos] = formapagamento

                          totalpedidos = totalpedidos + 1

                          limpa()

                          escreva("_____ NOTA FISCAL _____\n")

                          escreva("\nPedido: ", codpedido[totalpedidos - 1], "\n")
                          escreva("Produto: ", nomepedido[totalpedidos - 1], "\n")
                          escreva("Quantidade: ", quantidadpedido[totalpedidos - 1], "\n")
                          escreva("Valor Total: R$", valorpedido[totalpedidos - 1], "\n")
                          escreva("Pagamento: ", pagamentopedido[totalpedidos - 1], "\n")

                          escreva("\nCompra realizada com sucesso!\n")

                          u.aguarde(4000)
                          limpa()

                          compra = verdadeiro
                        } 
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

        pare

        caso 3:

          escreva("Entrando como gerente...\n")
          u.aguarde(2000)
          limpa()
        
          escreva("______Gerente______\n")

          //Faz a autenticação do login do gerente no sistema
          enquanto(nao login){

            escreva("\nEmail: ") leia(usuario)
            escreva("Senha: ") leia(senha)

            se (usuario == "3@3" e senha == "3"){
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
                escreva("3 - Criar item\n")
                escreva("4 - Excluir item\n")

                escreva("\nOpcao: ")
                leia(opcao)

                escolha(opcao){
                              
                  caso 1:

                    faca{

                      escreva("\nCodigo do item: ")
                      leia(item) 
                      valido=falso

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

                  pare

                  caso 3:
                    // Logica para encontrar posição vazia ou zerada e preencher com nova marmita
                    inteiro i
                    encontrou = falso
                    para (i = 0; i < maximolimite; i++)
                    {
                      se (codmarmita[i] == 0)
                      {
                        codmarmita[i] = maximolimite
                        escreva("Digite o nome da marmita: ")
                        leia(nomemarmita[i])
                        escreva("Digite a quantidade: ")
                        leia(quantidademarmita[i])
                        escreva("Digite o valor: ")
                        leia(valormarmita[i])

                        escreva("Marmita cadastrada com sucesso!\n")
                        escreva("Marmita adicionada: ", nomemarmita[i], "\t\t", quantidademarmita[i], "\t\t", valormarmita[i])
                        u.aguarde(2000)
                        limpa()
                        encontrou = verdadeiro
                        maximolimite = maximolimite + 1
                        cardapiodisponivel = cardapiodisponivel + 1
                        pare
                      }
                    }

                    se (encontrou == falso)
                    {
                      escreva("Erro: estoque cheio!\n")
                    } 
                    pare

                  caso 4:
                    // Estrutura da lógica para retirar marmitas do estoque
                    faca{
                      escreva("\nDigite o código da marmita que deseja retirar ou 0 para retornar: ")
                      leia(item) 
                      valido=falso
                      para (inteiro posicao = 0; posicao < maximolimite; posicao++){
                        se (item == 0){
                          escreva("Retornando...")
                          valido=verdadeiro
                          u.aguarde(2000)
                          limpa()
                          pare
                        }
                        senao se(codmarmita[posicao] == item){
                        valido=verdadeiro
                        escreva("\nItem encontrado: ", nomemarmita[posicao], "\n")
                        escreva("\nItem Retirado com Sucesso!")
                        para (inteiro i = posicao; i < maximolimite - 1; i++)
                        {
                          codmarmita[i] = codmarmita[i + 1]
                          nomemarmita[i] = nomemarmita[i + 1]
                          quantidademarmita[i] = quantidademarmita[i + 1]
                          valormarmita[i] = valormarmita[i + 1]
                        }
                        cardapiodisponivel = cardapiodisponivel-1
                        u.aguarde(2000)
                        limpa()
                        pare
                        }
                      } se (nao valido)
                      {
                        escreva("Código do Item inválido")
                      }
                    } enquanto(nao valido)
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
                limpa()
                escreva("\nVoltando...\n")
                u.aguarde(2000)
                limpa()

              pare
                                                 
              caso 4:
              
                escreva("______Gerir Equipe______\n")

                escreva("\n1 - Visualizar Funcionários\n")
                escreva("2 - Adicionar usuário\n")
                escreva("3 - Remover usuário\n")
                escreva("4 - Voltar\n")

                escreva("\nOpção: ")
                leia(opcao)
                limpa()

                escolha (opcao) {
                  caso 1:

                  escreva("_____FUNCIONARIOS_____\n\n")

                  escreva("COD|\tLOGIN|\t\tSENHA|\n")
                  escreva("----------------------------------\n")

                  para(inteiro i = 0; i < totalfuncionarios; i++){
                    escreva(i + 1, "\t\t", loginfuncionario[i], "\t\t", senhafuncionario[i], "\n")

                  }

                  faca{

                    escreva("\nDigite 0 para voltar: ")
                    leia(opcao)
                    se(opcao != 0){
                      escreva("\nDigite apenas 0!\n")
                    }

                  } enquanto(opcao != 0)

                  limpa()

                pare
                    faca{
                      escreva("\nDigite 0 para voltar: ")
                      leia(opcao)
                      se(opcao != 0){
                        escreva("\nDigite apenas 0!\n")
                      }

                    } enquanto(opcao != 0)
                    limpa()

                  pare                    
                  caso 2:

                    escreva("_____ADICIONAR FUNCIONARIO_____\n\n")
                    escreva("Codigo do novo funcionario: ", totalfuncionarios + 1, "\n\n")
                    cadeia novologin
                    cadeia novasenha

                    escreva("email do funcionario: ")
                    leia(novologin)
                    escreva("Senha do funcionario: ")
                    leia(novasenha)

                    loginfuncionario[totalfuncionarios] = novologin
                    senhafuncionario[totalfuncionarios] = novasenha

                    totalfuncionarios = totalfuncionarios + 1

                    escreva("\nFuncionario cadastrado com sucesso!\n")

                    u.aguarde(2000)
                    limpa()

                  pare
                     
                  caso 3:
                    escreva("_____REMOVER FUNCIONARIO_____\n\n")
                    escreva("COD", "\t|\t", "LOGIN\n")
                    escreva("-------------------------\n")

                    para(inteiro i = 0; i < totalfuncionarios; i++){
                      escreva(i + 1, "\t\t", loginfuncionario[i], "\n")
                    }

                    escreva("\nDigite o codigo do funcionario: ")
                    leia(item)

                    se(item > 0 e item <= totalfuncionarios){
                      para(inteiro i = item; i < totalfuncionarios -1; i++){

                        loginfuncionario[i-1] = loginfuncionario[i + 1]
                        senhafuncionario[i-1] = senhafuncionario[i + 1]

                      }

                      totalfuncionarios = totalfuncionarios - 1

                      escreva("\nFuncionario removido com sucesso!\n")
                    }

                    senao{

                      escreva("\nCodigo invalido!\n")

                    }

                    u.aguarde(2000)
                    limpa()

                  pare
                  caso 4:

                    escreva("Voltando...\n")
                    u.aguarde(2000)
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



