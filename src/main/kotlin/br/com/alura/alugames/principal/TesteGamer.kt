import br.com.alura.alugames.modelo.Gamer

fun main(){
    val gamer1 = Gamer("Guilherme", "gui123.garcia@gmail.com")
    println(gamer1)

    val gamer2 = Gamer("Ingryd", "ingrdsouzah@gmail.com", "26/08/2003", "mariafuzil")
    println(gamer2)

    //Scope Functions
    gamer1.let {
        it.dataNascimento = "04/02/2002"
        it.usuario = "TR0PA"
    }

    println(gamer1)
}
