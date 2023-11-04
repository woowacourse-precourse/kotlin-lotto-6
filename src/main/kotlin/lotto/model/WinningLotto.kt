package lotto.model

class WinningLotto {

    private var _luckyNumbers = listOf<Int>()
    val luckyNumbers get() = _luckyNumbers
    private var _bonusNumber = 0
    val bonusNumber get() = _bonusNumber

    fun setLuckyNumbers(luckyNumbers : List<Int>) {
        _luckyNumbers = luckyNumbers
    }

    fun setBonusNumber(bonusNumber : Int){
        _bonusNumber = bonusNumber
    }
}