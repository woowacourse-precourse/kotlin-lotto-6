package lotto
import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    companion object Lotto{
        fun randomlotto(): List<Int> {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            return numbers
        }
    }
}
