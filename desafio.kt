enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Aluno(val nome: String, val matricula: String) {
    override fun toString(): String {
        return "$nome - matricula: $matricula"
    }
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60) {
    override fun toString(): String {
        return "$nome: duracao $duracao horas"
    }
}

data class Formacao(
    val nome: String,
    val nivel: Nivel,
    var conteudos: List<ConteudoEducacional>
) {

    val inscritos = mutableListOf<Aluno>()

    fun matricular(vararg alunos: Aluno) {
        inscritos.addAll(alunos)
    }

    override fun toString(): String {
        return """
            Nome: $nome
            Nivel: $nivel
            Conteudo Educacional: $conteudos
            Alunos matriculados: $inscritos
            
        """.trimIndent()
    }
}

fun main() {
    val jose = Aluno("Jose", "2022001")
    val caio = Aluno("Caio", "2022002")
    val raquel = Aluno("Raquel", "2022003")
    val bruno = Aluno("Bruno", "2022004")

    val logicaDeProgrmacao = ConteudoEducacional("Logica de Programacao", 80)
    val poo = ConteudoEducacional("POO", 80)
    val java = ConteudoEducacional("Java")
    val kotlin = ConteudoEducacional("Kotlin", 120)


    val desenvolvedorMobile = Formacao(
        "Desenvolvedor Mobile",
        Nivel.BASICO,
        listOf(logicaDeProgrmacao, poo, kotlin)
    )

    val desenvolvedorBackEnd = Formacao(
        "Desenvolvedor BackEnd",
        Nivel.INTERMEDIARIO,
        listOf(logicaDeProgrmacao, poo, java)
    )

    desenvolvedorMobile.matricular(jose, caio, bruno)
    desenvolvedorBackEnd.matricular(bruno, raquel)

    println(desenvolvedorMobile)
    println(desenvolvedorBackEnd)
}