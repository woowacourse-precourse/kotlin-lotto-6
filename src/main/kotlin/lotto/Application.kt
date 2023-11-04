package lotto
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.reflect.typeOf

fun main() {
    var amount = 0 // 구입 금액
    var lottoPurchaseCount = 0 // 로또 구매 장수
    var lottoNumberMatch = 0
    var totalPrize = 0
    var prizeCounts = IntArray(5) { 0 }
    var rateOfReturn = 0
    var purchaseAmount = 0

    while (true) {
        println("구입금액을 입력해주세요.")
        purchaseAmount = Console.readLine().toInt()

        try {

            if (purchaseAmount < 1000) {
                throw IllegalArgumentException("[ERROR] 1000 이상의 금액을 입력하세요.")
            } else if (purchaseAmount % 1000 != 0) {
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

    lottoPurchaseCount = purchaseAmount / 1000
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
            println("[ERROR] 당첨 번호는 모두 숫자여야 합니다.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
    //println(winningLotteryNumbers)

    var bonusNumber: Int = 0
    var validBonusNumber = false

    while (!validBonusNumber) {
        println("\n보너스 번호를 입력해 주세요.")
        val bonusInput = Console.readLine()
        try {
            bonusNumber = bonusInput.trim().toInt()
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자만 입력하세요.")
            }
            if (winningLotteryNumbers.contains(bonusNumber)) {
                throw IllegalArgumentException("[ERROR] 기존 당첨 번호에 이미 같은 값이 있습니다.")
            }
            validBonusNumber = true
        } catch (e: NumberFormatException) {
            println("[ERROR] 보너스 번호는 숫자여야 합니다.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    for (i in 0 until lottoPurchaseCount) {
        val union = lottoPurchaseCounts[i] + winningLotteryNumbers
        val intersection = union.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct()
        lottoNumberMatch = intersection.size
        val bonusNumberMatch = lottoPurchaseCounts[i].contains(bonusNumber)
        if (bonusNumberMatch && lottoNumberMatch != 5) {
            lottoNumberMatch += 1
        }

        when {
            lottoNumberMatch == 6 -> {
                totalPrize += 2000000000
                prizeCounts[4]++
            }
            lottoNumberMatch == 5 && bonusNumberMatch -> {
                totalPrize += 30000000
                prizeCounts[3]++
            }
            lottoNumberMatch == 5 -> {
                totalPrize += 1500000
                prizeCounts[2]++
            }
            lottoNumberMatch == 4 -> {
                totalPrize += 50000
                prizeCounts[1]++
            }
            lottoNumberMatch == 3 -> {
                totalPrize += 5000
                prizeCounts[0]++
            }
        }

    }
    val prizeDescriptions = listOf(
            "3개 일치 (5,000원)",
            "4개 일치 (50,000원)",
            "5개 일치 (1,500,000원)",
            "5개 일치, 보너스 볼 일치 (30,000,000원)",
            "6개 일치 (2,000,000,000원)"
    )

    println("\n당첨 통계\n---")
    for (i in 0 until prizeCounts.size) {
        println("${prizeDescriptions[i]} - ${prizeCounts[i]}개")
    }


}
