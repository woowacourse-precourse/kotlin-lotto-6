package lotto

class Error {
    companion object{
        private const val ALREADY_EXIST = "[ERROR] 이미 로또번호에 존재하는 번호입니다."
        private const val NOT_NUMBER = "[ERROR] 숫자가 아닙니다."
        private const val PRICE_UNIT = "[ERROR] 구입 금액이 1000원 단위가 아닙니다."
    }
    fun checkPrice(price: String) {
        checkInt(price)
        checkPriceUnit(price.toInt())
    }
    fun checkBonus(numbers: MutableList<Int>, bonusNum: Int) {
        if(numbers.contains(bonusNum)){
            throw IllegalArgumentException(ALREADY_EXIST)
        }
    }
    private fun checkInt(price: String) {
        try{
            price.toInt()
        } catch (e: IllegalArgumentException){
            println(NOT_NUMBER)
        }
    }

    private fun checkPriceUnit(price: Int) {
        if(price%1000!=0){
            throw IllegalArgumentException(PRICE_UNIT)
        }
    }

}