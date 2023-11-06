package lotto.controller

import lotto.model.LottoManager
import lotto.util.Constants.INPUT_BONUS_NUMBERS
import lotto.util.Constants.INPUT_MONEY
import lotto.util.Constants.INPUT_WINNING_NUMBERS
import lotto.util.Validation
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

        output.outputBlank()
        println(INPUT_WINNING_NUMBERS)
        val winningNumbers = checkInputWinningNumbers()

        output.outputBlank()
        println(INPUT_BONUS_NUMBERS)
        val bonusNumber = checkInputBonusNumber(winningNumbers)


    }

    private fun checkInputAmount(): Int {
        return try {
            val amount = input.inputPurchaseAmount()
            validatePurchaseAmount(amount)
            output.outputBlank()
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