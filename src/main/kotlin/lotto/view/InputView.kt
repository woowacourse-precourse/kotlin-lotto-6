package lotto.view

import lotto.model.Lotto
import lotto.util.Reader

class InputView {

    private val reader = Reader

    fun readInputMoney(): Long {
        return reader.readLottoMoney()
    }

    fun readInputNumbers(): Lotto {
        return reader.readLottoNumbers()
    }

    fun readInputBonus(): Int {
        return reader.readLottoBonus()
    }
}