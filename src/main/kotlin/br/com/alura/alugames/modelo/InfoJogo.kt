package br.com.alura.alugames.modelo

data class InfoJogo(val info: InfoApiShark) {

    override fun toString(): String {
        return info.toString() // Passando o toString da classe br.com.alura.alugames.modelo.Jogo.
    }
}