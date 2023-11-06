package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import java.lang.NumberFormatException

class LottoModel {

    fun generateLottoNumbers(amount: Int): MutableList<List<Int>> {
        val lottoNumbers = mutableListOf<List<Int>>()
        repeat(amount / 1000) { lottoNumbers.add(createRandomNumber()) }

        return lottoNumbers
    }

    private fun createRandomNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}