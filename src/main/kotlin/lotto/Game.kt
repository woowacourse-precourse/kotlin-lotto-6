package lotto

import camp.nextstep.edu.missionutils.Randoms

class Game(
    private val calculator: Calculator = Calculator()
) {

    fun purchaseLotto(input: String): Int {
        requireIsInt(input)
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

    private fun sortNumbers(numbers: List<Int>): List<Int> {
        return numbers.sorted()
    }

    fun inputUserPickNumbers(input: String): List<Int> {
        val splitNumber = input.trim().split(",")
        val numbers = mutableListOf<Int>()
        splitNumber.forEach {
            requireIsInt(it)
            numbers.add(it.toInt())
        }
        require(numbers.size == 6)
        requireDuplicateLottoNumber(numbers = numbers)
        requireValidRange(numbers = numbers)
        return numbers
    }

    fun inputBonusNumber(input: String, userPickNumbers: List<Int>): Int {
        requireIsInt(input)
        val bonusNumber = input.toInt()
        requireDuplicateBonusNumber(userPickNumbers, bonusNumber)
        return input.toInt()
    }

    fun checkWinningDetails(lottery: List<Lotto>, userPickNumbers: List<Int>, bonusNumber: Int): List<WinCount> {
        val winCounts = mutableListOf<WinCount>()
        lottery.forEach { lotto ->
            winCounts.add(lotto.checkMatchWinCount(userPickNumbers, bonusNumber))
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

    private fun requireIsInt(input: String) {
        val number = input.toIntOrNull() ?: throw IllegalArgumentException()
        require(number > 0)
    }

    private fun requireDuplicateBonusNumber(numbers: List<Int>, bonusNumber: Int) {
        val uniqueNumbers = HashSet<Int>()
        for (number in numbers) {
            require(uniqueNumbers.add(number))
        }
        require(uniqueNumbers.add(bonusNumber))
    }

    private fun requireDuplicateLottoNumber(numbers: List<Int>) {
        val uniqueNumbers = HashSet<Int>()
        for (number in numbers) {
            require(uniqueNumbers.add(number)) {Message.ERROR_USER_PICK_NUMBERS_DUPLICATION}
        }
    }

    private fun requireValidRange(numbers: List<Int>) {
        for (number in numbers) {
            require(number in VALID_RANGE)
        }
    }

    companion object {
        const val START_NUMBER = 1
        const val END_NUMBER = 45
        const val NUMBER_COUNT = 6
        val VALID_RANGE = 1..45
    }

}