package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoManager {
    private val myLotto = mutableListOf<Lotto>()

    private fun generateNewLotto(): Lotto {
        val numbers = generateRandomNumbers()
        return Lotto(numbers.sorted())
    }

    private fun generateRandomNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }


    fun getLotto(): List<Lotto> {
        return myLotto
    }

    fun generateLotto() {
        val newLotto = generateNewLotto()
        myLotto.add(newLotto)
    }
}