package br.com.alura.alugames.principal

import br.com.alura.alugames.dados.Banco
import br.com.alura.alugames.dados.JogosDAO
import br.com.alura.alugames.modelo.Jogo
import java.math.BigDecimal

fun main() {

    val jogo = Jogo(
        "The Last of Us Part I",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        BigDecimal("5.99"),
        "Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito."
    )
    val jogo2 = Jogo(
        "Dandara",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293",
        BigDecimal("9.99"),
        "Um jogo de plataforma e ação com elementos de metroidvania, onde você controla a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania."
    )

    // inicializando a conexao e passando para a classe dao (assim abrindo a conexao com o banco)
    val manager = Banco.getEntityManager()
    val jogoDao = JogosDAO(manager)
    jogoDao.adicionarJogos(jogo2)


    val listaJogos: List<Jogo> = jogoDao.getJogos()
    println(listaJogos)

    manager.close()

}