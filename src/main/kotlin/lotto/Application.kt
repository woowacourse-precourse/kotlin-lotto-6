package lotto

import lotto.controller.LottoGameController
import lotto.repository.RandomNumberLottosRepository
import lotto.service.LottoGameService
import lotto.util.RandomLottoNumbersGenerator
import lotto.view.PrintOutputView
import lotto.view.ReadUserInputView

fun main() {
    LottoGameController(
        ReadUserInputView(),
        PrintOutputView(),
        LottoGameService(RandomLottoNumbersGenerator(), RandomNumberLottosRepository())
    ).play()
}
