package lotto.controller

import lotto.model.domain.Money
import lotto.view.InputConsole.getNumber
import lotto.view.OutputConsole.printErrorMessage
import lotto.view.OutputConsole.promptForMoney

class LottoController {

    fun start() {
        promptForMoney()
        val money = getValidMoney()
    }

    private fun getValidMoney(): Money =
        try {
            Money(getNumber())
        } catch (exception: IllegalArgumentException) {
            printErrorMessage(exception)
            getValidMoney()
        }
}