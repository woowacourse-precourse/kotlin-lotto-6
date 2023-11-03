package lotto
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    var amount = 0 // 구입 금액
    var lottoPurchaseCount = 0 // 로또 구매 장수

    while (true) {
        println("구입금액을 입력해주세요.")
        val purchaseAmount = Console.readLine()

        try {
            amount = purchaseAmount.toInt()

            if (amount < 1000) {
                throw IllegalArgumentException("[ERROR] 1000 이상의 금액을 입력하세요.")
            } else if (amount % 1000 != 0) {
                throw IllegalArgumentException("[ERROR] 1000으로 나누어 떨어지는 값을 입력하세요.")
            } else {
                break // Break out of the loop when valid input is provided
            }
        } catch (e: NumberFormatException) {
            println("[ERROR] 숫자를 입력하세요.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    lottoPurchaseCount = amount / 1000
    println("\n" + lottoPurchaseCount + "개를 구매했습니다.")

    val lottoPurchaseCounts = List(lottoPurchaseCount) { List(6) { 0 } }.toMutableList()
    for (i in 0 until lottoPurchaseCount){
        val randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        //Lotto(randomNumbers)
        lottoPurchaseCounts[i] = randomNumbers.sorted()
        println(randomNumbers.sorted())
    }

//    println("\n당첨 번호를 입력해 주세요.")
//    val winningLotteryNumbers = Console.readLine().split(',').map { it.toInt() }
//    Lotto(winningLotteryNumbers)
//    println(winningLotteryNumbers)


    var winningLotteryNumbers: List<Int> = mutableListOf()
    var validWinningNumbers = false

    while (!validWinningNumbers) {
        println("\n당첨 번호를 입력해 주세요.")
        val input = Console.readLine()
        try {
            winningLotteryNumbers = input.split(',').map { it.trim().toInt() }
            val lotto = Lotto(winningLotteryNumbers)
            validWinningNumbers = true
        } catch (e: NumberFormatException) {
            println("당첨 번호는 모두 숫자여야 합니다.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
    println(winningLotteryNumbers)
}
