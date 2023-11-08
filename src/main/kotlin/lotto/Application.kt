package lotto

import camp.nextstep.edu.missionutils.Randoms
import java.io.Console
import java.util.logging.Logger
import kotlin.contracts.contract

fun main() {
    val lottos = inputAndBuyLottos()
    printLottoNum(lottos)
    val winningNum = inputWinnerNum()
    val bonusNum = inputBonusNum(winningNum)
    println("당첨 번호: $winningNum")

    lottos.forEach { lotto ->
        val lottoRank = checkLotto(lotto, winningNum, bonusNum)
        println("당신의 로또 번호는 ${lottoRank.name}이며, 상금은 ${lottoRank.prize}원 입니다.")
    }
}

enum class LottoRank(val matchNum: Int, val prize: Long) {
    FIRST(6,2_000_000_000),
    SECOND(5, 30_000_000), // bonus number match
    THIRD(5, 15_000_000), // without bonus number
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0,0);
}

fun findLottoRankByMatchCount(matchCount: Int, matchBonus: Boolean): LottoRank {
    return when {
        matchCount == 6 -> LottoRank.FIRST
        matchCount == 5 && matchBonus -> LottoRank.SECOND
        matchCount == 5 -> LottoRank.THIRD
        matchCount == 4 -> LottoRank.FOURTH
        matchCount == 3 -> LottoRank.FIFTH
        else -> LottoRank.NONE
    }
}

fun checkLotto(lotto: Lotto, winningNumbers: List<Int>, bonus:Int) : LottoRank {
    val matchCount = lotto.getMatchCount(winningNumbers)
    val matchBonus = lotto.contains(bonus)
    return findLottoRankByMatchCount(matchCount, matchBonus)
}
fun inputAndBuyLottos(): MutableList<Lotto> {
    while (true) {
        try {
            println("구입금액을 입력해 주세요.")
            val input = readLine() ?: throw IllegalArgumentException("[ERROR] 입력을 받지 못했습니다.")
            val money = ensureInt(input)
            val buyNum = ensureBuyNum(money)
            return buyLottos(buyNum)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun inputWinnerNum(): List<Int> {
    while (true) {
        try {
            return winnerNumInput()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun inputBonusNum(winningNumbers: List<Int>): Int {
    while (true) {
        try {
            return bonusNumInput(winningNumbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun winnerNumInput(): List<Int> {
    println("당첨 번호를 입력해 주세요.")
    val input = userInput()
    val numberList = input.split(",").map { it.trim()}

    if (numberList.size != 6) {
        throw IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야 합니다.")
    }

    val numbers = numberList.map {
        ensureInt(it)
    }

    if (numbers.any { it !in 1..45 }) {
        throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }

    return numbers
}

fun bonusNumInput(winningNumbers: List<Int>): Int {
    println("보너스 번호를 입력해 주세요")
    val input = userInput()
    val bonus = ensureInt(input)
    if (bonus !in 1..45 ) {
        throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }

    if (winningNumbers.contains(bonus)) {
        throw IllegalArgumentException("[ERROR] 당첨 번호와 중복될 수 없습니다.")
    }

    return bonus
}

fun printLottoNum(lottos: MutableList<Lotto>) {
    lottos.forEach { lotto ->
        println(lotto)
    }
}
fun buyLottos(buyNum: Int) : MutableList<Lotto> {
    val lottos = mutableListOf<Lotto>()

    repeat(buyNum) {
        val sortedNumbers = sortingNum(generateLottoNum())
        lottos.add(Lotto(sortedNumbers))
    }

    println("${buyNum}개를 구매했습니다.")

    return lottos
}
fun generateLottoNum(): List<Int> {
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    return numbers
}

fun sortingNum(numbers: List<Int>): List<Int> {
    return numbers.sorted()
}

fun ensureInt(input: String): Int {
    return input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.")
}

fun ensureBuyNum(money: Int): Int {
    if (money % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] 1,000원 단위로 입력해 주세요.")
    }
    return money / 1000
}

fun userInput(): String {
    return readLine() ?: throw IllegalArgumentException("[ERROR] 입력을 받지 못했습니다.")
}
