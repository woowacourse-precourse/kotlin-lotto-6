import camp.nextstep.edu.missionutils.Console
import lotto.domain.Lotto
import lotto.domain.WinningNumber
import lotto.domain.bonusValidation
import lotto.domain.purchaseAmountValidation
import lotto.model.LottoResult
import lotto.model.PlayLottoState
import lotto.model.PlayLottoState.State
import lotto.resources.Comment.ENTER_BONUS_NUMBERS_COMMENT
import lotto.resources.Comment.ENTER_PURCHASE_AMOUNT_COMMENT
import lotto.resources.Comment.ENTER_WINNING_NUMBERS_COMMENT
import lotto.resources.Comment.WINNING_STATS_COMMENT
import lotto.resources.Comment.lottoCountComment
import lotto.resources.Comment.totalRateComment
import lotto.resources.Lotto.LOTTO_PRISE
import lotto.utils.calculateLottoROI
import lotto.utils.lottoGenerator

class PlayLotto(
    private val winningNumber: WinningNumber = WinningNumber(),
    private val lottoData: PlayLottoState.LottoData
) {

    fun start() {
        while (true) {
            lottoData.currentState = when (lottoData.currentState) {
                State.IDLE -> State.PURCHASE_AMOUNT
                State.PURCHASE_AMOUNT -> purchaseAmountProcess()
                State.WINNING_NUMBERS -> winningNumbersProcess()
                State.BONUS_NUMBER -> bonusNumberProcess()
                State.MATCHING -> matchingProcess()
                State.END -> {
                    printMatchResult()
                    return
                }
            }
        }
    }

    private fun printMatchResult() {
        println(WINNING_STATS_COMMENT)

        LottoResult.entries.forEach { matchCount ->
            println(matchCount.comment(matchCount.value))
        }

        print(totalRateComment(calculationTotalRate()))
    }

    private fun calculationTotalRate(): String {
        val winnings = LottoResult.entries.sumOf { it.value * it.prise }
        return calculateLottoROI(lottoData.purchaseAmount, winnings)
    }

    private fun purchaseAmountProcess(): State {
        println(ENTER_PURCHASE_AMOUNT_COMMENT)

        try {
            lottoData.purchaseAmount = inputPurchaseAmount()
            val lottoCount = purchaseAmountToCount(lottoData.purchaseAmount)
            println(lottoCountComment(lottoCount))
            lottoData.lotteries = lottoGenerator(lottoCount)
            return State.WINNING_NUMBERS
        } catch (illegalArgumentException: IllegalArgumentException) {
            println(illegalArgumentException.message)
        }

        return State.PURCHASE_AMOUNT
    }

    private fun winningNumbersProcess(): State {
        println(ENTER_WINNING_NUMBERS_COMMENT)

        try {
            lottoData.winningNumbers = inputWinningNumbers()
            return State.BONUS_NUMBER
        } catch (illegalArgumentException: IllegalArgumentException) {
            println(illegalArgumentException.message)
        }

        return State.WINNING_NUMBERS
    }

    private fun bonusNumberProcess(): State {
        println(ENTER_BONUS_NUMBERS_COMMENT)

        try {
            lottoData.bonusNumber = inputBonusNumbers()
            return State.MATCHING
        } catch (illegalArgumentException: IllegalArgumentException) {
            println(illegalArgumentException.message)
        }

        return State.BONUS_NUMBER
    }

    private fun matchingProcess(): State {
        lottoData.lotteries.map { numbers ->
            Lotto(numbers).matchingLotto(lottoData.winningNumbers, lottoData.bonusNumber)
        }
        return State.END
    }

    private fun inputPurchaseAmount(): Double {
        val userInput = Console.readLine()
        return userInput.also { it.purchaseAmountValidation() }.toDouble()
    }

    private fun purchaseAmountToCount(purChaseAmount: Double) = purChaseAmount.toInt() / LOTTO_PRISE

    private fun inputWinningNumbers(): List<Int> {
        val userInput = Console.readLine()
        return winningNumber.userInputToWinningNumber(userInput)
    }

    private fun inputBonusNumbers(): Int {
        val userInput = Console.readLine()
        return userInput.also { it.bonusValidation(lottoData.winningNumbers) }.toInt()
    }
}