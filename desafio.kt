enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }
class Usuario(val nome:String, val id: Long)
data class Modulo(val nome: String, val Cursos:List<Curso>)
data class Curso(val nome: String, val nivel: Nivel, val duracao: Int = 60)
fun MutableList<Usuario>.getNames (): String {
    val nomes = this.map { it.nome } // Extrai os nomes dos objetos
    return nomes.joinToString(", ")
}

data class Formacao(val nome: String, val modulos: List<Modulo>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    override fun toString(): String {
        return "${nome} possui ${inscritos.size} alunos inscritos, que são ${inscritos.getNames()}"
    }
}

fun main() {
    val curso1 = Curso("Apresentação da Formação JavaScript Developer", Nivel.BASICO, 60)
    val curso2 = Curso("Conhecendo Funções JavaScript", Nivel.INTERMEDIARIO, 60)
    val modulo1 = Modulo("Aprenda a Programar do Zero com JavaScript", listOf(curso1, curso2))
    val curso3 = Curso("Introdução ao Desenvolvimento Web com JavaScript", Nivel.BASICO, 60)
    val curso4 = Curso("Dominando o Protocolo HTTP e Integrando com a PokeAPI", Nivel.INTERMEDIARIO, 240)
    val modulo2 = Modulo("JavaScript para Web: Fundamentos de HTML, CSS e APIs na Prática", listOf(curso3, curso4))
    val curso5 = Curso("Orientação a Protótipo com JavaScript", Nivel.AVANCADO, 120)
    val curso6 = Curso("Funções e Manipulação de Listas com JavaScript", Nivel.AVANCADO, 60)
    val modulo3 = Modulo("Dominando Conceitos Avançados em JavaScript", listOf(curso5, curso6))
    val javascript = Formacao("Formação JavaScript Developer", listOf(modulo1, modulo2, modulo3))
    val davis = Usuario("Davis", 11201810412)
    val elen = Usuario("Elen", 11201910413)
    javascript.matricular(davis)
    javascript.matricular(elen)
    print(javascript)
}
