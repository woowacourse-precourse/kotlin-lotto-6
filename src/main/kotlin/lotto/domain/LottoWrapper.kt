package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.utils.Constants

class LottoWrapper {
    private val lottoWrapper = mutableListOf<Lotto>()


    fun reapeatLottoNumbers(ticket: Int): MutableList<Lotto> {
        repeat(ticket) {
            lottoWrapper.add(Lotto(generateLottoNumbers()))
        }
        return lottoWrapper
    }
    private fun generateLottoNumbers(): List<Int> {
        val lottoNumbers = Randoms.pickUniqueNumbersInRange(Constants.LOTTO_START_NUMBER, Constants.LOTTO_LAST_NUMBER, Constants.LOTTO_SIZE)
        return sortLottoNumbers(lottoNumbers)
    }

    private fun sortLottoNumbers(lottoNumbers: List<Int>): List<Int> {
        return lottoNumbers.sorted()
    }


}
