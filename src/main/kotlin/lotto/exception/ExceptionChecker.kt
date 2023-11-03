package lotto.exception


class ExceptionChecker {

    fun checkAmount(amount: String) {
        isDigitNumber(amount)
        isEnough(amount.toInt())
        isDollarUnit(amount.toInt())
    }
    private fun isDigitNumber(amount:String) {
        if(amount =="") throw IllegalArgumentException("[ERROR] 숫자가 아닙니다.")
        for(character in amount){
            if(!character.isDigit()) {
                throw IllegalArgumentException("[ERROR] 숫자가 아닙니다.")
            }
        }
    }
    private fun isEnough(amount: Int) {
        if(amount<1000) {
            throw IllegalArgumentException("[ERROR] 금액이 부족합니다.")
        }

    }
    private fun isDollarUnit(amount:Int) {
        if(amount%1000 != 0) {
            throw IllegalArgumentException("[ERROR] 1000원 단위의 금액을 입력해주세요.")
        }
    }
}