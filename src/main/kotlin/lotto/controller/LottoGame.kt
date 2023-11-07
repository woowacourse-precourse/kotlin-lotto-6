package lotto.controller

import lotto.domain.WinningStatistics
import lotto.model.LottoManager
import lotto.model.LottoRecord
import lotto.util.Constants.INPUT_BONUS_NUMBERS
import lotto.util.Constants.INPUT_MONEY
import lotto.util.Constants.INPUT_WINNING_NUMBERS
import lotto.util.Constants.SEPARATOR
import lotto.util.Constants.WINNING_STATISTICS
import lotto.util.Validation.validateBonusNumber
import lotto.util.Validation.validatePurchaseAmount
import lotto.util.Validation.validateWinningNumbers
import lotto.view.Input
import lotto.view.Output

class LottoGame {

    private val input = Input()
    private val output = Output()


    fun play() {
        println(INPUT_MONEY)
        val amount = checkInputAmount()

        output.outputNumber(amount)
        val lottoTickets = LottoManager().issueLottoTicket(amount)
        lottoTickets.forEach {
            output.outputTickets(it.issueNumbers())
        }

        output.Blank()
        println(INPUT_WINNING_NUMBERS)
        val winningNumbers = checkInputWinningNumbers()

        output.Blank()
        println(INPUT_BONUS_NUMBERS)
        val bonusNumber = checkInputBonusNumber(winningNumbers)

        output.Blank()
        println(WINNING_STATISTICS)
        println(SEPARATOR)

        val reward = WinningStatistics().computeStatisics(lottoTickets, winningNumbers, bonusNumber)
        output.outputReward(reward)

    }

    private fun checkInputAmount(): Int {
        return try {
            val amount = input.inputPurchaseAmount()
            validatePurchaseAmount(amount)
            output.Blank()
            amount.toInt() / 1000
        } catch (e: IllegalArgumentException) {
            println(e)
            checkInputAmount()
        }
    }

    private fun checkInputWinningNumbers() : List<Int> {
        return try {
            val winningNumbers = input.inputWinningNumbers()
            validateWinningNumbers(winningNumbers)
            changeType(winningNumbers)
        } catch (e : IllegalArgumentException) {
            println(e)
            checkInputWinningNumbers()
        }
    }

    private fun checkInputBonusNumber(winningNumbers : List<Int>) : Int {
        return try {
            val bonusNumber = input.inputBonusNumber()
            validateBonusNumber(winningNumbers,bonusNumber)
            bonusNumber.toInt()
        } catch (e : IllegalArgumentException) {
            println(e)
            checkInputBonusNumber(winningNumbers)
        }
    }

    private fun changeType(original : List<String>) : List<Int> {
        return original.map { it.toInt() }
    }

}