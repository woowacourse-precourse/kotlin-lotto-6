package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.data.LottoData
import lotto.data.LottoMatchInfo
import lotto.domain.Lotto
import lotto.domain.WinningNumber
import lotto.domain.bonusValidation
import lotto.domain.purchaseAmountValidation
import lotto.model.PlayLottoState
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
    private val winningNumber: WinningNumber,
    private val lottoData: LottoData
) {

    fun start() {
        while (true) {
            lottoData.currentState = when (lottoData.currentState) {
                PlayLottoState.IDLE -> PlayLottoState.PURCHASE_AMOUNT
                PlayLottoState.PURCHASE_AMOUNT -> purchaseAmountProcess()
                PlayLottoState.WINNING_NUMBERS -> winningNumbersProcess()
                PlayLottoState.BONUS_NUMBER -> bonusNumberProcess()
                PlayLottoState.MATCHING -> matchingProcess()
                PlayLottoState.END -> {
                    printMatchResult()
                    return
                }
            }
        }
    }

    private fun purchaseAmountProcess(): PlayLottoState {
        println(ENTER_PURCHASE_AMOUNT_COMMENT)

        try {
            lottoData.purchaseAmount = inputPurchaseAmount()
            val lottoCount = lottoData.purchaseAmount.purchaseAmountToCount()
            println(lottoCountComment(lottoCount))
            lottoData.lotteries = lottoGenerator(lottoCount)
            return PlayLottoState.WINNING_NUMBERS
        } catch (illegalArgumentException: IllegalArgumentException) {
            println(illegalArgumentException.message)
        }

        return PlayLottoState.PURCHASE_AMOUNT
    }

    private fun winningNumbersProcess(): PlayLottoState {
        println(ENTER_WINNING_NUMBERS_COMMENT)

        try {
            lottoData.winningNumbers = inputWinningNumbers()
            return PlayLottoState.BONUS_NUMBER
        } catch (illegalArgumentException: IllegalArgumentException) {
            println(illegalArgumentException.message)
        }

        return PlayLottoState.WINNING_NUMBERS
    }

    private fun bonusNumberProcess(): PlayLottoState {
        println(ENTER_BONUS_NUMBERS_COMMENT)

        try {
            lottoData.bonusNumber = inputBonusNumbers()
            return PlayLottoState.MATCHING
        } catch (illegalArgumentException: IllegalArgumentException) {
            println(illegalArgumentException.message)
        }

        return PlayLottoState.BONUS_NUMBER
    }

    private fun matchingProcess(): PlayLottoState {
        lottoData.lotteries.map { numbers ->
            val lottoMatchInfo = Lotto(numbers).matchingLotto(lottoData.winningNumbers, lottoData.bonusNumber)
            addValueLottoResult(lottoMatchInfo)
        }
        return PlayLottoState.END
    }

    private fun addValueLottoResult(lottoMatchInfo: LottoMatchInfo) {
        lottoData.lottoResults = lottoData.lottoResults.map { lottoResult ->
            if (lottoResult.lottoMatchInfo == lottoMatchInfo) {
                lottoResult.copy(
                    value = lottoResult.value + 1
                )
            } else {
                lottoResult
            }
        }
    }

    private fun inputPurchaseAmount(): Double {
        val userInput = Console.readLine()
        return userInput.also { it.purchaseAmountValidation() }.toDouble()
    }

    private fun Double.purchaseAmountToCount() = this.toInt() / LOTTO_PRISE

    private fun inputWinningNumbers(): List<Int> {
        val userInput = Console.readLine()
        return winningNumber.userInputToWinningNumber(userInput)
    }

    private fun inputBonusNumbers(): Int {
        val userInput = Console.readLine()
        return userInput.also { it.bonusValidation(lottoData.winningNumbers) }.toInt()
    }

    private fun printMatchResult() {
        println(WINNING_STATS_COMMENT)

        lottoData.lottoResults.forEach { lottoResult ->
            val value = lottoResult.value
            val comment = lottoResult.lottoMatchInfo.comment
            println(comment(value))
        }

        print(totalRateComment(calculationTotalRate()))
    }

    private fun calculationTotalRate(): String {
        val winnings = lottoData.lottoResults.sumOf { it.value * it.lottoMatchInfo.prise }
        return calculateLottoROI(lottoData.purchaseAmount, winnings)
    }
}
