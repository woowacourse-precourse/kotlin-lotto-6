package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    TODO("프로그램 구현")
}

fun getPurchaseAmount(): Int {
    try {
        println("구입금액을 입력해 주세요.")
        val purchaseAmount = Console.readLine()?.toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해 주세요.")
        if (purchaseAmount <= 0) {
            throw IllegalArgumentException("구입 금액은 양수여야 합니다.")
        }
        if (purchaseAmount % 1000 != 0) {
            throw IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야 합니다.")
        }
        return purchaseAmount
    } catch (e: IllegalArgumentException) {
        println("[ERROR] ${e.message}")
        return getPurchaseAmount()
    }
}

fun generateTicket(): Lotto {
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    return Lotto(numbers)
}

fun getWinningNumbers(): Lotto {
    while (true) {
        try {
            println("\n당첨 번호를 입력해 주세요.")
            val input = Console.readLine() ?: throw IllegalArgumentException("숫자를 입력해 주세요.")
            val numbers = input.split(',').map { it.toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해 주세요.") }
            validateNumbers(numbers)
            return Lotto(numbers)
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
        }
    }
}

fun validateNumbers(numbers: List<Int>) {
    if (numbers.any { it !in 1..45 }) {
        throw IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다.")
    }
    if (numbers.size != 6) {
        throw IllegalArgumentException("로또 번호는 6개여야 합니다.")
    }
    if (numbers.distinct().size != 6) {
        throw IllegalArgumentException("로또 번호는 중복될 수 없습니다.")
    }
}

fun getBonusNumber(winningNumbers: Lotto): Int {
    while (true) {
        try {
            println("\n보너스 번호를 입력해 주세요.")
            val input = Console.readLine() ?: throw IllegalArgumentException("숫자를 입력해 주세요.")
            val bonusNumber = input.toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해 주세요.")
            validateBonusNumber(bonusNumber, winningNumbers)
            return bonusNumber
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
        }
    }
}

fun validateBonusNumber(bonusNumber: Int, winningNumbers: Lotto) {
    if (bonusNumber !in 1..45) {
        throw IllegalArgumentException("보너스 번호는 1~45 사이의 숫자여야 합니다.")
    }
    if (winningNumbers.contains(bonusNumber)) {
        throw IllegalArgumentException("보너스 번호가 당첨 번호와 중복됩니다.")
    }
}

fun printResults(ticketCount: Int, winningNumbers: Lotto, bonusNumber: Int, earningsRate: Double, countByRank: Map<Rank, Int>) {
    println("\n당첨 통계")
    println("---")
    Rank.values().filter { it != Rank.MISS }.forEach { rank ->
        printRankResult(rank, countByRank[rank] ?: 0)
    }
    println("총 수익률은 ${earningsRate}%입니다.")
}


fun printRankResult(rank: Rank, count: Int) {
    if (rank == Rank.SECOND) {
        println("${rank.matchCount}개 일치, 보너스 볼 일치 (${rank.getFormattedPrize()}원) - ${count}개")
    } else {
        println("${rank.matchCount}개 일치 (${rank.getFormattedPrize()}원) - ${count}개")
    }
}

enum class Rank(val matchCount: Int, val prize: Int) {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    MISS(0, 0);

    fun getFormattedPrize(): String {
        return String.format("%,d", prize)
    }
    companion object {
        fun valueOf(matchCount: Int, matchBonus: Boolean): Rank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && matchBonus -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> MISS
            }
        }
    }
}