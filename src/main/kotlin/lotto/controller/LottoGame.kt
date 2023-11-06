package lotto.controller

import lotto.model.LottoManager
import lotto.util.Constants.INPUT_MONEY
import lotto.util.Validation
import lotto.view.Input
import lotto.view.Output

class LottoGame {

    private val input = Input()
    private val output = Output()
    private val validate = Validation()

    fun play() {
        println(INPUT_MONEY)
        val amount = checkInputAmount()
        println()

        output.outputNumber(amount)
        val lottoTickets = LottoManager().issueLottoTicket(amount)
        lottoTickets.forEach{
            output.outputTickets(it.issueNumbers())
        }
    }

    private fun checkInputAmount(): Int {
        return try {
            val amount = input.inputPurchaseAmount()
            validate.validatePurchaseAmount(amount)
            amount.toInt() / 1000
        } catch (e: IllegalArgumentException) {
            println(e)
            checkInputAmount()
        }
    }
}