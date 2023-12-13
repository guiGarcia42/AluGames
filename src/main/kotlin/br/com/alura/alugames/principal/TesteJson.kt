package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Periodo
import br.com.alura.alugames.modelo.PlanoAssinatura
import br.com.alura.alugames.servicos.ConsumoApi
import java.time.LocalDate

fun main(){

    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamersJson()
    val listaJogos = consumo.buscaJogosJson()

//    println(listaGamers)
//    println(listaJogos)

    val gamerCaroline = listaGamers.get(3)
    val jogoResidentVillage = listaJogos.get(10)
    val jogoSpiderMan = listaJogos.get(13)
    val jogoTheLastOfUs = listaJogos.get(2)

//    println(gamerCaroline)
//    println(jogoResidentVillage)

    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))
    val periodo4 = Periodo(LocalDate.of(2023,8,2), LocalDate.of(2023,8,15))

    gamerCaroline.alugaJogo(jogoResidentVillage, periodo1)
    gamerCaroline.alugaJogo(jogoSpiderMan, periodo2)
    gamerCaroline.alugaJogo(jogoTheLastOfUs, periodo3)
    gamerCaroline.alugaJogo(jogoSpiderMan, periodo4)

    println(gamerCaroline.jogosAlugados)
    println(gamerCaroline.jogosDoMes(8))

    val gamerCamila = listaGamers.get(5)
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3, 0.15)

    gamerCamila.alugaJogo(jogoResidentVillage, periodo1)
    gamerCamila.alugaJogo(jogoSpiderMan, periodo2)
    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo3)
    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo3)
    println(gamerCamila.jogosAlugados)

    gamerCamila.recomendar(7)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(8)
    println(gamerCamila)

    gamerCamila.alugaJogo(jogoResidentVillage, periodo1)
    println(gamerCamila.jogosAlugados)

}