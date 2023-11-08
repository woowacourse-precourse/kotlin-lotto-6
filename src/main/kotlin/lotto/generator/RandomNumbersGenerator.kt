package lotto.generator

import camp.nextstep.edu.missionutils.Randoms

class RandomNumbersGenerator : NumbersGenerator {
    override fun generate(): List<Int> = Randoms
        .pickUniqueNumbersInRange(1, 45, 6)
        .sorted()
}