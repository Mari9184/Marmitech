programa {

  inclua biblioteca Util --> u 
  
  funcao inicio() {
    cadeia usuario, senha
    logico login=falso
    logico sistema=verdadeiro
    logico quantidadevalida=falso
    logico valido
    inteiro opcao, quantidade, item
    inteiro codmarmita[] = { 1, 2, 3, 4, 5}
    cadeia nomemarmita[] = {"Frango com Arroz    ", "Carne Moída com Purê", "Macarrão à Bolonhesa", "Strogonoff de Frango", "Arroz Carreteiro    "}
    inteiro quantidademarmita[] = {15, 12, 10, 14, 16}
    real valormarmita[] = {18.90, 19.90, 17.50, 21.00, 19.50}

    escreva("Entrando como funcionário...\n")
    u.aguarde(2000)
    limpa()
  
    escreva("______Gerente______\n")

    enquanto(nao login){

      escreva("\nUsuario: ") leia(usuario)
      escreva("Senha: ") leia(senha)

      se (usuario == "1" e senha == "1"){
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
    
  escreva("\n___Sistema Encerrado___\n")
  
  }
}
