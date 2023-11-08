package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.enums.LottoResult
import lotto.messages.LogicMessage

object LottoLogic {

    fun getLottoPurchaseAmount(): Int {
        return LottoUserInput.getPurchaseAmountInput()
    }

    fun createLotto(lottoCount: Int): List<Lotto> {
        return (0 until lottoCount).map {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            Lotto(numbers)
        }
    }

    fun printLotto(lotto: List<Lotto>) {
        printLottoCount(lotto.size)
        lotto.forEach {
            println(it)
        }
    }

    private fun printLottoCount(lottoCount: Int) {
        println(lottoCount.toString() + LogicMessage.PURCHASED_LOTTO_COUNT)
    }

    fun getWinningNumbers(): List<Int> {
        return LottoUserInput.getWinningNumbers()
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        return LottoUserInput.getBonusNumber(winningNumbers)
    }

    fun calculateLottoResults(lotto: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<LottoResult, Int> {
        val results = lotto.map {
            it.calculateLottoResult(winningNumbers, bonusNumber)
        }
        return results.groupingBy { it }.eachCount()
    }

    fun printLottoResultMessages(lottoResult: Map<LottoResult, Int>) {
        calculateLottoResultMessages(lottoResult).forEach { message ->
            println(message)
        }
    }

    fun calculateLottoResultMessages(lottoResults: Map<LottoResult, Int>): List<String> {
        return listOf(
            LottoResult.FIFTH,
            LottoResult.FOURTH,
            LottoResult.THIRD,
            LottoResult.SECOND,
            LottoResult.FIRST
        ).map { result ->
            val count = lottoResults[result] ?: 0
            result.toString(count)
        }
    }

    fun printLottoReturnRate(purchaseAmount: Int, lottoResults: Map<LottoResult, Int>) {
        val returnRate = calculateLottoReturnRate(purchaseAmount, lottoResults)
        println(LogicMessage.LOTTO_RETURN_RATE.format(returnRate))
    }

    fun calculateLottoReturnRate(purchaseAmount: Int, lottoResults: Map<LottoResult, Int>): Double {
        val winningAmount = lottoResults.map { (result, count) ->
            result.winningPrice * count
        }.sum()
        // 문제 조건에 따라 원금을 벌었을 때의 수익률을 100%로 가정하여 계산
        return winningAmount.toDouble() / purchaseAmount * 100
    }

}