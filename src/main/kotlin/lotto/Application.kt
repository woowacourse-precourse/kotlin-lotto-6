package lotto

import lotto.domain.controller.LottoController
import lotto.util.doLogic


fun main() {
    val lottoController = LottoController()

    doLogic {
        val lottoPurchaseAmount = lottoController.getLottoPurchaseAmount()
        lottoController.getNumberOfLottoTickets(lottoPurchaseAmount)
    }
    lottoController.getLottoWinningNumbers()
    lottoController.showLottoWinningNumbers()
    doLogic {
        val userInputNumbers = lottoController.getUserLottoNumbers()
        lottoController.validateUserLottoNumbers(userInputNumbers)
    }
    doLogic {
        val userInputBonusNumber = lottoController.getUserBonusLottoNumber()
        lottoController.validateUserBonusLottoNumber(userInputBonusNumber)
    }
    lottoController.checkWinning()
    lottoController.showWinningResult()
    val rateOfReturn = lottoController.calculateRateOfReturn()
    lottoController.showRateOfReturn(rateOfReturn)
}
