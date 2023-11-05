package lotto

import camp.nextstep.edu.missionutils.Randoms

/*
    구입금액을 입력해 주세요.
    8000

    8개를 구매했습니다.
    [8, 21, 23, 41, 42, 43]
    [3, 5, 11, 16, 32, 38]
    [7, 11, 16, 35, 36, 44]
    [1, 8, 11, 31, 41, 42]
    [13, 14, 16, 38, 42, 45]
    [7, 11, 30, 40, 42, 43]
    [2, 13, 22, 32, 38, 45]
    [1, 3, 5, 14, 22, 45]

    당첨 번호를 입력해 주세요.
    1,2,3,4,5,6

    보너스 번호를 입력해 주세요.
 */

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

fun makeLotto(number: Int) {
    val lottoList = mutableListOf<Lotto>()
    repeat(number) {
        lottoList.add(Lotto(makeNumbers()))
    }
    printLottoList(lottoList)
}

fun readPrice(): Int {
    println("구입금액을 입력해 주세요.")
    val input = readlnOrNull() ?: throw IllegalArgumentException("숫자가 입력되지 않았거나 올바르지 않은 형식입니다.")
    return input.toInt()
}

fun readWinningNumbers(): List<Int> {
    print("당첨 번호를 입력해 주세요.")
    val inputLine = readlnOrNull() ?: throw IllegalArgumentException("숫자가 입력되지 않았거나 올바르지 않은 형식입니다.")
    return inputLine.split(",").map { it.toInt() }
}

fun readBonusNumber(): Int {
    print("보너스 번호를 입력해 주세요.")
    val input = readlnOrNull() ?: throw IllegalArgumentException("숫자가 입력되지 않았거나 올바르지 않은 형식입니다.")
    return input.toInt()
}

fun main() {
    val price = readPrice()
    val bonusNumber = readBonusNumber()
    val winningNumbers = readWinningNumbers()

    makeLotto(price / 1000)
}