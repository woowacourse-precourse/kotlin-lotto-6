package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.all {it in 1..45 })
    }
    fun getlottonum(): List<Int> {
        return numbers
    }

    companion object {
        fun createLottoNumber() : Lotto{
            val randomNumber = Randoms.pickUniqueNumbersInRange(1,45,6)
            return Lotto(randomNumber)
        }

    }

}
