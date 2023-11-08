package lotto

import camp.nextstep.edu.missionutils.Randoms
import java.io.Console
import java.util.logging.Logger
import kotlin.contracts.contract

fun main() {
    val lottos = inputAndBuyLottos()
    printLottoNum(lottos)
    val winnerNum = inputWinnerNum()
    println("당첨 번호: $winnerNum")
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

fun winnerNumInput(): List<Int> {
    println("당첨 번호를 입력해 주세요.")
    var input = userInput()
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

    println("보너스 번호를 입력해 주세요")
    input = userInput()
    val bonus = ensureInt(input)
    if (bonus !in 1..45 ) {
        throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }

    if (numbers.contains(bonus)) {
        throw IllegalArgumentException("[ERROR] 당첨 번호와 중복될 수 없습니다.")
    }

    return numbers + bonus
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
