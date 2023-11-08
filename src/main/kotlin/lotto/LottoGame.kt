package lotto

import lotto.GameMessageConstants.DIVIDER_MESSAGE
import lotto.GameMessageConstants.INPUT_BONUS_NUMBER_MESSAGE
import lotto.GameMessageConstants.INPUT_PURCHASE_AMOUNT_MESSAGE
import lotto.GameMessageConstants.INPUT_WINNING_NUMBERS_MESSAGE
import lotto.GameMessageConstants.WINNING_STATISTICS_MESSAGE
import lotto.GameMessageConstants.purchasedLottoMessage
import lotto.GameMessageConstants.tickets

class LottoGame(
    private val printer: Printer,
    private val inputReader: InputReader,
    private val lottoMachine: LottoMachine,
    private val resultCalculator: ResultCalculator,
    private val resultPrinter: ResultPrinter,
) {
    fun start() {
        val money = inputPurchasePrice()
        printer.showBlankLine()

        val tickets = purchaseTickets(money)
        printer.showBlankLine()

        val winningTicket = inputWinningNumber()
        printer.showBlankLine()

        val bonusNumber = inputBonusNumber(winningTicket)
        printer.showBlankLine()

        val gameResult = calculateResults(tickets, winningTicket, bonusNumber)
        printGameResult(gameResult, money)
    }

    private fun inputPurchasePrice(): Int {
        printer.show(INPUT_PURCHASE_AMOUNT_MESSAGE)
        return inputReader.readPurchasePrice()
    }

    private fun purchaseTickets(money: Int): List<Lotto> {
        val tickets = lottoMachine.buyTickets(money)
        showTickets(tickets)
        return tickets
    }

    private fun showTickets(tickets: List<Lotto>) {
        printer.show(purchasedLottoMessage(tickets.size))
        tickets.forEach { printer.show(tickets(it)) }
    }

    private fun inputWinningNumber(): Lotto {
        printer.show(INPUT_WINNING_NUMBERS_MESSAGE)
        return inputReader.readWinningNumber()
    }

    private fun inputBonusNumber(winningTicket: Lotto): Int {
        printer.show(INPUT_BONUS_NUMBER_MESSAGE)
        return inputReader.readBonusNumber(winningTicket)
    }

    private fun calculateResults(tickets: List<Lotto>, winningTicket: Lotto, bonusNumber: Int): LottoResult =
        resultCalculator.calculateResults(tickets, winningTicket, bonusNumber)

    private fun printGameResult(lottoResult: LottoResult, money: Int) {
        printer.show(WINNING_STATISTICS_MESSAGE)
        printer.show(DIVIDER_MESSAGE)
        resultPrinter.printResults(lottoResult, money)
    }
}
