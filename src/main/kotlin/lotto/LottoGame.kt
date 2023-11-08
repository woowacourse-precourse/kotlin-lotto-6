package lotto

import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.round

class LottoGame {
    private val inputManager = InputManager(ExceptionManager())
    private val printManager = PrintManager()

    fun play() {
        printManager.inputMoney()
        val money = inputManager.money()

        val lottos = makeLottosByMoney(money)
        printManager.printLotto(lottos)

        printManager.inputWinningNumber()
        val winningNumber = inputManager.winningNum()

        printManager.inputBonusNumber()
        val bonusNumber = inputManager.bonusNum(winningNumber)

        val winningResult = compareLottos(lottos, winningNumber, bonusNumber)
        printManager.printResult(winningResult)

        val rateOfReturn = calculateRateOfReturn(winningResult, money)
        printManager.printRateOfReturn(rateOfReturn)
    }

    private fun makeLottosByMoney(money: Int): List<Lotto> {
        val lottoCount = money / Lotto.PRICE_PER_TICKET
        printManager.printLottoNumber(lottoCount)
        return List(lottoCount) { Lotto(getRandomNumbers().sorted()) }
    }

    private fun getRandomNumbers() = Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.NUMBERS_PER_TICKET)

    private fun compareLottos(lottos: List<Lotto>, winningNumber: Lotto, bonusNumber: Int): List<Int> {
        val countDuplicationNums = MutableList(CountDuplicationNumIndex.entries.size) { 0 }

        lottos.forEach { lotto ->
            val count = lotto.countDuplicateNumbers(winningNumber)
            val countIndex = when (count) {
                in 0..2 -> null
                3 -> CountDuplicationNumIndex.THREE
                4 -> CountDuplicationNumIndex.FOUR
                5 -> if (lotto.contains(bonusNumber)) CountDuplicationNumIndex.FIVE_BONUS else CountDuplicationNumIndex.FIVE
                6 -> CountDuplicationNumIndex.SIX
                else -> throw IllegalArgumentException("Invalid count: $count")
            }
            countIndex?.let {
                countDuplicationNums[it.ordinal]++
            }
        }

        return countDuplicationNums
    }

    private fun calculateRateOfReturn(result: List<Int>, money: Int): Double {
        val winningsByRank = listOf(5000, 50000, 1500000, 30000000, 2000000000)
        val winnings = result
                .mapIndexed{ index, it -> it * winningsByRank[index] }
                .sum()
        val rateOfReturn = (winnings / money.toDouble()) * 100
        return round(rateOfReturn * 10) / 10
    }
}