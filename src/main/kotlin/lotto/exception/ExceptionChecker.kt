package lotto.exception


class ExceptionChecker {

    fun checkAmount(amount: String) {
        isDigitNumber(amount)
        isEnough(amount.toInt())
        isDollarUnit(amount.toInt())
    }
    private fun isDigitNumber(amount:String) {
        for(character in amount){
            if(!character.isDigit()) {
                throw IllegalArgumentException()
            }
        }
    }
    private fun isEnough(amount: Int) {
        if(amount<1000) {
            throw IllegalArgumentException()
        }

    }
    private fun isDollarUnit(amount:Int) {
        if(amount%1000 != 0) {
            throw IllegalArgumentException()
        }
    }
}