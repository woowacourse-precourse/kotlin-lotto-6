package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val money = purchaseLotto()
    val lottos = purchaseLottos(money)
    val (winningNumbers, bonusNumber) = winningNumbers()
    val matchCounts = lottos.map { it.countMatch(winningNumbers, bonusNumber) }
    readNumber(matchCounts)
}

fun purchaseLotto(): Int {
    println("구입금액을 입력해 주세요.")
    val input = Console.readLine().toIntOrNull()
    requireNotNull(input) { throw IllegalArgumentException("[ERROR] 숫자를 입력해주세요.") }
    require(input % 1000 == 0) { throw IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.") }
    return input
}

fun purchaseLottos(money: Int): List<Lotto> {
    val numLottos = money / 1000
    println("${numLottos}개를 구매했습니다.")
    val lottos = List(numLottos) { Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)) }
    lottos.forEach { lotto ->
        println(lotto)
    }
    return lottos
}

fun winningNumbers(): Pair<List<Int>, Int> {
    println("당첨 번호를 입력해 주세요.")
    val winningNumbers = Console.readLine()?.replace(" ", "")?.split(",")?.map { it.toInt() }
    requireNotNull(winningNumbers) { throw IllegalArgumentException("[ERROR] 1부터 45까지 중복되지 않는 숫자 6개를 입력해주세요.") }
    require(winningNumbers.size == 6) { throw IllegalArgumentException("[ERROR] 1부터 45까지 중복되지 않는 숫자 6개를 입력해주세요.") }
    return winningNumbers to readBonusNumber()
}

fun readBonusNumber(): Int {
    while (true) {
        try {
            println("보너스 번호를 입력해 주세요.")
            val bonusNumber = Console.readLine().toInt()
            require(bonusNumber in 1..45) { "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다." }
            return bonusNumber
        } catch (e: NumberFormatException) {
            println("[ERROR] 보너스 번호는 숫자로 입력해주세요.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}



fun readNumber(matchCounts: List<Prize>) {
    println("당첨 통계")
    println("---")
    val groupedResults = matchCounts.groupBy { it }
    Prize.values().forEach {
        val count = groupedResults[it]?.size ?: 0
        if (count > 0) {
            val prizeName = "${it.matchCount}개 일치"
            val prizeMoney = it.prizeMoney
            println("$prizeName (${prizeMoney}원) - ${count}개")
        }
    }
    val totalPrize = matchCounts.sumBy { it.prizeMoney }
    val purchasePrice = matchCounts.size * 1_000
    val earningRate = if (purchasePrice != 0) Math.round((totalPrize.toDouble() / purchasePrice) * 1000) / 10F else 0.0F
    println("총 수익률은 %.1f%%입니다.".format(earningRate))
}
