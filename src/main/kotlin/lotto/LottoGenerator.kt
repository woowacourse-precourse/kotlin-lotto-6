package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.data.Lotto

class LottoGenerator {

    fun get() = Lotto(generatedLottoNumber())

    fun get(numbers: List<Int>) = Lotto(numbers)

    private fun generatedLottoNumber() = Randoms.pickUniqueNumbersInRange(
        Constants.MIN_LOTTO_NUMBER, Constants.MAX_LOTTO_NUMBER, Constants.LOTTO_NUMBER_COUNT
    )
}