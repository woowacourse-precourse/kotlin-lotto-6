package lotto

import camp.nextstep.edu.missionutils.Randoms

class Game(
    private val calculator: Calculator = Calculator()
) {

    fun purchaseLotto(input: String): Int {
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

    private fun sortLotteryRandomNumber(numbers: List<Int>): List<Int> {
        return numbers.sorted()
    }

    fun inputUserPickNumbers(input: String): Lotto {
        val splitNumber = input.split(",")
        val numbers = mutableListOf<Int>()
        splitNumber.forEach {
            requireIsInt(it)
            numbers.add(it.toInt())
        }

        return Lotto(sortLotteryRandomNumber(numbers))
    }

    fun inputBonusNumber(input: String, userPickNumbers: List<Int>): Int {
        requireIsInt(input)
        val bonusNumber = input.toInt()
        requireDuplicateBonusNumber(bonusNumber, userPickNumbers)
        return input.toInt()
    }

    fun checkWinningDetails(lottery: List<Int>, userPickNumbers: List<Int>, bonusNumber: Int): WinCount {
        val matchingNumbers = userPickNumbers.intersect(lottery.toSet()).count()
        val bonusMatch = userPickNumbers.contains(bonusNumber)
        return WinCount(matchingNumbers, bonusMatch)
    }

    fun checkLottoWinType(winCounts: List<WinCount>): List<LottoWinType> {
        return winCounts.flatMap { winCount ->
            val count = if (winCount.bonusJudge) winCount.winningCount + 1 else winCount.winningCount
            when (count) {
                3 -> listOf(LottoWinType.THREE_MATCH)
                4 -> listOf(LottoWinType.FOUR_MATCH)
                5 -> listOf(LottoWinType.FIVE_MATCH_WITH_BONUS)
                6, 7 -> listOf(LottoWinType.SIX_MATCH)
                else -> emptyList()
            }
        }.toList()
    }

    private fun requireIsInt(input: String) {
        val number = input.toIntOrNull() ?: throw IllegalArgumentException()
        require(number > 0)
    }

    private fun requireDuplicateBonusNumber(bonusNumber: Int, userPickNumbers: List<Int>) {
        val uniqueNumbers = HashSet<Int>()
        for (number in userPickNumbers) {
            require(uniqueNumbers.add(number))
        }
        require(uniqueNumbers.add(bonusNumber))
    }

}