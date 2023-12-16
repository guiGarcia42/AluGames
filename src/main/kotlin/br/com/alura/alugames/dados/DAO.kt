package br.com.alura.alugames.dados

import javax.persistence.EntityManager

abstract class DAO <TModel, TEntity>(protected val manager: EntityManager, protected val entityType: Class<TEntity>) {

    abstract fun toEntity(objeto: TModel): TEntity

    abstract fun toModel(entity: TEntity): TModel

    open fun getLista(): List<TModel>{
        // Mesma lógica da conexao, mas usando o hibernate
        // val manager = Banco.getEntityManager()
        val query = manager.createQuery("FROM ${entityType.simpleName}", entityType) //digita o nome da Classe
        return query.resultList.map { entity -> toModel(entity)}
    }
    open fun adicionar(objeto: TModel) {
        val entity = toEntity(objeto)
        //enviando as infos para o banco
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

    open fun recuperarPeloId(id: Int): TModel {
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType) //digita o nome da Classe
        query.setParameter("id", id)
        val entity = query.singleResult

        return toModel(entity)
    }

    open fun apagar(id: Int){
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType) //digita o nome da Classe
        query.setParameter("id", id)
        val entity = query.singleResult

        manager.transaction.begin()
        manager.remove(entity)
        manager.transaction.commit()
    }

}