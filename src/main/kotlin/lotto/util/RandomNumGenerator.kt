package lotto.util

import camp.nextstep.edu.missionutils.Randoms

fun randomNumberGenerator(startNum: Int, lastNum: Int, numCount: Int): List<Int> {
    return Randoms.pickUniqueNumbersInRange(startNum, lastNum, numCount)
}