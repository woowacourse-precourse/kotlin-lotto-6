package lotto

class Error {
    fun checkPrice(price: String) {
        checkInt(price)
        checkPriceUnit(price.toInt())
    }
    private fun checkInt(price: String) {
        try{
            price.toInt()
        } catch (e: IllegalArgumentException){
            println("[ERROR] 숫자가 아닙니다.")
        }
    }

    private fun checkPriceUnit(price: Int) {
        if(price%1000!=0){
            throw IllegalArgumentException("[ERROR] 구입 금액이 1000원 단위가 아닙니다.")
        }
    }

}