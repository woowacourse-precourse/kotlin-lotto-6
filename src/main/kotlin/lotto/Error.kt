package lotto

class Error {
    fun checkPrice(price: String) {
        checkInt(price)
        checkPriceUnit(price.toInt())
    }
    private fun checkInt(price: String) {
        try{
            price.toInt()
            true
        } catch (e: NumberFormatException){
            throw IllegalArgumentException("[ERROR] 숫자가 아닙니다.")
        }
    }

    private fun checkPriceUnit(price: Int) {
        if(price%1000!=0){
            throw IllegalArgumentException("[ERROR] 구입 금액이 1000원 단위가 아닙니다.")
        }
    }
    fun checkDuplicate(number: List<Int>) {
        if (number.toSet().size != 6) {
            throw IllegalArgumentException("[ERROR] 중복된 수가 있습니다.")
        }
    }
    fun checkNumber(input: Int) {
        if(input < 1 || input > 45){
            throw IllegalArgumentException("[ERROR] 숫자가 1이나 45 사이에 있지 않습니다.")
        }
    }

}