package lotto

import camp.nextstep.edu.missionutils.Randoms
import util.Validator

class Lotto(private val numbers: List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)) {
    init {
        Validator.checkProperNumbersSize(numbers)
        require(numbers.all { it in 1..45 })
    }
    fun toAscendingList() = numbers.sorted()
}
