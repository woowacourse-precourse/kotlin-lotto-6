package lotto

import camp.nextstep.edu.missionutils.Randoms

private const val CNT_LOTTO_NUMBER = 6
private const val MIN_LOTTO_NUMBER = 1
private const val MAX_LOTTO_NUMBER = 45

class LottoGenerator(private val lottoGenerateCount: Int) {

    private fun generateRandomLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, CNT_LOTTO_NUMBER).sorted()
    }

    fun printRandomLotto() {
        for (count in 1..lottoGenerateCount) {
            val lottoNumbers = generateRandomLotto()
            println(lottoNumbers)
        }
    }

}