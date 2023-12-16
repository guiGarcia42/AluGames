package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Jogo
import javax.persistence.EntityManager

//Passamos quem gerencia a base de dados para quem estiver usando a classe, assim não precisamos
// abrir e fecha-lo em cada método
class JogosDAO(manager: EntityManager) : DAO<Jogo, JogoEntity>(manager, JogoEntity::class.java) {

    override fun toEntity(objeto: Jogo): JogoEntity {
        return JogoEntity(
            objeto.titulo,
            objeto.capa,
            objeto.preco,
            objeto.descricao,
            objeto.id)
    }

    override fun toModel(entity: JogoEntity): Jogo {
        return Jogo(
            entity.titulo,
            entity.capa,
            entity.preco,
            entity.descricao,
            entity.id
        )
    }

}