package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.all {it in 1..45 })
        require(numbers.toSet().size == 6) { "로또 번호에 중복된 숫자가 있습니다." }
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
