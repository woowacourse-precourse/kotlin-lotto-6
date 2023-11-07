package lotto.domain

import lotto.util.Error
import lotto.util.LOTTO_PRICE

class Purchaser(money: Int) {
    val lottoCount = money / LOTTO_PRICE
    var lottoWallet: LottoWallet
        private set

    init {
        require(money >= LOTTO_PRICE && money % LOTTO_PRICE == 0) { Error.InvalidUnit.message }
        lottoWallet = LottoMachine.buyLotto(lottoCount)
    }
}