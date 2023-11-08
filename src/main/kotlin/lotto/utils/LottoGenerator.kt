package lotto.utils

import camp.nextstep.edu.missionutils.Randoms
import lotto.resources.Lotto

fun lottoGenerator(lottoCount: Int): List<List<Int>> {
    return List(lottoCount) { pickUniqueNumbersInRange().sorted() }
}

fun pickUniqueNumbersInRange(): List<Int> =
    Randoms.pickUniqueNumbersInRange(
        /* startInclusive = */ Lotto.START_NUMBER,
        /* endInclusive = */ Lotto.END_NUMBER,
        /* count = */ Lotto.LOTTO_NUMBERS_COUNT
    )