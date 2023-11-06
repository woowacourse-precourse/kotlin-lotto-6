package lotto.view

import lotto.util.Reader

class InputView(private val reader: Reader) {

    private fun inputMoney() {
        reader.readLottoPrice()
    }
}