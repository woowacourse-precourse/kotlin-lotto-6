package lotto

import camp.nextstep.edu.missionutils.Randoms

class Controller(
    private val calculator: Calculator = Calculator()
) {

    fun purchaseLotto(input: String): Int {
        requireIsInt(input)
        requireMoreThanThousand(input)
        val purchaseCost = input.toInt()
        return calculator.calculateLottoAvailableForPurchase(purchaseCost)
    }

    fun createLotteryRandomNumber(purchaseNumber: Int): List<Lotto> {
        val lottery = mutableListOf<Lotto>()
        repeat(purchaseNumber) {
            val numbers =
                sortNumbers(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT))
            lottery.add(Lotto(numbers))
        }
        return lottery
    }

    fun createLottoWinningNumbers(userPickInput: String, bonusInput: String): LottoWinningNumbers {
        val splitNumber = userPickInput.trim().split(",")
        val userPickNumbers = mutableListOf<Int>()
        splitNumber.forEach {
            requireIsInt(it)
            userPickNumbers.add(it.toInt())
        }
        requireIsInt(bonusInput)
        val bonusNumber = bonusInput.toInt()
        return LottoWinningNumbers(userPickNumbers, bonusNumber)
    }

    fun checkWinningDetails(lottery: List<Lotto>, lottoWinningNumbers: LottoWinningNumbers): List<WinCount> {
        val winCounts = mutableListOf<WinCount>()
        lottery.forEach { lotto ->
            winCounts.add(lotto.checkMatchWinCount(lottoWinningNumbers))
        }
        return winCounts
    }

    fun checkLottoWinType(winCounts: List<WinCount>): List<LottoWinType> {
        return winCounts.flatMap { winCount ->
            val count = if (winCount.bonusJudge) winCount.winningCount + 1 else winCount.winningCount
            when (count) {
                3 -> listOf(LottoWinType.THREE_MATCH)
                4 -> listOf(LottoWinType.FOUR_MATCH)
                5 -> if (winCount.bonusJudge) listOf(LottoWinType.FIVE_MATCH_WITH_BONUS)
                else listOf(LottoWinType.FIVE_MATCH)

                6, 7 -> listOf(LottoWinType.SIX_MATCH)
                else -> emptyList()
            }
        }.toList()
    }

    fun checkYieldResult(types: List<LottoWinType>): String {
        return calculator.calculateYieldResult(types = types)
    }

    private fun sortNumbers(numbers: List<Int>): List<Int> {
        return numbers.sorted()
    }

    private fun requireIsInt(input: String) {
        require(input.matches(Regex(INTEGER_REGULAR_EXPRESSION))) { Message.ERROR_USER_INPUT_NOT_INT }
        require(input.toInt() > 0) { Message.ERROR_USER_INPUT_LESS_THAN_ZERO }
    }

    private fun requireMoreThanThousand(input: String) {
        require(input.toInt() >= 1000) { Message.ERROR_USER_INPUT_LESS_THAN_THOUSAND }
    }

    companion object {
        const val START_NUMBER = 1
        const val END_NUMBER = 45
        const val NUMBER_COUNT = 6
        const val INTEGER_REGULAR_EXPRESSION = "-?\\d+"
    }

}