package lotto

import camp.nextstep.edu.missionutils.*

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        numbers.sorted()
    }

    fun getLottoNumberString() : String {
        return numbers.toString()
    }
}
