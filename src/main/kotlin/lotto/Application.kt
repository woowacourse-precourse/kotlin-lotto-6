package lotto

import lotto.domain.controller.LottoController
import lotto.util.retryUntilSuccess


fun main() {
    val lottoController = LottoController()

    retryUntilSuccess {
        val lottoPurchasePrice = lottoController.getPurchasePrice()
        lottoController.getNumberOfTickets(lottoPurchasePrice)
    }
    lottoController.getWinningNumbers()
    lottoController.showWinningNumbers()
    retryUntilSuccess {
        val userInputNumbers = lottoController.getUserNumbers()
        lottoController.validateUserNumbers(userInputNumbers)
    }
    retryUntilSuccess {
        val userInputBonusNumber = lottoController.getUserBonusNumber()
        lottoController.validateUserBonusNumber(userInputBonusNumber)
    }
    lottoController.checkWinning()
    lottoController.showWinningResult()
    val rateOfReturn = lottoController.calculateRateOfReturn()
    lottoController.showRateOfReturn(rateOfReturn)
}
