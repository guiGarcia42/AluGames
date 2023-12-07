package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.servicos.ConsumoApi
import java.util.Scanner

fun main() {

    val leitura = Scanner(System.`in`)
    println("Digite um código de jogo para buscar:")
    val busca = leitura.nextLine()

    // inicializamos a API para utilizar nos códigos
    val buscaApi = ConsumoApi()
    val informacaoJogo = buscaApi.buscaJogo(busca)

    //inicializando
    var meuJogo: Jogo? = null

    //Tratamento de exceção KOTLIN, salvamos na variável e podemos tratar os erros separadamente
    val resultado = runCatching {
        meuJogo = Jogo(
            informacaoJogo.info.title,
            informacaoJogo.info.thumb
        )
    }

    // Somente no caso de falha no runCatch que iremos tratar.
    resultado.onFailure {
        println("Jogo inexistente. Tente outro id.")
    }

    // No caso de sucesso, seguir com esse bloco.
    resultado.onSuccess {
        println("Deseja inserir uma descrição personalizada? S/N")
        val opcao = leitura.nextLine()
        if(opcao.equals("s", true)) {
            println("Insira a descrição personalizada para o jogo:")
            val descricaoPersonalizada = leitura.nextLine()
            meuJogo?.descricao = descricaoPersonalizada

        }else{
            meuJogo?.descricao = meuJogo?.titulo
        }
    }

    resultado.onSuccess {
        println("Busca finalizada com sucesso.")
    }
}