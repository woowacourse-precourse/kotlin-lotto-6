package lotto.model

import lotto.Validation.validateDuplicateNumber
import lotto.Validation.validateLottoNumber

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        validateDuplicateNumber(numbers)
        numbers.forEach { validateLottoNumber(it.toString()) }
    }

    fun printLotto() {
        println(numbers.joinToString(", ", "[", "]"))
    }

    fun compareLotto(winningLotto: MutableList<Int>, bonusNumber: Int): Int {
        var match = 0
        numbers.forEach {
            if (winningLotto.contains(it)) {
                match++
            }
        }
        if (match == 5 && numbers.contains(bonusNumber)) {
            match = 50
        }
        return match
    }
}
