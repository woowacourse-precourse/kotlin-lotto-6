package lotto
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

enum class WinningResult(val matchCount: Int, val prize: Long, val description: String) {
    NONE(0, 0, "0개 일치"),
    THREE(3, 5000, "3개 일치"),
    FOUR(4, 50000, "4개 일치"),
    FIVE(5, 1500000, "5개 일치"),
    FIVE_WITH_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치"),
    SIX(6, 2000000000, "6개 일치")
}
class LottoGame {
    private val tickets = mutableListOf<Lotto>()
    private var purchasePrice: Int = 0
    private var winningNumbers: List<Int> = emptyList()
    private var bonusNumber: Int = 0

    fun purchaseTickets(price: Int) {
        purchasePrice = price
        val lottoCount = price / 1000
        for (i in 1..lottoCount) {
            val randomNumbers = (1..45).shuffled().take(6)
            val lotto = Lotto(randomNumbers)
            tickets.add(lotto)
        }
    }

    fun drawWinningNumbers(numbers: List<Int>, bonus: Int) {
        winningNumbers = numbers
        bonusNumber = bonus
    }

    fun findWinners(): List<Lotto> {
        return tickets.filter { it.checkWinningNumbers(winningNumbers, bonusNumber) != WinningResult.NONE }
    }

    fun calculateTotalPrize(): Long {
        val results = tickets.groupingBy { it.checkWinningNumbers(winningNumbers, bonusNumber) }
            .eachCount()

        var totalPrize: Long = 0
        for ((result, count) in results) {
            totalPrize += result.prize * count
        }
        return totalPrize
    }

    fun getTickets(): List<Lotto> {
        return tickets
    }

    fun getPurchasePrice(): Int {
        return purchasePrice
    }

    fun getWinningNumbers(): List<Int> {
        return winningNumbers
    }

    fun getBonusNumber(): Int {
        return bonusNumber
    }
}

fun main() {
    val lottoGame = LottoGame()

    println("구입금액을 입력해 주세요.")
    val purchasePrice = readPurchasePrice()
    lottoGame.purchaseTickets(purchasePrice)

    val tickets = lottoGame.getTickets()
    displayPurchasedTickets(tickets)

    println("\n당첨 번호를 입력해 주세요.")
    val winningNumbers = readWinningNumbers()

    println("\n보너스 번호를 입력해 주세요.")
    val bonusNumber = readBonusNumber()

    lottoGame.drawWinningNumbers(winningNumbers, bonusNumber)
    val winners = lottoGame.findWinners()
    val totalPrize = lottoGame.calculateTotalPrize()
    displayWinningResults(lottoGame,winners, totalPrize)

    //val lottoNumbers= Lotto(listOf())
}
fun readPurchasePrice(): Int {
    val input = Console.readLine().toInt()
    if (input % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] 로또 1장의 가격은 1,000원입니다.")
    }
    return input
}

fun displayPurchasedTickets(tickets: List<Lotto>) {
    println("\n${tickets.size}개를 구매했습니다.")
    tickets.forEach { println(it) }
}

fun readWinningNumbers(): List<Int> {
    val input = Console.readLine().split(",").map { it.trim().toInt() }
    if (input.size != 6 || input.any { it !in 1..45 }) {
        throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }
    return input
}

fun readBonusNumber(): Int {
    val input = Console.readLine().toInt()
    if (input !in 1..45) {
        throw IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
    }
    return input
}
fun Long.format(): String {
    return "%,d".format(this)
}
fun displayWinningResults(lottoGame: LottoGame, winners: List<Lotto>, totalPrize: Long) {
    println("\n당첨 통계\n---")
    val winningNumbers = lottoGame.getWinningNumbers()
    val bonusNumber = lottoGame.getBonusNumber()
    WinningResult.values().forEach {
        val count = winners.count()
        val prize = it.prize
        println("${it.description} (${prize.format()}원) - ${count}개")
    }
    val purchasePrice = lottoGame.getPurchasePrice()
    val profitRate = if (purchasePrice == 0) 0.0 else (totalPrize.toDouble() / purchasePrice.toDouble()) * 100.0
    val profitRateFormatted = String.format("%.2f", profitRate)
    println("총 수익률은 $profitRateFormatted%입니다.")
}