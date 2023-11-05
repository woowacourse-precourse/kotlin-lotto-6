package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)) {
    init {
        require(
            numbers.distinct()
                .size == 6
        )
        require(numbers.all { it in 1..45 })
    }
    fun toAscendingList() = numbers.sorted()
}
