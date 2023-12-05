data class InfoJogo(val info:InfoApiShark) {

    override fun toString(): String {
        return info.toString() // Passando o toString da classe Jogo.
    }
}