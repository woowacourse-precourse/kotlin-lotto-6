package lotto.model

import camp.nextstep.edu.missionutils.Randoms

object LottoService {
    private const val MINIMUM_NUMBER = 1
    private const val MAXIMUM_NUMBER = 45
    private const val LOTTO_PRICE = 1000
    private const val LOTTO_SIZE = 6
    fun buyLotto(money: Int): List<List<Int>> =
        List(money / LOTTO_PRICE){ generateLotto() }

    private fun generateLotto(): List<Int> {
        val lottoNumbers = mutableSetOf<Int>()
        while (lottoNumbers.size < LOTTO_SIZE) {
            lottoNumbers.add(Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER))
        }
        return lottoNumbers.toList()
    }
}