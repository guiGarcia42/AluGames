package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.utilitario.toEntity
import br.com.alura.alugames.utilitario.toModel
import javax.persistence.EntityManager

//Passamos quem gerencia a base de dados para quem estiver usando a classe, assim não precisamos
// abrir e fecha-lo em cada método
class JogosDAO(manager: EntityManager) : DAO<Jogo, JogoEntity>(manager, JogoEntity::class.java) {

    override fun toEntity(objeto: Jogo): JogoEntity {
        return objeto.toEntity()
    }

    override fun toModel(entity: JogoEntity): Jogo {
        return entity.toModel()
    }

}