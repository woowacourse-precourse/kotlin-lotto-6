package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class LottoManager(private val purchaseAmount: Int) {

    private val _lottoes = mutableListOf<Lotto>()
    val lottoes: List<Lotto>
        get() = _lottoes

    fun create() {
        repeat(purchaseAmount / LOTTO_PRICE) {
            val lottoNums = getLottoNum()
            _lottoes.add(Lotto(lottoNums))
        }
    }

    private fun getLottoNum(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(RANDOM_START_NUM, RANDOM_END_NUM, RANDOM_NUM_AMOUNT)
    }

    companion object {
        private const val RANDOM_START_NUM = 1
        private const val RANDOM_END_NUM = 45
        private const val RANDOM_NUM_AMOUNT = 6
        private const val LOTTO_PRICE = 1000
    }

}