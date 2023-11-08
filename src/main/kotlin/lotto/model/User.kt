package lotto.model

class User(private val data:String) {
    val purchaseAmount: Int = data.toInt()
    init {
        require(purchaseAmount > PURCHASE_AMOUNT_MIN){
            ERROR_MESSAGE_PURCHASE_AMOUNT_SCOPE
        }
        require(purchaseAmount % PURCHASE_AMOUNT_UNIT == 0){
            ERROR_MESSAGE_PURCHASE_AMOUNT_UNIT
        }
    }
    companion object {
        const val PURCHASE_AMOUNT_MIN = 0
        const val PURCHASE_AMOUNT_UNIT = 1000
        const val ERROR_MESSAGE_PURCHASE_AMOUNT_SCOPE = "[ERROR] 구입금액은 0 이상만 가능합니다."
        const val ERROR_MESSAGE_PURCHASE_AMOUNT_UNIT = "[ERROR] 구입금액은 1000 단위만 가능합니다"
    }
}