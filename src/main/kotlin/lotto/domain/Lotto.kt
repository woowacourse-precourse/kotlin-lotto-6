package lotto.domain

import lotto.data.LottoCounts
import lotto.data.LottoNums

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.distinct().size == 6)
    }


    fun calculateLotto(lottoNums :  LottoNums ) : LottoCounts {
        val lottoCounts =  LottoCounts(0,false)
        lottoNums.lottoNums.forEach {
            if(numbers.contains(it)) lottoCounts.listCounts +=1
        }
        if(numbers.contains(lottoNums.bonusNum)) lottoCounts.bonus = true

        return lottoCounts

    }




}
