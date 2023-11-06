package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator(private val lottoGenerateCount: Int) {

    private fun generateRandomLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}