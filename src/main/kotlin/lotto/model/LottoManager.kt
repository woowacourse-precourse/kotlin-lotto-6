package lotto.model

import lotto.model.Lotto

class LottoManager(private val purchaseAmount: Int, private val answerNumInt: List<Int>, private val bonusNumber: Int) {

    private val _lottoes = mutableListOf<Lotto>()
    val carList: List<Lotto>
        get() = _lottoes

    fun create() {

    }


}