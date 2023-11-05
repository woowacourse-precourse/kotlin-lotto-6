package lotto.controller

import lotto.domain.RandomLottoGenerator
import lotto.model.Lottos
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun playGame() {
        val purchaseCount = InputView.getPurchaseMoney() / 1000
        val randomLottos = Lottos(purchaseCount, RandomLottoGenerator())

        val lottoState = randomLottos.getLottoState()
        OutputView.printLottoCount(purchaseCount)
        lottoState.forEach {
            OutputView.printLottoNumbers(it.lotto)
        }

        val winningLotto = InputView.getWinningNumber()

    }
}