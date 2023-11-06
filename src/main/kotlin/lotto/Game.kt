package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Game {

    fun purchaseLotto(input: String): Int {
        val calculator = Calculator()
        requireIsInt(input)
        return calculator.calculateLottoAvailableForPurchase(input.toInt())
    }

    fun createLotteryRandomNumber(purchaseLottoNumber: Int): List<Lotto> {
        val lottery = mutableListOf<Lotto>()
        repeat(purchaseLottoNumber) {
            val numbers = sortLotteryRandomNumber(Randoms.pickUniqueNumbersInRange(1, 45, 6))
            lottery.add(Lotto(numbers))
        }
        return lottery
    }

    fun sortLotteryRandomNumber(numbers: List<Int>): List<Int> {
        return numbers.sorted()
    }

    fun inputUserPickNumbersS(input: String): Lotto {
        val splitNumber = input.split(",")
        val numbers = mutableListOf<Int>()
        splitNumber.forEach {
            requireIsInt(it)
            numbers.add(it.toInt())
        }

        return Lotto(numbers)
    }

    fun inputBonusNumber(input: String): Int {
        requireIsInt(input)
        return input.toInt()
    }

    private fun requireIsInt(input: String) {
        val number = input.toIntOrNull() ?: throw IllegalArgumentException()
        require(number > 0)
    }

}