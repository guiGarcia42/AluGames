package br.com.alura.alugames.modelo

import br.com.alura.alugames.utilitario.formatoComDuasCasasDecimais
import com.google.gson.annotations.Expose
import java.math.BigDecimal
import java.math.RoundingMode


data class Jogo(
    @Expose val titulo:String,
    @Expose val capa:String): Recomendavel {

    var descricao: String? = null
    var preco = BigDecimal("0.0")

    var id = 0
    val listaNotas = mutableListOf<Int>()

    override val media: Double
        get() = listaNotas.average().formatoComDuasCasasDecimais()

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }

    constructor(titulo: String, capa: String, preco: BigDecimal, descricao: String?, id: Int = 0):
            this(titulo, capa){
        this.preco = preco.setScale(2, RoundingMode.HALF_EVEN)
        this.descricao = descricao
        this.id = id
    }

    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título= $titulo \n" +
                "Capa= $capa \n" +
                "Preço= $preco \n" +
                "Descrição= $descricao \n" +
                "Reputação= $media \n" +
                "Id: $id"
    }
}