package lotto.utils

import camp.nextstep.edu.missionutils.Randoms

object LottoNumbersGenerator {
    fun generateLottoNumbers() : List<Int>{
        val lottoNumbers = mutableListOf<Int>()
        while (lottoNumbers.size < 6) {
            val randomNumber = Randoms.pickNumberInRange(1, 45)
            if (!lottoNumbers.contains(randomNumber)) {
                lottoNumbers.add(randomNumber)
            }
        }
        return lottoNumbers.toList()
    }
}