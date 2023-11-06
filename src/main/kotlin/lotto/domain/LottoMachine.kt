package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    fun issueLottos(inputMoney: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()

        repeat(inputMoney / 1000) {
            lottos.add(createLotto())
        }
        return lottos.toList()
    }

    private fun createLotto(): Lotto {
        return Lotto(generateNumbers())
    }

    private fun generateNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}