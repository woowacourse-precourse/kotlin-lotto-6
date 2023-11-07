package lotto.domain

import lotto.view.InputView

class LottoMC(private val inputView: InputView) {
    fun pickLottoNum(): List<String> {
        val lottoNum = inputView.inputView().trim()
        return lottoNum.split(",").map { it.trim() }
    }

    fun pickBonusNum(): String {
        return inputView.inputView()
    }
}