package br.com.alura.alugames.servicos

import br.com.alura.alugames.modelo.InfoJogo
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {

    fun buscaJogo(id: String): InfoJogo{
        // interpolação de string
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

        // requisição HTTP
        val client: HttpClient = HttpClient.newHttpClient()
        val request: HttpRequest = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()

        // salva a resposta da requisição
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())
        val json = response.body()

        // desserializa o json para a classe jogo
        val gson = Gson()

        // Convertendo o json para a classe Jogo
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

        return meuInfoJogo
    }


}