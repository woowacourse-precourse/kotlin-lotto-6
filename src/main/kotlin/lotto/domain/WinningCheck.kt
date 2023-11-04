package lotto.domain

class WinningCheck {

    fun numbersCheck(myLotto: List<Lotto>, winningNumber: List<Int>, bonusNumber: Int) : List<WIN> {
        val WINList = mutableListOf<WIN>()
        for (lotto in myLotto) {
            val result = compareNumbers(lotto.getNumbers(),winningNumber,bonusNumber)
            WINList.add(winCheck(result))
        }
        return WINList
    }

    private fun compareNumbers(lotto: List<Int>, winningNumber: List<Int>, bonusNumber: Int) :Pair<Int,Boolean>{
        val correct = winningNumber.count { it in lotto }
        val hasBonusNumber = bonusNumber in lotto
        return Pair(correct, hasBonusNumber)
    }

    private fun winCheck(lottoResult : Pair<Int,Boolean>): WIN {
        when(lottoResult.first){
            WIN.FIRST.correct->return WIN.FIRST
            WIN.FOURTH.correct->return WIN.FOURTH
            WIN.FIFTH.correct->return WIN.FIFTH
        }
        if(lottoResult.first== WIN.SECOND.correct&&lottoResult.second){
            return WIN.SECOND
        }
        if(lottoResult.first== WIN.THIRD.correct&&!lottoResult.second){
            return WIN.THIRD
        }
        return WIN.MISS
    }



}