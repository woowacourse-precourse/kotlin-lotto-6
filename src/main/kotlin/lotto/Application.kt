package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    var purchaseAmount: Int? = null
    while (purchaseAmount == null) {
        try {
            println("구입금액을 입력해 주세요.")
            purchaseAmount = Console.readLine().toInt()
            require(purchaseAmount % 1000 == 0) { "[ERROR] 구입 금액은 1000원 단위여야 합니다." }
        } catch (e: Exception) {
            println(e.message)
            purchaseAmount = null
        }
    }

    val lottoCount = purchaseAmount / 1000
    println("$lottoCount"+"개를 구매했습니다.")
    val lottos = (1..lottoCount).map { Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)) }
    lottos.forEach { lotto -> println(lotto.getNumbers().sorted()) } // 로또 번호를 오름차순으로 정렬하여 출력


    var winningNumberList: List<Int>? = null
    while (winningNumberList == null) {
        try {
            println("당첨 번호를 입력해 주세요.")
            winningNumberList = Console.readLine().split(",").map { it.toInt() }
            require(winningNumberList.size == 6) { "[ERROR] 당첨 번호는 6개여야 합니다." }
            require(winningNumberList.distinct().size == winningNumberList.size) { "[ERROR] 당첨 번호에 중복된 숫자가 있습니다." }
            require(winningNumberList.all { it in 1..45 }) { "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다." }
        } catch (e: Exception) {
            println(e.message)
            winningNumberList = null
        }
    }

    var bonusNumber: Int? = null
    while (bonusNumber == null) {
        try {
            println("보너스 번호를 입력해 주세요.")
            bonusNumber = Console.readLine().toInt()
            require(bonusNumber in 1..45) { "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다." }
            require(bonusNumber !in winningNumberList) { "[ERROR] 보너스 번호가 당첨 번호와 중복됩니다." }
        } catch (e: Exception) {
            println(e.message)
            bonusNumber = null
        }
    }

    val winningNumbers = WinningNumbers(winningNumberList, bonusNumber)

    val winningResult = WinningResult()
    lottos.forEach { lotto ->
        val rank = winningNumbers.match(lotto)
        winningResult.add(rank)
    }

    winningResult.printResult()
    println("총 수익률은 ${winningResult.calculateEarningsRate(purchaseAmount)}%입니다.")
}
