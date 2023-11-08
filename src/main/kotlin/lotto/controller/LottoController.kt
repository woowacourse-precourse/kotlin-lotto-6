package lotto.controller

import lotto.model.LottoDrawingMachine
import lotto.model.LottoNumberDispenser
import lotto.model.LottoProfitCalculator
import lotto.model.domain.Bonus
import lotto.model.domain.Lotto
import lotto.model.domain.Money
import lotto.model.domain.Rank
import lotto.view.InputConsole
import lotto.view.OutputConsole.printErrorMessage
import lotto.view.OutputConsole.printLottoTickets
import lotto.view.OutputConsole.printProfit
import lotto.view.OutputConsole.printWinningRanks
import lotto.view.OutputConsole.promptForBonusNumber
import lotto.view.OutputConsole.promptForMoney
import lotto.view.OutputConsole.promptForWinningNumbers

class LottoController {

    fun start() {
        promptForMoney()
        val money = getValidMoney()

        val lottoTickets = buyLottoTickets(money)

        promptForWinningNumbers()
        val winningNumbers = getValidWinningNumbers()

        promptForBonusNumber()
        val bonusNumber = getValidBonusNumber(winningNumbers)

        val rank = executeDrawingMachine(lottoTickets, winningNumbers, bonusNumber)
        printWinningRanks(rank)

        val profit = calculateProfit(money, rank)
        printProfit(profit)
    }

    private fun getValidMoney(): Money =
        try {
            Money(InputConsole.getNumber())
        } catch (exception: IllegalArgumentException) {
            printErrorMessage(exception)
            getValidMoney()
        }

    private fun buyLottoTickets(money: Money): List<Lotto> {
        val numberDispenser = LottoNumberDispenser()
        return numberDispenser.buyTickets(money.amount).also {
            printLottoTickets(it)
        }
    }

    private fun getValidWinningNumbers(): Lotto =
        try {
            val numbers = InputConsole.getParsedNumbers()
            Lotto(numbers)
        } catch (exception: IllegalArgumentException) {
            printErrorMessage(exception)
            getValidWinningNumbers()
        }

    private fun getValidBonusNumber(winningNumbers: Lotto): Bonus =
        try {
            val bonus = InputConsole.getNumber()
            Bonus(bonus, winningNumbers)
        } catch (exception: IllegalArgumentException) {
            printErrorMessage(exception)
            getValidBonusNumber(winningNumbers)
        }

    private fun executeDrawingMachine(lottoTickets: List<Lotto>, winningNumbers: Lotto, bonus: Bonus): Map<Rank, Int> {
        val drawingMachine = LottoDrawingMachine(lottoTickets, winningNumbers, bonus)
        return drawingMachine.getRankCounts()
    }

    private fun calculateProfit(money: Money, rank: Map<Rank, Int>): Double {
        val calculator = LottoProfitCalculator(money, rank)
        return calculator.calculateProfitRate()
    }
}