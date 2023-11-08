package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.enums.LottoResult
import lotto.messages.LogicMessage

object LottoLogic {

    fun getLottoPurchasePrice(): Int {
        return LottoUserInput.getPurchasePriceInput()
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

}