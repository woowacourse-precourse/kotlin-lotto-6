package lotto.controller

import camp.nextstep.edu.missionutils.Console.readLine
import lotto.model.LottoModel
import lotto.view.LottoView

class LottoController(private val lottoModel: LottoModel,private val lottoView: LottoView) {

    fun stratLotto() {
        lottoView.printEnterPurchaseMessage()
        inputPurchaseAmount()

    }

    private fun inputPurchaseAmount() {
        val purchaseAmunt = readLine()
    }
}