package lotto.domain.lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoGenerator {
    private const val LOTTO_NUMBER_COUNT = 6
    private const val LOTTO_NUMBER_MIN = 1
    private const val LOTTO_NUMBER_MAX = 45

    fun generateLottoNumber(): Lotto = Lotto(
        Randoms.pickUniqueNumbersInRange(
            LOTTO_NUMBER_MIN,
            LOTTO_NUMBER_MAX,
            LOTTO_NUMBER_COUNT
        )
    )
}