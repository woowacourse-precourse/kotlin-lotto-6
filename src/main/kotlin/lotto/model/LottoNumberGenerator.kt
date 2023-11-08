package lotto.model

import lotto.config.GameConfigValue.MINIMUM_LOTTO_NUMBER
import lotto.config.GameConfigValue.MAXIMUM_LOTTO_NUMBER
import lotto.config.GameConfigValue.LOTTO_DEFAULT_DIGIT
import camp.nextstep.edu.missionutils.Randoms

class LottoNumberGenerator{

    fun lottoNumberCreation(purchaseNumber:Int): MutableList<List<Int>> {
        val lottoNumberList=mutableListOf<List<Int>>()
        repeat(purchaseNumber) {
            val lottoNumbers = randomSixNumberGenerator()
            lottoNumberList.add(lottoNumbers)
        }
        return lottoNumberList
    }

    private fun randomSixNumberGenerator(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER,MAXIMUM_LOTTO_NUMBER,LOTTO_DEFAULT_DIGIT).sorted()
    }
}