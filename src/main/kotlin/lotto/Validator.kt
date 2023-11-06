package lotto

class Validator {
    fun validatePurchaseMoney(purchaseMoney: String): Boolean {
        return try {
            isNumber(purchaseMoney) && isDividedUpThousand(purchaseMoney.toInt())
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 구입 금액을 올바르게 입력해주세요.")
            false
        }
    }

    fun isNumber(input: String): Boolean{
        return input.toIntOrNull() != null
    }

    fun isDividedUpThousand(money: Int): Boolean{
        return if (money%1000 == 0) {
            true
        } else{
            println("[ERROR] 구입 금액이 1000원으로 나누어 떨어지지 않습니다.")
            false
        }
    }
}