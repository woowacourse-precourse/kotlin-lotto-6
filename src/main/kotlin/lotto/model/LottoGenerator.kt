package lotto.model

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import lotto.config.GameConfig.END_NUMBER
import lotto.config.GameConfig.LOTTO_COUNTS
import lotto.config.GameConfig.START_NUMBER

class LottoGenerator {
    fun generateLotto(): Lotto =
        Lotto(pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_COUNTS).sorted().toList())
}