package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.Constant.LOTTO_MAX_RANDOM_NUMBER
import lotto.util.Constant.LOTTO_MIN_RANDOM_NUMBER
import lotto.util.Constant.LOTTO_NUMBER_SIZE

object LottoNumberGenerator {

    fun makeLottoNumber(): List<Int> = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_RANDOM_NUMBER,LOTTO_MAX_RANDOM_NUMBER,LOTTO_NUMBER_SIZE).sorted()
}