package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMaker {
    fun issueLotto(purchase: Int): List<Lotto> {
        val purchasedLotto = purchase / LOTTO_PRICE
        val issuedLotto = mutableListOf<Lotto>()
        for (i in 1..purchasedLotto) {
            val newLotto = makeNewLotto()
            issuedLotto.add(newLotto)
        }
        printIssuedLotto(issuedLotto)
        println()
        return issuedLotto
    }

    private fun printIssuedLotto(issuedLotto: List<Lotto>) {
        val purchasedLotto = issuedLotto.size
        println("${purchasedLotto}개를 구매했습니다.")
        for (lotto in issuedLotto) {
            println(lotto.getLottoNumber())
        }
    }

    private fun makeNewLotto(): Lotto {
        val randomLottoNumber = makeRandomLottoNumber()
        return Lotto(randomLottoNumber)
    }

    private fun makeRandomLottoNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_COUNT)
    }

    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
        const val LOTTO_COUNT = 6
        const val LOTTO_PRICE = 1000
    }
}