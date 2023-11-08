package lotto.controller

import lotto.domain.WinningStatistics
import lotto.model.LottoManager
import lotto.util.Constants.INPUT_BONUS_NUMBERS
import lotto.util.Constants.INPUT_MONEY
import lotto.util.Constants.INPUT_WINNING_NUMBERS
import lotto.util.Constants.SEPARATOR
import lotto.util.Constants.WINNING_STATISTICS
import lotto.view.Input
import lotto.view.Output

class LottoGame(private val input: Input, private val output: Output) {


    fun play() {
        println(INPUT_MONEY)
        val amount = input.inputPurchaseAmount()
        val tickets = amount / 1000

        output.outputNumber(tickets)
        val lottoTickets = LottoManager().issueLottoTicket(tickets)
        lottoTickets.forEach {
            output.outputTickets(it.issueNumbers())
        }

        println("\n" + INPUT_WINNING_NUMBERS)
        val winningNumbers = input.inputWinningNumbers()

        println("\n" + INPUT_BONUS_NUMBERS)
        val bonusNumber = input.inputBonusNumber(winningNumbers)


        println("\n" + WINNING_STATISTICS)
        println(SEPARATOR)

        val reward = WinningStatistics().computeStatistics(lottoTickets, winningNumbers, bonusNumber)
        output.outputReward(reward)
        output.outputYield(amount, reward)
    }


}