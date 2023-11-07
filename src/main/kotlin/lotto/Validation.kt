package lotto

class Validation {

    fun checkInt(input: String): Int {
        if (input.toIntOrNull() == null) {
            throw IllegalArgumentException("[ERROR] 숫자만 입력해주세요")
        }
        return input.toInt()
    }

    fun checkInputPayment(payment: String): Int {
        val input = checkInt(payment)
        if (input % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요")
        }
        return input
    }

    fun checkInputLottoNumber(lotto: String): Lotto {
        val input = lotto.split(",")
        if (input.size != 6) {
            throw IllegalArgumentException("[ERROR] 숫자 6개를 입력해주세요. (','로 숫자 구분)")
        }
        input.forEach {
            checkInt(it)
        }
        return Lotto(input.map { it.toInt() })
    }

    fun checkInputBonusNumber(bonusNumber: String): Int {
        val input = checkInt(bonusNumber)
        if (input !in 1..45) {
            throw IllegalArgumentException("[ERROR] 1 부터 45 사이의 숫자를 입력해주세요.")
        }
        return input
    }
}
