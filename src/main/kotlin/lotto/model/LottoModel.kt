package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class LottoModel {
    private val winningAndBonusNumbers = mutableListOf<String>()

    fun generateLottoNumbers(amount: Int): MutableList<List<Int>> {
        val lottoNumbers = mutableListOf<List<Int>>()
        repeat(amount / 1000) { lottoNumbers.add(createRandomNumber()) }

        return lottoNumbers
    }

    fun setWinningNumbers(winningNumbers: String) {
        winningNumbers
            .split(",")
            .forEach { winningAndBonusNumbers.add(it) }
    }

    fun setBonusNumbers(winningBonusNumbers: String) {
        winningAndBonusNumbers.add(winningBonusNumbers)
    }

    fun getWinningNumber(): List<String> {
        return winningAndBonusNumbers
    }

    private fun createRandomNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}