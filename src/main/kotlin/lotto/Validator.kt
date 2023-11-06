package lotto

class Validator {
    fun validatePurchaseMoney(purchaseMoney: String): Boolean {
        return try {
            purchaseMoney.toInt()
            true
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 구입 금액을 올바르게 입력해주세요.")
            false
        }
    }

    fun isNumber(input: String): Boolean{
        return input.toIntOrNull() != null
    }
}