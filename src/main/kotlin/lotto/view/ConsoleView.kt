package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto
import lotto.model.WinningCounts

class ConsoleView {
    fun promptPurchaseAmount(): Int {
        println(INPUT_PURCHASE_AMOUNT)
        var purchaseAmountValidInput = false
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
        return purchaseAmount
    }

    fun displayLottos(lottos: List<Lotto>) {
        lottos.forEach { println(it.getLotto()) }
    }

    fun promptWinningNumber(): List<Int> {
        println(INPUT_WINNING_NUM)
        var winningNumValidInput = false
        var winningNum: List<Int> = emptyList()
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
        return winningNum
    }

    fun promptBonusNumber(): Int {
        println(INPUT_BONUS_NUM)
        var bonusNumValidInput = false
        var bonusNum = 0
        while (!bonusNumValidInput) {
            try {
                bonusNum = Console.readLine().toInt()
                bonusNumInputValidator(bonusNum)
                bonusNumValidInput = true
            } catch (e: NumberFormatException) {
                println("[ERROR] 보너스번호는 숫자만 가능합니다. 다시 시도하세요.")
            } catch (e: IllegalArgumentException) {
                println("${e.message} 다시 시도하세요.")
            } catch (e: IllegalStateException) {
                println("${e.message} 다시 시도하세요.")
            }
        }
        return bonusNum
    }

    fun displayResult(result: WinningCounts) {
        println("당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${result.threeMatching}개")
        println("4개 일치 (50,000원) - ${result.fourMatching}개")
        println("5개 일치 (1,500,000원) - ${result.fiveMatching}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${result.fivePlusBonusMatching}개")
        println("6개 일치 (2,000,000,000원) - ${result.sixMatching}개")
    }

    fun displayProfitRate(profitRate: Double) {
        println(String.format("총 수익률은 %.1f%%입니다.", profitRate))
    }

    // Input validators
    private fun purchaseAmountInputValidator(purchaseAmount: Int) {
        if (purchaseAmount < 0) throw IllegalArgumentException("[ERROR] 구입금액은 0 이상만 가능합니다.")
        if (purchaseAmount % 1000 != 0) throw IllegalArgumentException("[ERROR] 구입금액은 1000 단위만 가능합니다.")
    }

    private fun winningNumInputValidator(winningNum: List<Int>) {
        if (winningNum.size != winningNum.distinct().size) throw IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.")
        if (winningNum.size != 6) throw IllegalArgumentException("[ERROR] 6개의 숫자가 아닙니다.")
    }

    private fun bonusNumInputValidator(bonusNum: Int) {
        if (bonusNum < 0 || bonusNum > 45) throw IllegalArgumentException("[ERROR] 보너스번호는 1~45까지만 가능합니다.")
    }
    companion object{
        const val INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
        const val INPUT_WINNING_NUM = "당첨 번호를 입력해 주세요."
        const val INPUT_BONUS_NUM = "보너스 번호를 입력해 주세요."
    }
}
