package lotto.domain.util

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.util.const.lottoWinningNumberQuantity
import lotto.domain.util.const.maxLottoWinningNumber
import lotto.domain.util.const.minLottoWinningNumber

object NumberPicker {
    fun pickNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(
            minLottoWinningNumber,
            maxLottoWinningNumber,
            lottoWinningNumberQuantity
        )
    }
}