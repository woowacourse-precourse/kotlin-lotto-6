package lotto

import camp.nextstep.edu.missionutils.Randoms
import util.Validator

class Lotto(private val numbers: List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)) {
    init {
        Validator
            .checkProperNumbersSize(numbers)
            .checkNumberListInRange(numbers)
    }
    fun toAscendingList() = numbers.sorted()
}
