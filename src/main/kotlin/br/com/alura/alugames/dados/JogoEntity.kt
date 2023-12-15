package br.com.alura.alugames.dados

import java.math.BigDecimal
import javax.persistence.*

@Entity //Mapeia a classe para o JPA
@Table(name = "jogos") //Referencia a tabela jogos na base de dados
class JogoEntity(
    val titulo: String = "Título do jogo",
    val capa: String = "Capa do jogo",
    val preco: BigDecimal = BigDecimal("0.0"),
    val descricao: String? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //Informa ao JPA qual vai ser a primarykey
    val id: Int = 0) {
}