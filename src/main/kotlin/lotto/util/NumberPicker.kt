package lotto.util

import camp.nextstep.edu.missionutils.Randoms

object NumberPicker {
    fun pickNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(
            minLottoWinningNumber,
            maxLottoWinningNumber,
            lottoWinningNumberQuantity
        )
    }
}