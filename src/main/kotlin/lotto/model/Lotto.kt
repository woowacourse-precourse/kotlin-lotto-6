package lotto.model

import lotto.util.Constants.LOTTO_SIZE
import lotto.util.Constants.MATCH_FIVE_BONUS

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE)
    }

    fun checkLottoWinning(bonusNum:Int,lottoLists: List<List<Int>>):List<Int>{
        val result= MutableList(lottoLists.size){0}

        for(i in lottoLists.indices){
           val a=  lottoLists[i].intersect(numbers.toSet()).count()
            result[i] = a
            if(result[i] == 5 && lottoLists[i].contains(bonusNum)){
                result[i] = MATCH_FIVE_BONUS
            }
        }
        return result
    }
}
