package lotto.domain

import lotto.domain.lotto.LottoMachine
import lotto.domain.lotto.LottoWallet
import lotto.util.Error
import lotto.util.LOTTO_PRICE

class Purchaser(money: Int) {
    private val lottoCount = money / LOTTO_PRICE
    var lottoWallet: LottoWallet
        private set

    init {
        require(money >= LOTTO_PRICE && money % LOTTO_PRICE == 0) { Error.InvalidUnit.message }
        lottoWallet = LottoMachine.buyLotto(lottoCount)
    }
}