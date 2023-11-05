package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val money = getInputMoney()
    val lottoCount = money / 1000
    println("${lottoCount}개를 구매했습니다.")

    val lottos = (1..lottoCount).map { Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)) }
    lottos.forEach { println(it.getSortedNumbers()) }

    val winningNumbers = getWinningNumbers()
    val bonusNumber = getBonusNumber()

    val results = lottos.map { it.calculateResult(winningNumbers, bonusNumber) }
    // TODO: results를 이용해 당첨 통계를 출력.
}
fun getBonusNumber(): Int {
    println("보너스 번호를 입력해 주세요.")
    return readLine()!!.toInt()
}
fun getWinningNumbers(): List<Int> {
    println("당첨 번호를 입력해 주세요.")
    return readLine()!!.split(",").map { it.trim().toInt() }
}
fun getInputMoney(): Int {//구입금액 입력 받기
    var money = 0
    while (money == 0) {
        money = try {
            val input = readLine()!!
            validateMoney(input)
        } catch (e: Exception) {
            println("[ERROR] ${e.message}")
            0
        }
    }
    return money
}

fun validateMoney(input: String): Int {//입력값 검증
    val money = input.toInt()
    if (money % 1000 != 0) {
        throw IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야 합니다.")
    }
    return money
}