package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import constants.Constants
import constants.Exception


class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {Exception.LOTTO_NUMBER_SIZE_ERROR}
        require(numbers.toSet().size == numbers.size) {Exception.LOTTO_NUMBER_DUPLICATE_ERROR}
        require(numbers.all{ it in 1..45}) {Exception.LOTTO_NUMBER_RANGE_ERROR}
    }
    private fun getPurchaseAmount(): Int {
        while (true) {
            try {
                println(Constants.INPUT_PURCHASE_PRICE)
                return checkPurchasePrice()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun checkPurchasePrice(): Int {
        while (true) {
            try {
                val input = Console.readLine().toInt()
                if (input % 1000 != 0) {
                    throw IllegalArgumentException(Exception.PURCHASE_AMOUNT_UNIT_ERROR)
                }
                return input
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException(Exception.PURCHASE_AMOUNT_NUMBER_ERROR)
            }
        }
    }

    fun getLottoNumbers(): List<List<Int>> {
        val purchaseAmount = getPurchaseAmount()
        val numOfTickets = purchaseAmount / 1000
        val tickets = mutableListOf<List<Int>>()

        println("\n${numOfTickets}개를 구매했습니다.")

        for (i in 1..numOfTickets) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            hasDuplicateNumbers(numbers)
            tickets.add(numbers)
            println(numbers)
        }
        return tickets
    }

    private fun hasDuplicateNumbers(numbers: List<Int>) {
        if (numbers.size != numbers.toSet().size || numbers.size != 6) {
            throw IllegalArgumentException(Exception.INVALID_ERROR)
        }
    }

    internal fun getWinningNumbers(): List<Int> {
        while (true) {
            try {
                println(Constants.INPUT_WINNING_NUMBER)
                val userNumbers = getUserNumbers()
                if (userNumbers.toSet().size != 6) {
                    println(Exception.INVALID_ERROR)
                    continue
                }
                return userNumbers
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getUserNumbers(): List<Int> {
        val winningNumbers = Console.readLine()
        return winningNumbers.split(",").map { it.toInt() }
    }

    internal fun getBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            try {
                println(Constants.INPUT_BONUS_NUMBER)
                val userBonusNumber = getUserBonusNumber()
                if (userBonusNumber !in 1..45 || userBonusNumber in winningNumbers) {
                    println(Exception.INVALID_BONUS_NUMBER_ERROR)
                    continue
                }
                return userBonusNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getUserBonusNumber(): Int {
        return Console.readLine().toInt()
    }

    internal fun showWinningNumbers(tickets: List<List<Int>>, winningNumbers: List<Int>, bonusNumber: Int) {
        val matchingNumbers: List<Int> = tickets.map { ticket ->
            ticket.count { it in winningNumbers }
        }
        val hasBonusNumbers = bonusNumbers(tickets, winningNumbers, bonusNumber)

        println(Constants.WINNING_STATS)
        println(Constants.LINE)
        println("${Constants.CORRECT_3}${matchingNumbers.count { it == 3 }}개")
        println("${Constants.CORRECT_4}${matchingNumbers.count { it == 4 }}개")
        println("${Constants.CORRECT_5}${matchingNumbers.count { it == 5 }}개")
        println("${Constants.CORRECT_5_BONUS}${hasBonusNumbers.count { it == 5 }}개")
        println("${Constants.CORRECT_6}${matchingNumbers.count { it == 6 }}개")
        println("${Constants.TOTAL}${calculateProfit(matchingNumbers)}${Constants.PROFIT}")
    }

    private fun bonusNumbers(tickets: List<List<Int>>, winningNumbers: List<Int>, bonusNumber: Int): List<Int> {
        val hasBonusNumbers = tickets.map { ticket ->
            if (ticket.contains(bonusNumber)) {
                winningNumbers.intersect(ticket.toSet()).count() - 1
            } else {
                winningNumbers.intersect(ticket.toSet()).count()
            }
        }
        return hasBonusNumbers
    }

    private fun calculateProfit(matchingNumbers: List<Int>): String {
        val lottoPurchaseAmount = matchingNumbers.size * 1000

        val prizeMap = mapOf(
            3 to Constants.MATCH_3_PRIZE,
            4 to Constants.MATCH_4_PRIZE,
            5 to Constants.MATCH_5_PRIZE,
            5 to Constants.MATCH_5_WITH_BONUS_PRIZE,
            6 to Constants.MATCH_6_PRIZE
        )

        val totalPrize = matchingNumbers.mapNotNull { prizeMap[it] }.sum()
        val totalCost = lottoPurchaseAmount.toDouble()
        val profitPercentage = (totalPrize / totalCost) * 100

        return "%.1f".format(profitPercentage)
    }
}

