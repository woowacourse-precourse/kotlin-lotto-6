package lotto

import camp.nextstep.edu.missionutils.Console

fun initializeLotto(): Tuple {
    var amount = 0
    var lottoPurchaseCount = 0
    val prizeCounts = IntArray(5)
    var totalPrize = 0
    var rateOfReturn = 0.0

    while (true) {
        println("구입금액을 입력해 주세요.")
        try {
            amount = Console.readLine().toInt()
            if (amount < 1000) {
                throw IllegalArgumentException("[ERROR] 1000 이상의 금액을 입력하세요.")
            } else if (amount % 1000 != 0) {
                throw IllegalArgumentException("[ERROR] 1000으로 나누어 떨어지는 값을 입력하세요.")
            } else {
                break
            }
        } catch (e: NumberFormatException) {
            println("[ERROR] 숫자를 입력하세요.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    lottoPurchaseCount = amount / 1000
    println("\n${lottoPurchaseCount}개를 구매했습니다.")
    return Tuple(amount, lottoPurchaseCount, prizeCounts, totalPrize, rateOfReturn)
}