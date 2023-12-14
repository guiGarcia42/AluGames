package br.com.alura.alugames.modelo

import java.math.BigDecimal


// Open significa que a classe está "aberta" para receber heranças
// Podemos usar "abstract" também para não poder implementar somente "Plano"
// "sealed" é mais restrito que "abstract", não pode ser acessado fora do package
sealed class Plano (val tipo: String) {

    open fun obterValor(aluguel: Aluguel): BigDecimal {
        return aluguel.jogo.preco * aluguel.periodo.emDias.toBigDecimal()

    }
}