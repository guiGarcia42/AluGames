package br.com.alura.alugames.dados

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

object Banco {
//    fun obterConexao(): Connection? {
//        return try {
//            DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/alugames",
//                "guigarcia42",
//                "Billyebela42%")
//        } catch (e: SQLException) {
//            e.printStackTrace()
//            null
//        }
//    }

    fun getEntityManager(): EntityManager {
        // factory é responsável por gerenciar a conexão, passando o nome do banco que vamos criar esse Factory
        // Esse nome que passamos do banco "alugames" vai procurar no arquivo persistence.xml a tag para puxar
        // todas as configurações que estão lá dentro
        val factory: EntityManagerFactory = Persistence.createEntityManagerFactory("alugames")
        return factory.createEntityManager()
    }


}