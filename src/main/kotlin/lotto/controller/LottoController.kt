package lotto.controller

import lotto.model.LottoNumberDispenser
import lotto.model.domain.Bonus
import lotto.model.domain.Lotto
import lotto.model.domain.Money
import lotto.view.InputConsole
import lotto.view.InputConsole.getNumber
import lotto.view.OutputConsole
import lotto.view.OutputConsole.printErrorMessage
import lotto.view.OutputConsole.promptForMoney

class LottoController {

    fun start() {
        promptForMoney()
        val money = getValidMoney()

        val lottoTickets = buyLottoTickets(money)

        OutputConsole.promptForWinningNumbers()
        val winningNumbers = getValidWinningNumbers()

        OutputConsole.promptForBonusNumber()
        val bonusNumber = getValidBonusNumber(winningNumbers)
    }

    private fun getValidMoney(): Money =
        try {
            Money(getNumber())
        } catch (exception: IllegalArgumentException) {
            printErrorMessage(exception)
            getValidMoney()
        }

    private fun buyLottoTickets(money: Money): List<Lotto> {
        val numberDispenser = LottoNumberDispenser()
        return numberDispenser.buyTickets(money.amount).also {
            OutputConsole.printLottoTickets(it)
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
            val bonus = getNumber()
            Bonus(bonus, winningNumbers)
        } catch (exception: IllegalArgumentException) {
            printErrorMessage(exception)
            getValidBonusNumber(winningNumbers)
        }
}