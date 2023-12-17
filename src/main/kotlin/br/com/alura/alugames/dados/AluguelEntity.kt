package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Periodo
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table (name = "aluguel")
class AluguelEntity(
    @ManyToOne
    val gamerEntity: GamerEntity = GamerEntity(),
    @ManyToOne
    val jogoEntity: JogoEntity = JogoEntity(),
    @Embedded
    val periodo: Periodo = Periodo()) {

    var valorDoAluguel = BigDecimal("0.0")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0
}