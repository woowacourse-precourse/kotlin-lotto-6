package lotto.util

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.const.lottoWinningNumberQuantity
import lotto.util.const.maxLottoWinningNumber
import lotto.util.const.minLottoWinningNumber

object NumberPicker {
    fun pickNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(
            minLottoWinningNumber,
            maxLottoWinningNumber,
            lottoWinningNumberQuantity
        )
    }
}