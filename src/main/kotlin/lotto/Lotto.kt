package lotto

import camp.nextstep.edu.missionutils.Randoms
import kotlin.random.Random

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {"6개 숫자 입력해야함"}
    }

}
