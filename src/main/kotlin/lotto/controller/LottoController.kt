package lotto.controller

import lotto.domain.RandomLottoGenerator
import lotto.model.Lotto
import lotto.model.Lottos
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    private lateinit var randomLottos: Lottos

    fun playGame() {

        buyLotto()

        val winningNumbers = InputView.getWinningNumber()
        val bonusLottoNumber = InputView.getBonusNumber(winningNumbers)

        val lottoPrizes = randomLottos.getLottoPrize(Lotto(winningNumbers), bonusLottoNumber)

    }

    private fun buyLotto() {
        val purchaseCount = InputView.getPurchaseMoney() / 1000
        randomLottos = Lottos(purchaseCount, RandomLottoGenerator())

        val lottoState = randomLottos.getLottoState()
        OutputView.printLottoCount(purchaseCount)
        lottoState.forEach {
            OutputView.printLottoNumbers(it.lotto)
        }
    }


}