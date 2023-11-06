package lotto.domain

class Validator {
    fun checkInputOfPurchasingCorrect(input: String): Boolean {
        val number = input.toUIntOrNull()
        return number != null && number > 0u
    }
}