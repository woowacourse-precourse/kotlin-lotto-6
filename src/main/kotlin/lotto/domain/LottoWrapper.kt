package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.utils.Constants

class LottoWrapper {
    private val lottoWrapper = mutableListOf<Lotto>()

    fun repeatLottoNumbers(ticket: Int): MutableList<Lotto> {
        repeat(ticket) {
            lottoWrapper.add(Lotto(generateLottoNumbers()))
        }
        return lottoWrapper
    }
    private fun generateLottoNumbers(): List<Int> {
        val answerLottoNumbers = Randoms.pickUniqueNumbersInRange(Constants.LOTTO_START_NUMBER, Constants.LOTTO_LAST_NUMBER, Constants.LOTTO_SIZE)
        return sortLottoNumbers(answerLottoNumbers)
    }

    private fun sortLottoNumbers(answerLottoNumbers: List<Int>): List<Int> {
        return answerLottoNumbers.sorted()
    }
}
