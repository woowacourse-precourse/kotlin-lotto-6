package lotto.controller

import lotto.domain.RandomLottoGenerator
import lotto.model.Lottos
import lotto.view.InputView

class LottoController {
    fun playGame() {
        val purchaseCount = InputView.getPurchaseMoney() / 1000
        val randomLottos = Lottos(purchaseCount, RandomLottoGenerator())
        
    }
}