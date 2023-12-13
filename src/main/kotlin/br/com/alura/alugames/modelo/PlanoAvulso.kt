package br.com.alura.alugames.modelo

// Aqui estamos herdando a classe Plano e a variavel tipo
class PlanoAvulso(tipo: String): Plano(tipo){

    override fun obterValor(aluguel: Aluguel): Double {
        var valorOriginal = super.obterValor(aluguel)
        if(aluguel.gamer.media >= 8) {
            valorOriginal -= valorOriginal * 0.10
        }
        return valorOriginal
    }

}
