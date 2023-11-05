package lotto.utils

import camp.nextstep.edu.missionutils.Randoms

object LottoNumbersGenerator {
    fun generateLottoNumbers() : List<Int>{
        val lottoNunmbers = mutableListOf<Int>()
        while (lottoNunmbers.size < 6) {
            val randomNumber = Randoms.pickNumberInRange(1, 45)
            if (!lottoNunmbers.contains(randomNumber)) {
                lottoNunmbers.add(randomNumber)
            }
        }
        return lottoNunmbers.toList()
    }
}