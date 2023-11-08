package lotto.controller

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.util.Values
import lotto.model.Lotto
import lotto.util.Messages
import lotto.Validation.validateDuplicateBonusNumber
import lotto.Validation.validateDuplicateNumber
import lotto.Validation.validateWrongLengthNumber
import lotto.Validation.validateLottoNumber
import lotto.Validation.validateMoneyUnit
import lotto.Validation.validateOutOfRange
import lotto.model.Lotteries
import java.math.BigDecimal
import java.math.RoundingMode

class LottoController {

    private lateinit var lotteries: Lotteries
    private lateinit var winningLotto: MutableList<Int>

    private var bonusLottoNumber: Int = 0

    fun startLotto() {
        println(Messages.TEXT_INPUT_LOTTO_AMOUNT.message)
        inputLottoAmount()
        inputWinningLottoNumbers()
        inputBonusLottoNumber()
        printLottoResult()
    }

    private fun inputLottoAmount() {
        while (true) {
            try {
                val amount = Console.readLine()
                val num = checkLottoAmount(amount)
                createLotteries(num)
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun checkLottoAmount(amount: String): Long {
        val num = validateOutOfRange(amount)
        validateMoneyUnit(num)
        return num / 1000L
    }

    private fun createLotteries(num: Long) {
        println("\n$num" + Messages.TEXT_PRINT_LOTTO_NUM.message)
        val randomLotteries = mutableListOf<Lotto>()
        for (i in 1..num) {
            val numbers = Randoms.pickUniqueNumbersInRange(
                Values.VALUE_MIN_LOTTO_NUMBER.value.toInt(),
                Values.VALUE_MAX_LOTTO_NUMBER.value.toInt(),
                Values.VALUE_LOTTO_LENGTH.value.toInt()
            )
            numbers.sort()
            randomLotteries.add(Lotto(numbers))
        }
        lotteries = Lotteries(randomLotteries)
        lotteries.printLotteries()
    }

    private fun inputWinningLottoNumbers() {
        println("\n" + Messages.TEXT_INPUT_WINNING_LOTTO_NUMBER.message)
        while (true) {
            try {
                val numbers = Console.readLine()
                winningLotto = mutableListOf()
                numbers.split(",").forEach {
                    winningLotto.add(validateLottoNumber(it))
                }
                validateWrongLengthNumber(winningLotto)
                validateDuplicateNumber(winningLotto)
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun inputBonusLottoNumber() {
        println("\n" + Messages.TEXT_INPUT_BONUS_LOTTO_NUMBER.message)
        while (true) {
            try {
                val number = Console.readLine()
                bonusLottoNumber = validateLottoNumber(number)
                validateDuplicateBonusNumber(bonusLottoNumber, winningLotto)
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun printLottoResult() {
        println("\n" + Messages.TEXT_LOTTO_RESULT.message)

        val lottoResult = lotteries.compareLotteries(winningLotto, bonusLottoNumber)
        println(Messages.TEXT_LOTTO_MATCH_3.message + "${lottoResult[3] ?: 0}개")
        println(Messages.TEXT_LOTTO_MATCH_4.message + "${lottoResult[4] ?: 0}개")
        println(Messages.TEXT_LOTTO_MATCH_5.message + "${lottoResult[5] ?: 0}개")
        println(Messages.TEXT_LOTTO_MATCH_5_BONUS.message + "${lottoResult[50] ?: 0}개")
        println(Messages.TEXT_LOTTO_MATCH_6.message + "${lottoResult[6] ?: 0}개")

        val profit = calculatePrize(lottoResult, lotteries.size() * Values.VALUE_LOTTO.value)
        val roundedProfit = profit.setScale(1, RoundingMode.HALF_EVEN)
        println("총 수익률은 ${roundedProfit}%입니다.")
    }

    fun calculatePrize(lottoResult: Map<Int, Int>, expense: Long): BigDecimal {
        var prizeSum: Long = 0
        prizeSum += (lottoResult[3] ?: 0) * Values.VALUE_MATCH_THREE.value
        prizeSum += (lottoResult[4] ?: 0) * Values.VALUE_MATCH_FOUR.value
        prizeSum += (lottoResult[5] ?: 0) * Values.VALUE_MATCH_FIVE.value
        prizeSum += (lottoResult[50] ?: 0) * Values.VALUE_MATCH_FIVE_AND_BONUS.value
        prizeSum += (lottoResult[6] ?: 0) * Values.VALUE_MATCH_SIX.value
        return (prizeSum * Values.VALUE_PERCENT.value).toBigDecimal()
            .divide((expense).toBigDecimal(), 1, RoundingMode.HALF_EVEN)
    }
}