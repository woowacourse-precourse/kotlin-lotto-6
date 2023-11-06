package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator(private val lottoGenerateCount: Int) {

    private fun generateRandomLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }

    fun printRandomLotto() {
        for (count in 1..lottoGenerateCount) {
            val lottoNumbers = generateRandomLotto()
            println(lottoNumbers)
        }
    }

}