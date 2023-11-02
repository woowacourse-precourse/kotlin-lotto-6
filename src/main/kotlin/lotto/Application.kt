package lotto

import lotto.controller.LottoGameController
import lotto.repository.RandomNumberLottoesRepository
import lotto.service.LottoGameService
import lotto.util.RandomLottoNumbersGenerator
import lotto.view.PrintOutputView
import lotto.view.ReadUserInputView

fun main() {
    LottoGameController(
        ReadUserInputView(),
        PrintOutputView(),
        LottoGameService(RandomLottoNumbersGenerator(), RandomNumberLottoesRepository())
    ).play()
}
