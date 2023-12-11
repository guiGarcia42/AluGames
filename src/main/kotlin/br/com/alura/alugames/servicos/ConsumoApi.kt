package br.com.alura.alugames.servicos

import br.com.alura.alugames.modelo.*
import br.com.alura.alugames.utilitario.criarGamer
import br.com.alura.alugames.utilitario.criarJogo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {

    // refatorando o código e colocando essa função que vai ser usada
    // da mesma forma mais vezes no código, evitando redundâncias
    private fun consomeDados(endereco: String): String{

        // requisição HTTP
        val client: HttpClient = HttpClient.newHttpClient()
        val request: HttpRequest = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()

        // salva a resposta da requisição
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()
    }

    fun buscaJogo(id: String): InfoJogo{
        // interpolação de string
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val json = consomeDados(endereco)

        // desserializa o json para a classe jogo
        val gson = Gson()

        // Convertendo o json para a classe Jogo
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

        return meuInfoJogo
    }

    fun buscaGamersJson(): List<Gamer> {
        // interpolação de string
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val json = consomeDados(endereco)

        // desserializa o json para a classe jogo
        val gson = Gson()

        // Especifica para o gson que queremos uma lista de objetos, quando for usar um
        // tipo genérico como List e dentro dela uma classe precisamos usar essa sintaxe
        val meuGamerTipo = object: TypeToken<List<InfoGamerJson>>() {}.type

        // Convertendo o json para a classe Jogo
        val listaGamerJson:List<InfoGamerJson> = gson.fromJson(json, meuGamerTipo)

        // Mapeando a lista de json para objetos da classe Gamer
        val listaGamer = listaGamerJson.map { infoGamerJson -> infoGamerJson.criarGamer() }

        return listaGamer
    }

    fun buscaJogosJson(): List<Jogo> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = consomeDados(endereco)

        val gson = Gson()
        val meuJogoTipo = object: TypeToken<List<InfoJogoJson>>() {}.type
        val listaJogoJson: List<InfoJogoJson> = gson.fromJson(json, meuJogoTipo)

        val listaJogo = listaJogoJson.map { infoJogoJson -> infoJogoJson.criarJogo() }

        return listaJogo
    }

}