package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.LOTTO_NUMBER_COUNT
import lotto.util.LOTTO_NUMBER_MAX
import lotto.util.LOTTO_NUMBER_MIN

class LottoMake(private val purchaseCount: Int) {
    fun make() {
        for (count in 0..purchaseCount) {
            val number =
                Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT)
            println(number)
//            Lotto(number)
//            number.forEach { number -> makeValidation(number) }
        }
    }

//    private fun makeValidation(number: Int) {
//        val numbers: MutableList<Int> = mutableListOf()
//        numbers.add(number)
//    }
}