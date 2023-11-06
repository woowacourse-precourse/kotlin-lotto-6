package lotto.view

import lotto.util.Reader

class InputView(private val reader: Reader) {

    fun readInputMoney() {
        reader.readLottoPrice()
    }
}