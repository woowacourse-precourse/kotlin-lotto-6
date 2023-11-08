package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.data.LottoData
import lotto.data.LottoWinnerInfo
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
import lotto.utils.calculateLottoCount
import lotto.utils.calculateLottoROI
import lotto.utils.lottoGenerator

class PlayLotto(
    private val winningNumber: WinningNumber,

) {

    private var lottoData : LottoData = LottoData()
    private var currentState : PlayLottoState = PlayLottoState.PURCHASE_AMOUNT

    fun start() {
        while (true) {
            when (currentState) {
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

    private fun purchaseAmountProcess() {
        println(ENTER_PURCHASE_AMOUNT_COMMENT)

        try {
            val purchaseAmount = inputPurchaseAmount()
            buyLotteries(purchaseAmount)
            currentState = PlayLottoState.WINNING_NUMBERS
        } catch (illegalArgumentException: IllegalArgumentException) {
            println(illegalArgumentException.message)
        }
    }

    private fun buyLotteries(purchaseAmount: Int) {
        val lottoCount = calculateLottoCount(purchaseAmount)
        println(lottoCountComment(lottoCount))
        val lotteries = lottoGenerator(lottoCount).onEach(::println)
        lottoData = lottoData.copy(
            purchaseAmount = purchaseAmount,
            lotteries = lotteries
        )
    }

    private fun winningNumbersProcess() {
        println(ENTER_WINNING_NUMBERS_COMMENT)

        try {
            lottoData = lottoData.copy(winningNumbers = inputWinningNumbers())
            currentState = PlayLottoState.BONUS_NUMBER
        } catch (illegalArgumentException: IllegalArgumentException) {
            println(illegalArgumentException.message)
        }
    }

    private fun bonusNumberProcess() {
        println(ENTER_BONUS_NUMBERS_COMMENT)

        try {
            lottoData = lottoData.copy(bonusNumber = inputBonusNumbers())
            currentState = PlayLottoState.MATCHING
        } catch (illegalArgumentException: IllegalArgumentException) {
            println(illegalArgumentException.message)
        }
    }

    private fun matchingProcess() {
        lottoData.lotteries.forEach { numbers ->
            val lottoMatchInfo = Lotto(numbers).matchingLotto(lottoData.winningNumbers, lottoData.bonusNumber)
            if (lottoMatchInfo != null) {
                addValueLottoResult(lottoMatchInfo)
            }
        }
        currentState = PlayLottoState.END
    }

    private fun addValueLottoResult(lottoMatchInfo: LottoWinnerInfo) {
        lottoData = lottoData.copy(
            lottoResults = lottoData.lottoResults.map { lottoResult ->
                if (lottoResult.lottoWinnerInfo == lottoMatchInfo) {
                    lottoResult.copy(
                        value = lottoResult.value + 1
                    )
                } else {
                    lottoResult
                }
            }
        )
    }

    private fun inputPurchaseAmount(): Int {
        val userInput = Console.readLine()
        return userInput.also { it.purchaseAmountValidation() }.toInt()
    }

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
            val comment = lottoResult.lottoWinnerInfo.comment
            println(comment(value))
        }

        print(totalRateComment(calculationTotalRate()))
    }

    private fun calculationTotalRate(): String {
        val winnings = lottoData.lottoResults.sumOf { it.value * it.lottoWinnerInfo.prise }
        return calculateLottoROI(lottoData.purchaseAmount.toDouble(), winnings)
    }
}
