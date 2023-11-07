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

    companion object {
        fun createRandomLotto(): Lotto {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            return Lotto(numbers)
        }
    }
}
