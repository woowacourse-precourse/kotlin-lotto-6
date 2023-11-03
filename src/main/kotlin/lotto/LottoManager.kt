package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoManager {
    private val myLotto = mutableListOf<Lotto>()

    private fun generateNewLotto():Lotto{
        val numbers  = generateRandomNumbers()
        return Lotto(numbers)
    }

    private fun generateRandomNumbers() : List<Int>{
        return Randoms.pickUniqueNumbersInRange(1,45,6)
    }


    fun getLotto(index : Int) : Lotto{
        return myLotto[index]
    }

    fun generateLotto(){
        val newLotto = generateNewLotto()
        myLotto.add(newLotto)
    }
}