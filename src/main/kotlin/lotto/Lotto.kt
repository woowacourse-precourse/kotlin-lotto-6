package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.NumberFormatException

class Lotto(private val numbers: List<Int>) {
    private var lottoPurchaseAmount: Int = 0
    private var lottoTickets: List<List<Int>> = emptyList()
    private var winningNumbers: List<Int> = emptyList()
    private var bonusNumber: Int = 0

    init {
        require(numbers.size == 6) {"로또 번호는 6개여야 합니다."}
        require(numbers.toSet().size == numbers.size) {"로또 번호에 중복된 숫자가 있으면 안됩니다."}
        require(numbers.all{ it in 1..45}) {"로또 번호는 1부터 45사이의 숫자여야한다."}
    }

    private fun getPurchaseAmount(): Int {
        while (true) {
            try {
                println("구입금액을 입력해 주세요.")
                lottoPurchaseAmount = checkPurchasePrice()
                return lottoPurchaseAmount
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
                    throw IllegalArgumentException("[ERROR] 구입 금액의 단위는 1,000원 단위입니다.")
                }
                return input
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다. 구입 금액은 숫자여야 합니다.")
            }
        }
    }

    fun getLottoNumbers() {
        val lottoPurchaseAmount = getPurchaseAmount()
        val numOfTickets = lottoPurchaseAmount / 1000
        val tickets = mutableListOf<List<Int>>()

        println("\n${numOfTickets}개를 구매했습니다.")

        for (i in 1..numOfTickets) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            hasDuplicateNumbers(numbers)
            tickets.add(numbers)
            println(numbers)
        }
        lottoTickets = tickets
    }

    private fun hasDuplicateNumbers(numbers: List<Int>) {
        if (numbers.size != numbers.toSet().size || numbers.size != 6) {
            throw IllegalArgumentException("[ERROR] 1부터 45 사이의 6개의 서로 다른 숫자를 입력해야 합니다.")
        }
    }

    fun getWinningNumbers() {
        while (true) {
            try {
                println("\n당첨 번호를 입력해 주세요.")
                val userNumbers = getUserNumbers()
                if (userNumbers.toSet().size != 6) {
                    println("[ERROR] 1부터 45 사이의 6개의 서로 다른 숫자를 입력해야 합니다.")
                    continue
                }
                this.winningNumbers = userNumbers
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getUserNumbers(): List<Int> {
        val winningNumbers = Console.readLine()
        return winningNumbers.split(",").map { it.toInt() }
    }


    fun getBonusNumber() {
        while (true) {
            try {
                println("\n보너스 번호를 입력해 주세요.")
                val userBonusNumber = getUserBonusNumber()
                if (userBonusNumber !in 1..45 || userBonusNumber in winningNumbers) {
                    println("[ERROR] 1부터 45 사이의 숫자이며, 당첨 번호와 겹치지 않는 숫자를 입력해야 합니다.")
                    continue
                }
                this.bonusNumber = userBonusNumber
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getUserBonusNumber(): Int {
        return Console.readLine().toInt()
    }

    fun showWinningNumbers() {
        val matchingNumbers: List<Int> = lottoTickets.map { ticket ->
            ticket.count { it in winningNumbers }
        }
        val hasBonusNumbers = bonusNumbers()

        println("\n당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${matchingNumbers.count { it == 3 }}개")
        println("4개 일치 (50,000원) - ${matchingNumbers.count { it == 4 }}개")
        println("5개 일치 (1,500,000원) - ${matchingNumbers.count { it == 5 }}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${hasBonusNumbers.count { it == 5 }}개")
        println("6개 일치 (2,000,000,000원) - ${matchingNumbers.count { it == 6 }}개")
        println("총 수익률은 ${calculateProfit(matchingNumbers)}%입니다.")
    }

    private fun bonusNumbers(): List<Int> {
        val hasBonusNumbers = lottoTickets.map { ticket ->
            if (ticket.contains(bonusNumber)) {
                winningNumbers.intersect(ticket.toSet()).count() - 1
            } else {
                winningNumbers.intersect(ticket.toSet()).count()
            }
        }
        return hasBonusNumbers
    }

    private fun calculateProfit(matchingNumbers: List<Int>): String {
        val match3Numbers = 5000.0
        val match4Numbers = 50000.0
        val match5Numbers = 1500000.0
        val match5NumbersWithBonus = 30000000.0
        val match6Numbers = 2000000000.0

        val prizeMap = mapOf(
            3 to match3Numbers,
            4 to match4Numbers,
            5 to match5Numbers,
            5 to match5NumbersWithBonus,
            6 to match6Numbers
        )

        val totalPrize = matchingNumbers.mapNotNull { prizeMap[it] }.sum()
        val totalCost = lottoPurchaseAmount.toDouble()
        val profitPercentage = (totalPrize / totalCost) * 100

        return "%.1f".format(profitPercentage)
    }
}
