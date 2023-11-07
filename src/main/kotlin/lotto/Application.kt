package lotto

import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.round


val PRIZE = arrayOf(0, 2_000_000_000, 30_000_000, 1_500_000, 50_000, 5_000)

/**
 * 복권 번호 생성
 */
fun makeNumbers(): MutableList<Int> {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6)
}


fun printLottoList(lottoList: List<Lotto>) {
    for (lotto in lottoList) {
        lotto.printLottoNumbers()
    }
}

fun makeLotto(number: Int): MutableList<Lotto> {
    val lottoList = mutableListOf<Lotto>()
    println("${number}개를 구매했습니다.")
    repeat(number) {
        lottoList.add(Lotto(makeNumbers()))
    }
    printLottoList(lottoList)
    return lottoList
}

fun readPrice(): Int {
    var intValue: Int

    while (true) {
        try {
            println("구입금액을 입력해 주세요.")
            val input = readlnOrNull() ?: throw IllegalArgumentException("숫자가 입력되지 않았거나 올바르지 않은 형식입니다.")

            if (!input.all { item -> item.isDigit() }) {
                throw IllegalArgumentException("숫자가 입력되지 않았거나 올바르지 않은 형식입니다.")
            }
            intValue = input.toInt()
            if (intValue % 1000 != 0) {
                throw IllegalArgumentException("올바르지 않은 수입니다.")
            }
            break
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e}")
        }
    }

    return intValue
}

fun readWinningNumbers(): List<Int> {
    var answer: List<Int>

    while (true) {
        try {
            println("당첨 번호를 입력해 주세요.")
            val inputLine = readlnOrNull() ?: throw IllegalArgumentException("숫자가 입력되지 않았거나 올바르지 않은 형식입니다.")
            val splited = inputLine.split(",")
            for (item in splited) {
                if (!item.all { elem -> elem.isDigit() }) {
                    throw IllegalArgumentException("숫자가 입력되지 않았거나 올바르지 않은 형식입니다.")
                }
            }
            val numberSet: Set<String> = splited.toSet()
            if (numberSet.size != splited.size) {
                throw IllegalArgumentException("중복된 숫자가 있습니다.")
            }
            answer = splited.map { it.toInt() }
            break
        } catch (e: IllegalArgumentException) {
            println("[ERROR]${e}")
        }
    }
    return answer
}

fun readBonusNumber(winningNumbers: List<Int>): Int {
    var answer: Int
    while (true) {
        try {
            println("보너스 번호를 입력해 주세요.")
            val input = readlnOrNull() ?: throw IllegalArgumentException("숫자가 입력되지 않았거나 올바르지 않은 형식입니다.")
            if (!input.all { item -> item.isDigit() }) {
                throw IllegalArgumentException("숫자가 입력되지 않았거나 올바르지 않은 형식입니다.")
            }
            if (winningNumbers.contains(input.toInt())) {
                throw IllegalStateException("중복된 숫자가 있습니다.")
            }
            answer = input.toInt()
            break
        } catch (e: IllegalArgumentException) {
            println("[ERROR]${e}")
        } catch( e: IllegalStateException) {
            println("[ERROR]${e}")
        }
    }
    return answer
}


fun printLotteryResult(price: Int, winningPrize: Int, winning: Array<Int>) {
    println("3개 일치 (5,000원) - ${winning[5]}개")
    println("4개 일치 (50,000원) - ${winning[4]}개")
    println("5개 일치 (1,500,000원) - ${winning[3]}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winning[2]}개")
    println("6개 일치 (2,000,000,000원) - ${winning[1]}개")
    println("총 수익률은 ${round(winningPrize.toDouble() / price * 100 * 10) / 10.0}%입니다.")
}

fun getLotteryPrize(lottos: List<Lotto>, price: Int, winningNumbers: List<Int>, bonusNumber: Int) {
    val winning = Array(6) { 0 }
    var winningPrize = 0

    for (lotto in lottos) {
        winning[lotto.getLotteryOutcome(winningNumbers, bonusNumber)] += 1
        winningPrize += lotto.winningPrize
    }

    printLotteryResult(price, winningPrize, winning)
}

fun main() {
    val price = readPrice()
    val winningNumbers = readWinningNumbers()
    val bonusNumber = readBonusNumber(winningNumbers)

    val lottos = makeLotto(price / 1000)
    getLotteryPrize(lottos, price, winningNumbers, bonusNumber)
}