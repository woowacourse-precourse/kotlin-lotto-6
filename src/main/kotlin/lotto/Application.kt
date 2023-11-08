package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("구입금액을 입력해 주세요.")

    try {
        //발행한 로또 수량 출력
        val purchaseAmount = getValidPurchaseAmount()
        val purchasedTickets = generateLottoTickets(purchaseAmount)
        println("${purchasedTickets}개를 구매했습니다.")

        // 발행한 로또 번호 출력
        val lottoTickets = mutableListOf<Lotto>()

        for (i in 1..purchasedTickets) {
            val randomNumbers = generateRandomNumbers()
            if (randomNumbers is IllegalArgumentException) {
                println("애플리케이션을 종료합니다.")
                return
            }
            System.out.println(randomNumbers)
            val lotto = Lotto(randomNumbers)
            lottoTickets.add(lotto)
        }

        for (lotto in lottoTickets) {
            println(lotto.printNumbers())
        }

        //당첨 번호와 보너스 번호 입력
        val winningNumbers = getWinningNumbers() //당첨 번호
        val bonusNumber = getBonusNumber() // 보너스번호

        // 당첨 번호와 보너스 번호를 기반으로 당첨 결과 출력
        val winningStatistics = WinningStatistics(winningNumbers, bonusNumber)
        val totalPrize = winningStatistics.calculateTotalPrize(lottoTickets)
        val winningRate = winningStatistics.calculateWinningRate(purchaseAmount, totalPrize)


        println("당첨 통계")
        for (index in WinningPrize.values().filter{ it != WinningPrize.NONE }) {
            val prize = index.prize
            // 여기서 "i" 대신 "prizeCase"의 ordinal 값을 사용하여 일치하는 숫자 개수를 가져옵니다.
            val bonusMatchedCount = lottoTickets.count { it.containsNumber(bonusNumber)}

            val count = if (index == WinningPrize.FIVE_MATCH && bonusMatchedCount > 0) {
                0 // 만족하는 경우 count를 0으로 설정
            } else {
                lottoTickets.count { it.getMatchedNumbers(winningNumbers) == index.ordinal + 2 }
            }

            if(index == WinningPrize.FIVE_MATCH_WITH_BONUS) {
                println("5개 일치, 보너스 볼 일치 (${winningStatistics.getPrizeString(prize)}) - ${count}개")
                continue
            }
            if(index.ordinal+2 == 7)
                print("${index.ordinal + 1 }개 일치")
            else {
                print("${index.ordinal + 2 }개 일치")
            }
            println(" (${winningStatistics.getPrizeString(prize)}) - ${count}개")



        }

        println("총 수익률은 ${winningRate}%입니다.")

    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}

fun generateRandomNumbers(): List<Int> { // 사용자 로또 생성
    val randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    val generateResults = isValidNumbers(randomNumbers)
    if (generateResults is IllegalArgumentException) {
        throw IllegalArgumentException("랜덤 숫자가 유효하지 않습니다.")
    }

    return randomNumbers
}
fun isValidNumbers(numbers: List<Int>): List<Int> {
    if (numbers.any { it < 1 || it > 45 } || numbers.toSet().size != 6) {
        throw IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    }
    return numbers
}
fun getValidPurchaseAmount(): Int { // 로또 구입 금액 및 유효성 검사
    try {
        val input = Console.readLine()
        val purchaseAmount = input.toInt()

        if (purchaseAmount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.")
        }

        return purchaseAmount
    } catch (e: NumberFormatException) {
        println("[ERROR] 유효하지 않은 숫자를 입력했습니다. 다시 입력하세요.")
    }
    return 0
}

fun generateLottoTickets(purchaseAmount: Int): Int {
    return purchaseAmount / 1000
}

fun getWinningNumbers(): List<Int> {
    println("당첨 번호를 입력해 주세요.")
    while (true) {
        try {
            val input = Console.readLine()
            val numbers = input.split(",").map { it.trim().toInt() }

            if (numbers.size != 6 || numbers.any { it < 1 || it > 45 }) {
                println("[ERROR] 1에서 45 사이의 6개 번호를 중복되지 않게 입력해야 합니다.")
            } else if (numbers.toSet().size != 6) {
                println("[ERROR] 중복된 번호가 있습니다. 중복되지 않은 번호 6개를 입력해야 합니다.")
            } else {
                return numbers
            }
        } catch (e: NumberFormatException) {
            println("[ERROR] 유효하지 않은 숫자를 입력했습니다. 다시 입력하세요.")
        }
    }
}

fun getBonusNumber(): Int {
    println("보너스 번호를 입력해 주세요.")
    try {
        val input = Console.readLine()
        val bonusNumber = input.toInt()
        if (bonusNumber < 1 || bonusNumber > 45) {
            println("[ERROR] 1에서 45 사이의 번호를 입력하세요.")
        } else {
            return bonusNumber
        }
    } catch (e: NumberFormatException) {
        println("[ERROR] 유효하지 않은 숫자를 입력했습니다. 다시 입력하세요.")
    }
    return 0
}