package lotto.model

import org.assertj.core.util.Lists

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun checkLottoWinning(bonusNum:Int,lottoLists: List<List<Int>>):List<Int>{
        val result= MutableList(lottoLists.size){0}

        for(i in lottoLists.indices){
           val a=  lottoLists[i].intersect(numbers.toSet()).count()
            result[i] = a
            if(result[i] == 5 && lottoLists[i].contains(bonusNum)){
                result[i] = 100
            }
        }
        return result
    }
}
