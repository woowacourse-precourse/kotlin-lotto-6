package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.LottoConstants.LOTTO_PRICE
import lotto.constants.LottoConstants.LOTTO_SIZE
import lotto.constants.LottoConstants.MAXIMUM_NUMBER
import lotto.constants.LottoConstants.MINIMUM_NUMBER

object LottoService {
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