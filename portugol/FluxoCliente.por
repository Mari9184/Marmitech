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
    logico login = falso
    logico sistema = verdadeiro
    logico valido
    logico compra
    inteiro opcao, quantidade, item
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
    /////
    

    //Verifica a forma de entrada e sua validade e retorna  sempre que qualquer erro ocorrer ou não for validado o login


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

          se (usuario == "1" e senha == "1"){
            autenticado = verdadeiro
          }

          se(autenticado){
            escreva("Login realizado com sucesso!\n")
            login = verdadeiro
          }

          senao{
            escreva("Login inválido!\n")
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
  }
}   
