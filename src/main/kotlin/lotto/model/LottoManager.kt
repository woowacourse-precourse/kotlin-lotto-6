package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class LottoManager(private val purchaseAmount: Int) {

    private val _lottoes = mutableListOf<Lotto>()
    val lottoes: List<Lotto>
        get() = _lottoes

    fun create() {
        repeat(purchaseAmount / 1000) {
            val lottoNums = getLottoNum()
            _lottoes.add(Lotto(lottoNums))
        }
    }

    private fun getLottoNum(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }

}