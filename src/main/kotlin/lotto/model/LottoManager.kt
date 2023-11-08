package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class LottoManager(private val purchaseAmount: Int) {

    private val _lottoes = mutableListOf<Lotto>()
    val lottoes: List<Lotto>
        get() = _lottoes

    private val lottoNum = purchaseAmount / 1000

    fun create() {
        repeat(lottoNum) {
            val lottoNums = getLottoNum()
            _lottoes.add(Lotto(lottoNums))
        }
    }

    private fun getLottoNum(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }

}