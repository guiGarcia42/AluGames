package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Jogo
import javax.persistence.EntityManager

//Passamos quem gerencia a base de dados para quem estiver usando a classe, assim não precisamos
// abrir e fecha-lo em cada método
class JogosDAO(val manager: EntityManager) {

    fun getJogos(): List<Jogo> {
        // Mesma lógica da conexao, mas usando o hibernate
        // val manager = Banco.getEntityManager()
        val query = manager.createQuery("FROM JogoEntity", JogoEntity::class.java) //digita o nome da Classe
        return query.resultList.map { entity ->
            Jogo(
                entity.titulo,
                entity.capa,
                entity.preco,
                entity.descricao,
                entity.id
            )
        }
    }

    fun adicionarJogos(jogo: Jogo) {
        val entity = JogoEntity(jogo.titulo,jogo.capa,jogo.preco,jogo.descricao)
        //enviando as infos para o banco
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

//    fun getJogos(): List<Jogo> {
//        val listaJogos = mutableListOf<Jogo>()
//        val conexao = Banco.obterConexao()
//
//        if (conexao != null) {
//            try {
//                val statement = conexao.createStatement()
//                val resultado = statement.executeQuery("SELECT * FROM JOGOS")
//
//                while (resultado.next()) {
//                    val id = resultado.getInt("id")
//                    val titulo = resultado.getString("titulo")
//                    val capa = resultado.getString("capa")
//                    val descricao = resultado.getString("descricao")
//                    val preco = resultado.getBigDecimal("preco")
//
//                    val jogo = Jogo(titulo, capa, preco, descricao, id)
//                    listaJogos.add(jogo)
//                }
//
//                statement.close()
//            } finally {
//                conexao.close()
//            }
//        }
//        return listaJogos
//    }
//
//    fun adicionarJogo(jogo: Jogo) {
//        val conexao = Banco.obterConexao()
//        val insert = "INSERT INTO JOGOS (TITULO, CAPA, PRECO, DESCRICAO) VALUES (?, ?, ?, ?)"
//
//        if (conexao != null) {
//            try {
//                val statement = conexao.prepareStatement(insert)
//                statement.setString(1, jogo.titulo)
//                statement.setString(2, jogo.capa)
//                statement.setBigDecimal(3, jogo.preco)
//                statement.setString(4, jogo.descricao)
//
//                statement.executeUpdate()
//                statement.close()
//
//            }finally {
//                conexao.close()
//            }
//        }
//    }
}