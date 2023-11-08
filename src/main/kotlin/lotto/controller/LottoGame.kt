package lotto.controller

import lotto.domain.WinningStatistics
import lotto.model.LottoManager
import lotto.util.Constants.INPUT_BONUS_NUMBERS
import lotto.util.Constants.INPUT_MONEY
import lotto.util.Constants.INPUT_WINNING_NUMBERS
import lotto.util.Constants.SEPARATOR
import lotto.util.Constants.UNIT
import lotto.util.Constants.WINNING_STATISTICS
import lotto.view.Input
import lotto.view.Output

class LottoGame(private val input: Input, private val output: Output) {

    fun play() {
        val amount = input.inputPurchaseAmount()
        val tickets = amount / UNIT

        output.outputNumber(tickets)
        val lottoTickets = LottoManager().issueLottoTicket(tickets)
        lottoTickets.forEach { output.outputTickets(it.issueNumbers()) }

        val winningNumbers = input.inputWinningNumbers()
        val bonusNumber = input.inputBonusNumber(winningNumbers)

        println("\n" + WINNING_STATISTICS)
        println(SEPARATOR)

        val reward = WinningStatistics().computeStatistics(lottoTickets, winningNumbers, bonusNumber)
        output.outputReward(reward)
        output.outputYield(amount, reward)
    }


}