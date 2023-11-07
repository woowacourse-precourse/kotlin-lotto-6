package lotto

import camp.nextstep.edu.missionutils.*

class NumberGenerator {
    public fun numberGenerate(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }

}