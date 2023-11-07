package lotto.domain.lotto.model

class Lotties {
    private val lotties: MutableList<Lotto> = mutableListOf()

    fun generateLotties(numberOfLottos: Int) {
        repeat(numberOfLottos) {
            val lotto = Lotto()
            lotties.add(lotto)
        }
    }

    fun printLotties() {
        lotties.forEach { println(it) }
    }
}
