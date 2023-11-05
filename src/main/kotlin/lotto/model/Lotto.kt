package lotto.model

import lotto.domain.RandomGenerator

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun getLottoState(): List<Int> {
        return numbers
    }

    fun getWinningCount(winningLotto: Lotto): Int {
        var prizeCount = 0
        numbers.forEach {
            prizeCount += confirmPrizeNumbers(it, winningLotto)
        }
        return prizeCount
    }

    fun confirmBonusNumber(winningCount: Int, bonusNumber: Int): Boolean {
        if (winningCount == 5) {
            return numbers.contains(bonusNumber)
        }//이걸 여기서 하는게 맞을까?
        return false
    }

    private fun confirmPrizeNumbers(currentNum: Int, winningLotto: Lotto): Int {
        if (winningLotto.numbers.contains(currentNum)) {
            return 1
        }
        return 0
    }


    companion object {
        fun makeLotto(randomLottoGenerator: RandomGenerator): Lotto {
            return Lotto(randomLottoGenerator.pickNumberInRange(1, 45, 6))
        }
    }
}
