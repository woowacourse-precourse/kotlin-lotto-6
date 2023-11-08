package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    var purchaseAmountValidInput = false
    println("구입금액을 입력해 주세요.")
    var purchaseAmount = 0
    while (!purchaseAmountValidInput) {
        try {
            purchaseAmount = Console.readLine().toInt()
            purchaseAmountInputValidator(purchaseAmount)
            purchaseAmountValidInput = true
        } catch (e: NumberFormatException) {
            println("[ERROR] 구입금액은 숫자만 가능합니다. 다시 시도하세요.")
        } catch (e: IllegalArgumentException) {
            println("${e.message} 다시 시도하세요.")
        } catch (e: IllegalStateException) {
            println("${e.message} 다시 시도하세요.")
        }
    }
    val lottoQuantity = purchaseAmount / 1000
    println("${lottoQuantity}개를 구매했습니다.")

    val lottos = createLottos(lottoQuantity) // List<Lotto>
    for (i in lottos) {
        println(i.getLotto())
    }

    var winningNumValidInput = false
    println("당첨 번호를 입력해 주세요.")
    var winningNum: List<Int> = mutableListOf()
    while (!winningNumValidInput) {
        try {
            winningNum = Console.readLine().split(',').map { it.toInt() }
            winningNumInputValidator(winningNum)
            winningNumValidInput = true
        } catch (e: NumberFormatException) {
            println("[ERROR] 당첨번호는 숫자만 가능합니다. 다시 시도하세요.")
        } catch (e: IllegalArgumentException) {
            println("${e.message} 다시 시도하세요.")
        } catch (e: IllegalStateException) {
            println("${e.message} 다시 시도하세요.")
        }
    }

    var bonusNumValidInput = false
    println("보너스 번호를 입력해 주세요.")
    var bonusNum: Int = 0
    while (!bonusNumValidInput) {
        try {
            bonusNum = Console.readLine().toInt()
            bonusNumInputValidator(bonusNum, winningNum)
            bonusNumValidInput = true
        } catch (e: NumberFormatException) {
            println("[ERROR] 보너스번호는 숫자만 가능합니다. 다시 시도하세요.")
        } catch (e: IllegalArgumentException) {
            println("${e.message} 다시 시도하세요.")
        } catch (e: IllegalStateException) {
            println("${e.message} 다시 시도하세요.")
        }
    }

    val result = calculateWinningCounts(lottos, winningNum, bonusNum)
    result.printMatchingCounts()

    calculateProfitRate(result,purchaseAmount)
}

fun calculateProfitRate(result: WinningCounts,purchaseAmount:Int) {
    var profit = (result.threeMatching * 5000 + result.fourMatching * 50000 + result.fiveMatching * 1500000 + result.fivePlusBonusMatching * 30000000 + result.sixMatching * 2000000000).toDouble()
    var profitRate = profit/purchaseAmount*100
    println(String.format("총 수익률은 %.1f%%입니다.", profitRate))
}

fun calculateWinningCounts(lottos: List<Lotto>, winningNum: List<Int>, bonusNum: Int): WinningCounts {
    var matchingCounts = WinningCounts()

    for (lotto in lottos) {
        val matchedNumbers = lotto.getLotto().intersect(winningNum).toList()
        val bonusNumberMatched = lotto.getLotto().contains(bonusNum)

        when (matchedNumbers.size) {
            MatchingCount.THREE.value -> matchingCounts.threeMatching++
            MatchingCount.FOUR.value -> matchingCounts.fourMatching++
            MatchingCount.FIVE.value -> {
                if (bonusNumberMatched) {
                    matchingCounts.fivePlusBonusMatching++
                } else {
                    matchingCounts.fiveMatching++
                }
            }

            MatchingCount.SIX.value -> matchingCounts.sixMatching++
        }
    }

    return matchingCounts
}

enum class MatchingCount(val value: Int) {
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6)
}

data class WinningCounts(
    var threeMatching: Int = 0,
    var fourMatching: Int = 0,
    var fiveMatching: Int = 0,
    var sixMatching: Int = 0,
    var fivePlusBonusMatching: Int = 0
) {
    fun printMatchingCounts() {
        println("당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${threeMatching}개")
        println("4개 일치 (50,000원) - ${fourMatching}개")
        println("5개 일치 (1,500,000원) - ${fiveMatching}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${fivePlusBonusMatching}개")
        println("6개 일치 (2,000,000,000원) - ${sixMatching}개")

    }
}

fun purchaseAmountInputValidator(purchaseAmount: Int) {
    if (purchaseAmount < 0) throw IllegalArgumentException("[ERROR] 구입금액은 0 이상만 가능합니다.")
    if (purchaseAmount % 1000 != 0) throw IllegalArgumentException("[ERROR] 구입금액은 1000 단위만 가능합니다.")
}

fun winningNumInputValidator(winningNum: List<Int>) {
    if (winningNum.size != winningNum.distinct().size) throw IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.")
    if (winningNum.size != 6) throw IllegalArgumentException("[ERROR] 6개의 숫자가 아닙니다.")
}

fun bonusNumInputValidator(bonusNum: Int, winningNum: List<Int>) {
    if (bonusNum < 0 || bonusNum > 45) throw IllegalArgumentException("[ERROR] 보너스번호는 1~45까지만 가능합니다.")
    if (bonusNum in winningNum) throw IllegalArgumentException("[ERROR] 보너스번호는 당첨 번호에 없는 숫자만 가능합니다.")
}

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.distinct().size == 6)
    }

    fun getLotto(): List<Int> {
        return numbers.sorted()
    }
}

fun createLottos(lottoQuantity: Int): List<Lotto> {
    val lottos = mutableListOf<Lotto>()
    for (i in 1..lottoQuantity) {
        val lotto = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        lottos.add(lotto)
    }
    return lottos
}