package lotto

class Error {
    fun checkPrice(price: Int) {
        checkPriceUnit(price)
    }
    private fun checkPriceUnit(price: Int) {
        if(price%1000!=0){
            throw IllegalArgumentException("구입 금액이 1000원 단위가 아닙니다.")
        }
    }

}