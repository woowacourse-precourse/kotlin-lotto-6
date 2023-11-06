package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import java.lang.NumberFormatException

class LottoModel {
    private val winningAndBounsNumbers = mutableListOf<String>()

    fun generateLottoNumbers(amount: Int): MutableList<List<Int>> {
        val lottoNumbers = mutableListOf<List<Int>>()
        repeat(amount / 1000) { lottoNumbers.add(createRandomNumber()) }

        return lottoNumbers
    }

    fun setWinningNumbers(winningNumbers: String) {
        winningNumbers
            .split(",")
            .forEach { winningAndBounsNumbers.add(it) }
    }

    private fun createRandomNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}