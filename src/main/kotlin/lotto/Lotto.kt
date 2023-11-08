package lotto

import camp.nextstep.edu.missionutils.Randoms
import ui.InputValidator
import ui.MAX_LOTTO_RANGE
import ui.MIN_LOTTO_RANGE
import ui.PROPER_LOTTO_SIZE

class Lotto(
    private val numbers: List<Int> =
        Randoms.pickUniqueNumbersInRange(
            MIN_LOTTO_RANGE,
            MAX_LOTTO_RANGE,
            PROPER_LOTTO_SIZE
        )
) {
    init {
        InputValidator
            .checkProperNumbersSize(numbers)
            .checkNumberListInRange(numbers)
    }

    fun toAscendingList() = numbers.sorted()
}
