package lotto

class Validation {

    fun checkInt(input: String): Int {
        if (input.toIntOrNull() == null) throw IllegalArgumentException("[ERROR] 숫자만 입력해주세요")
        return input.toInt()
    }

    fun checkInputPayment(payment: String): Int {
        val input = checkInt(payment)
        if (input % 1000 != 0) throw IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요")
        return input
    }
}
