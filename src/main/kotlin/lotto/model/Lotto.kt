package lotto.model

import lotto.util.Constants.LOTTO_SIZE
import lotto.util.Constants.MATCH_FIVE
import lotto.util.Constants.MATCH_FIVE_BONUS
import lotto.util.Constants.ZERO_NUM

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE)
    }

    fun checkLottoWinning(bonusNum:Int,lottoLists: List<List<Int>>):List<Int>{
        val winningResult= MutableList(lottoLists.size){ZERO_NUM}
        for((i,lottoList) in lottoLists.withIndex()){
            val count = lottoList.intersect(numbers.toSet()).count()
            winningResult[i] = count
            if (count == MATCH_FIVE && lottoList.contains(bonusNum)) {
                winningResult[i] = MATCH_FIVE_BONUS
            }
        }
        return winningResult
    }
}
