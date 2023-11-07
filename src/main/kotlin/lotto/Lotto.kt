package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "로또 번호는 6개여야 합니다." }
        require(numbers.toSet().size == 6) { "로또 번호에 중복된 숫자가 있습니다." }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    companion object {
        fun createRandomLotto(): Lotto {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            return Lotto(numbers)
        }
    }
}

enum class Prize(val matchedNumbers: Int, private val prizeMoney: Int) {

    THIRD(3, 5000),
    FOURTH(4, 50000),
    FIFTH(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    NONE(0, 0);

}

