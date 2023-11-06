package lotto.controller

import lotto.model.LottoManager
import lotto.util.Constants.INPUT_BONUS_NUMBERS
import lotto.util.Constants.INPUT_MONEY
import lotto.util.Constants.INPUT_WINNING_NUMBERS
import lotto.util.Validation
import lotto.util.Validation.validatePurchaseAmount
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
        val winningNumbers = input.inputWinningNumbers()

        output.outputBlank()
        println(INPUT_BONUS_NUMBERS)
        val bonusNumber = input.inputBonusNumber()


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
}