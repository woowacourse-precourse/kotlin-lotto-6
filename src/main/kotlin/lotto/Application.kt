package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.model.LottoTicket
import lotto.util.LottoGenerator
import lotto.util.Validator.validate1000Unit
import lotto.util.Validator.validateInteger
import lotto.util.Validator.validateRange
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    outputView.printGameStartMessage()
    val userInputPrice = inputView.getValidateUserInput()
    val purchaseCount = userInputPrice / 1000
    val lottoTicket = LottoTicket(purchaseCount)
    val lottoGenerator = LottoGenerator()
    println()
    outputView.printPurchaseCount(purchaseCount)
    repeat(purchaseCount) {
        val numbers = lottoGenerator.lottoPublish()
        lottoTicket.addNumbers(numbers)
    }
    outputView.printLottoTicket(lottoTicket)
}