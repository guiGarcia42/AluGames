package br.com.alura.alugames.utilitario

import br.com.alura.alugames.dados.GamerEntity
import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.InfoGamerJson

//Extension functions para não ficar com o código poluido
fun InfoGamerJson.criarGamer(): Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario)
}

fun Gamer.toEntity(): GamerEntity{
    return GamerEntity(
        this.id,
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario,
        this.plano.toEntity())
}

fun GamerEntity.toModel(): Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario,
        this.id)
}