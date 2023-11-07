package lotto.domain.lotto.collection

import lotto.domain.lotto.Lotto

class LottoGame {
    private val lottos: MutableList<Lotto> = mutableListOf()

    fun generateLottos(numberOfLottos: Int) {
        repeat(numberOfLottos) {
            val lotto = Lotto()
            lottos.add(lotto)
        }
    }

    fun printLottos() {
        lottos.forEach { println(it) }
    }
}
