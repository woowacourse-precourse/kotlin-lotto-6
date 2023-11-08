package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoNumberGenerator : NumberGenerator {

    override fun generate(): List<Int> {
        val randomLottoNumber = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, PICK_NUMBER)
        return checkRandomLottoNumber(randomLottoNumber)
    }

    private fun checkRandomLottoNumber(randomNum: List<Int>): List<Int> {
        if (randomNum.distinct().size > 6) generate()
        return isSortedLottoNumber(randomNum)
    }

    private fun isSortedLottoNumber(randomNum: List<Int>): List<Int> {
        return randomNum.sorted()
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val PICK_NUMBER = 6
    }
}
