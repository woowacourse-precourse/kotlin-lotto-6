package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.text.DecimalFormat
import lotto.LottoPrize as LottoPrize

var MONEY: Int? = null
val LOTTOES = mutableListOf<Lotto>()
val NUMBERS = mutableSetOf<Int>()
var BONUS_NUMBER: Int? = null

fun main() {
    while (MONEY == null) inputMoney()
    makeLottoes()
    while (NUMBERS.size != 6) inputNumbers()
    while (BONUS_NUMBER == null) inputBonusNumber()
    countMatchedNumbers()
    countJackpot()
    showJackpotCount()
    showReturn()
}

fun inputMoney() {
    println("구입금액을 입력해 주세요.")
    val input = Console.readLine()
    try {
        checkMoney(input)
        MONEY = input.toInt()
        println()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}

fun checkMoney(tempMoney: String) {
    // Int형이거나, 1000 이상이거나, 1000으로 나누어 떨어지는지 확인
    if (tempMoney.toIntOrNull() == null || tempMoney.toInt() < 1000 || tempMoney.toInt() % 1000 != 0) {
        throwErrorMessage("1000원 이상 입력 및 1000원으로 나누어 떨어지게 하세요.")
    }
}

fun makeLottoes() {
    println("${MONEY!! / 1000}개를 구매했습니다.")
    for (i in 0 until (MONEY!! / 1000)) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        val lotto = Lotto(numbers)
        LOTTOES.add(lotto)
    }
    showLottoes()
    println()
}

fun showLottoes() {
    for (item in LOTTOES) {
        println(item.numberList)
    }
}

fun inputNumbers() {
    NUMBERS.clear()
    println("당첨 번호를 입력해 주세요.")
    val input = Console.readLine()
    try {
        val numbers = input.split(',').toSet()
        checkNumbersFirst(numbers)
        println()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}

fun checkNumbersFirst(numbers: Set<String>) {
    // 당첨번호가 서로 겹치지 않는지 확인
    if (numbers.size != 6) {
        throwErrorMessage("당첨번호는 겹치지 않는 번호 6개여야 합니다!")
    }

    numbers.map { number ->
        checkNumbersSecond(number)
    }
}

fun checkNumbersSecond(number: String) {
    // 당첨번호가 1~45 사이인지 확인
    if (number.toIntOrNull() == null || number.toInt() !in 1..45) {
        throwErrorMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }

    NUMBERS.add(number.toInt())
}

fun inputBonusNumber() {
    println("보너스 번호를 입력해 주세요.")
    val input = Console.readLine()
    try {
        checkBonusNumber(input)
        BONUS_NUMBER = input.toInt()
        println()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}

fun checkBonusNumber(number: String) {
    // Int형이거나, 1부터 45까지의 사이인지, 당첨번호와 겹치지 않는지
    if (number.toIntOrNull() == null || number.toInt() !in 1..45 || NUMBERS.contains(number.toInt())) {
        throwErrorMessage("보너스 번호는 1에서 45까지 당첨번호와 겹치지 말아야 합니다.")
    }
}

fun countMatchedNumbers() {
    for (item in LOTTOES) {
        item.matchingNumbers(NUMBERS)
        item.matchingBonusNumber(BONUS_NUMBER!!)
    }
}

// 당첨금 계산
fun countJackpot() {
    for (item in LOTTOES) {
        checkJackpot(item)
    }
}

fun checkJackpot(item: Lotto) {
    val matchedCount = item.matchedNumbersCount
    val matchedBonus = item.matchedBonusNumber
    when {
        matchedCount == LottoPrize.MATCHED3.matchedNumbers -> LottoPrize.MATCHED3.incrementCount()
        matchedCount == LottoPrize.MATCHED4.matchedNumbers -> LottoPrize.MATCHED4.incrementCount()
        matchedCount == LottoPrize.MATCHED5.matchedNumbers && matchedBonus == LottoPrize.MATCHED5.matchedBonus -> LottoPrize.MATCHED5.incrementCount()
        matchedCount == LottoPrize.MATCHED5_AND_BONUS.matchedNumbers && matchedBonus == LottoPrize.MATCHED5_AND_BONUS.matchedBonus -> LottoPrize.MATCHED5_AND_BONUS.incrementCount()
        matchedCount == LottoPrize.MATCHED6.matchedNumbers -> LottoPrize.MATCHED6.incrementCount()
    }
}

// 숫자를 천 단위로 끊어 주어 보여주는 함수
fun formatNumber(number: Int): String {
    return DecimalFormat("#,###").format(number)
}

// 당첨 횟수 출력
fun showJackpotCount() {
    println("당첨 통계")
    println("---")
    for (item in LottoPrize.entries) {
        println("${item.matchedNumbers}개 일치${if (item.matchedBonus) ", 보너스 볼 일치" else ""} (${formatNumber(item.prize)}원) - ${item.jackpot}개")
    }
}

// 수익률 출력
fun showReturn() {
    var prize = 0
    for (item in LottoPrize.entries) {
        prize += item.prize * item.jackpot
    }

    var roundedPercentage = (prize - MONEY!!) / MONEY!!.toDouble() * 100
    if (roundedPercentage < 0) roundedPercentage += 100

    println("총 수익률은 ${String.format("%.1f", roundedPercentage)}%입니다.")
}

fun throwErrorMessage(text: String) {
    throw IllegalArgumentException("[ERROR] $text")
}