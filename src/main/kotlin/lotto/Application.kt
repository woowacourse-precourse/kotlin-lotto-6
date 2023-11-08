package lotto

import camp.nextstep.edu.missionutils.Randoms
import java.io.Console
import java.util.logging.Logger
import kotlin.contracts.contract

fun main() {
    println("구입금액을 입력해 주세요.")
    var money: Int
    var buyNum: Int
    var input: String
    var lottos = mutableListOf<Lotto>()

    while (true) {
        try {
            input = userInput()
            money = ensureInt(input)
            buyNum = ensureBuyNum(money)
            println("${buyNum}개를 구매했습니다.")
            lottos = buyLottos(buyNum)
            printLottoNum(lottos)


            break // If no error occurs, exit the loop
        } catch (e: IllegalArgumentException) {
            println(e.message) // Print the error message and prompt again
        }
    }
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
