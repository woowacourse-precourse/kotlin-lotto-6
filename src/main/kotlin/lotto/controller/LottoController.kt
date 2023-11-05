package lotto.controller

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto
import lotto.Messages
import lotto.Validation.validateMoneyUnit
import lotto.Validation.validateOutOfRange
import lotto.model.Lotteries

class LottoController {

    private lateinit var lotteries: Lotteries
    private lateinit var winningLottoNumbers: MutableList<Int>

    private var bonusLottoNumber: Int = 0

    fun startLotto() {
        println(Messages.TEXT_INPUT_LOTTO_AMOUNT.message)
        inputLottoAmount()
        inputWinningLottoNumbers()
        inputBonusLottoNumber()
    }

    private fun inputLottoAmount() {
        while (true) {
            try {
                val amount = Console.readLine()
                val num = validateLottoAmount(amount)
                createLotteries(num)
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun validateLottoAmount(amount: String): Long {
        val num = validateOutOfRange(amount)
        validateMoneyUnit(num)
        return num / 1000L
    }

    private fun createLotteries(num: Long) {
        println("\n$num" + Messages.TEXT_PRINT_LOTTO_NUM.message)
        val randomLotteries = mutableListOf<Lotto>()
        for (i in 1..num) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            numbers.sort()
            randomLotteries.add(Lotto(numbers))
        }
        lotteries = Lotteries(randomLotteries)
        lotteries.printLotteries()
    }

    private fun inputWinningLottoNumbers() {
        println("\n" + Messages.TEXT_INPUT_WINNING_LOTTO_NUMBER.message)
        val numbers = Console.readLine()
        numbers.split(",").forEach {
            winningLottoNumbers.add(it.toInt())
        }
    }

    private fun inputBonusLottoNumber() {
        println("\n" + Messages.TEXT_INPUT_BONUS_LOTTO_NUMBER.message)
        bonusLottoNumber = Console.readLine().toInt()
    }
}