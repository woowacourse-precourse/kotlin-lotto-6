package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.distinct().size == numbers.size) { "[ERROR] 로또 번호에 중복된 숫자가 있습니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}



enum class Rank(val matchCount: Int, val prize: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    fun getFormattedPrize(): String {
        return String.format("%,d", prize)
    }

    companion object {
        fun valueOf(matchCount: Int, matchBonus: Boolean): Rank {
            return when (matchCount) {
                6 -> FIRST
                5 -> if (matchBonus) SECOND else THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> MISS
            }
        }
    }
}

class WinningResult {
    private val result = mutableMapOf<Rank, Int>()

    fun add(rank: Rank) {
        result[rank] = result.getOrDefault(rank, 0) + 1
    }

    fun printResult() {
        println("당첨 통계")
        println("---------")
        val totalPrize = Rank.values().filter { it != Rank.MISS }.sumBy { rank ->
            val count = result.getOrDefault(rank, 0)
            if (rank == Rank.SECOND) {
                println("${rank.matchCount}개 일치, 보너스 볼 일치 (${rank.getFormattedPrize()}원) - ${count}개")
            } else {
                println("${rank.matchCount}개 일치 (${rank.getFormattedPrize()}원) - ${count}개")
            }
            rank.prize * count
        }
        val earningRate = totalPrize.toDouble() / (result.values.sum() * 1000) * 100
        println("총 수익률은 ${String.format("%.2f", earningRate)}%입니다.")
    }

    fun calculateEarningsRate(purchaseAmount: Int): Double {
        val totalPrize = result.entries.sumOf { (rank, count) -> rank.prize * count }
        return totalPrize.toDouble() / purchaseAmount * 100
    }
}



class WinningNumbers(numbers: List<Int>, val bonusNumber: Int) {
    val numbers = numbers.sorted()

    fun match(lotto: Lotto): Rank {
        var matchCount = 0
        var matchBonus = false

        lotto.getNumbers().forEach { number ->
            if (numbers.contains(number)) matchCount++
            if (number == bonusNumber) matchBonus = true
        }

        return Rank.valueOf(matchCount, matchBonus)
    }
}
