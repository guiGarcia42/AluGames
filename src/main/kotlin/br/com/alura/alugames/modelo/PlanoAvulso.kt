package br.com.alura.alugames.modelo

import java.math.BigDecimal
import java.math.RoundingMode

// Aqui estamos herdando a classe Plano e a variavel tipo
class PlanoAvulso(
    tipo: String,
    id: Int = 0): Plano(tipo, id){

    override fun obterValor(aluguel: Aluguel): BigDecimal {
        var valorOriginal = super.obterValor(aluguel)
        if(aluguel.gamer.media >= 8) {
            valorOriginal -= valorOriginal.multiply(BigDecimal("0.1"))
        }
        return valorOriginal.setScale(2, RoundingMode.HALF_EVEN)
    }

    override fun toString(): String {
        return "PlanoAvulso \n" +
                "Tipo: $tipo \n" +
                "Id: $id \n"
    }


}
