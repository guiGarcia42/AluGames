package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Periodo
import br.com.alura.alugames.modelo.PlanoAssinatura
import br.com.alura.alugames.servicos.ConsumoApi
import com.google.gson.GsonBuilder
import java.io.File
import java.math.BigDecimal
import java.time.LocalDate

fun main(){

    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamersJson()
    val listaJogos = consumo.buscaJogosJson()

    val gamerCaroline = listaGamers.get(3)
    val gamerCamila = listaGamers.get(5)
    val jogoResidentVillage = listaJogos.get(10)
    val jogoSpiderMan = listaJogos.get(13)
    val jogoTheLastOfUs = listaJogos.get(2)
    val jogoDandara = listaJogos.get(5)
    val jogoAssassins = listaJogos.get(4)
    val jogoCyber = listaJogos.get(6)
    val jogoGod = listaJogos.get(7)
    val jogoSkyrim = listaJogos.get(18)

    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))
    val periodo4 = Periodo(LocalDate.of(2023,8,2), LocalDate.of(2023,8,15))

    gamerCaroline.alugaJogo(jogoResidentVillage, periodo1)
    gamerCaroline.alugaJogo(jogoSpiderMan, periodo2)
    gamerCaroline.alugaJogo(jogoTheLastOfUs, periodo3)
    gamerCaroline.alugaJogo(jogoSpiderMan, periodo4)

    gamerCamila.plano = PlanoAssinatura("PRATA", BigDecimal("9.90"), 3, BigDecimal("0.15"))

    gamerCamila.alugaJogo(jogoResidentVillage, periodo1)
    gamerCamila.alugaJogo(jogoSpiderMan, periodo2)
    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo3)
    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo3)

    gamerCamila.recomendar(7)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(8)

    gamerCamila.alugaJogo(jogoResidentVillage, periodo1)

    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)
    gamerCamila.recomendarJogo(jogoAssassins, 8)
    gamerCamila.recomendarJogo(jogoCyber, 7)
    gamerCamila.recomendarJogo(jogoGod, 10)
    gamerCamila.recomendarJogo(jogoDandara, 8)
    gamerCamila.recomendarJogo(jogoSkyrim, 8)
    gamerCamila.recomendarJogo(jogoSpiderMan, 6)

    gamerCaroline.recomendarJogo(jogoResidentVillage, 8)
    gamerCaroline.recomendarJogo(jogoTheLastOfUs, 9)


//    println("Jogos da Camila:")
//    println(gamerCamila.jogosRecomendados)
//    println("Jogos da Caroline:")
//    println(gamerCaroline.jogosRecomendados)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serializacao = gson.toJson(gamerCamila.jogosRecomendados)

    val arquivo = File("jogosRecomendados-${gamerCamila.nome}.json")
    arquivo.writeText(serializacao)

}