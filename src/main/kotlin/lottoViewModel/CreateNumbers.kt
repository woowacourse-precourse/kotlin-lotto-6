package lottoViewModel

import camp.nextstep.edu.missionutils.Randoms

class CreateNumbers {
    fun createRandomNumbers():List<Int>{
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return numbers
    }
}