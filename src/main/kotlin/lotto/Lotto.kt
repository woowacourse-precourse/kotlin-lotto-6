package lotto

import camp.nextstep.edu.missionutils.Randoms
import ui.InputValidator

class Lotto(private val numbers: List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)) {
    init {
        InputValidator
            .checkProperNumbersSize(numbers)
            .checkNumberListInRange(numbers)
    }
    fun toAscendingList() = numbers.sorted()
}
