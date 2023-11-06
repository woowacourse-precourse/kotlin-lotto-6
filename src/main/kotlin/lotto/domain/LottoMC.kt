package lotto.domain

import lotto.view.InputView

class LottoMC(private val inputView: InputView) {
    fun pickLottoNum(): List<String> {
        return listOf(inputView.inputView().trim())
    }

    fun pickBonusNum(): String {
        return inputView.inputView()
    }
}