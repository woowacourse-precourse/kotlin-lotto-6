package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator : NumberGenerator {

    override fun generate(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, PICK_NUMBER)
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val PICK_NUMBER = 6
    }
}
