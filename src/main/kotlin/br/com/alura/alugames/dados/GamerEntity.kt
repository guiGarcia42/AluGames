package br.com.alura.alugames.dados

import javax.persistence.*

@Entity //Mapeia a classe para o JPA
@Table(name = "gamers") //Referencia a tabela jogos na base de dados
class GamerEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,
    val nome: String = "Nome do Gamer",
    val email: String = "email@email.com",
    val dataNascimento:String? = null,
    val usuario:String? = null,
    @ManyToOne
    val plano: PlanoEntity = PlanoAvulsoEntity()) {
}