package lotto.util

object Validator {
    fun validateInteger(input: String) {
        require(input.toIntOrNull() != null) { Exception.INVALID_INTEGER.getMessage() }
    }

    fun validateRange(input: String) {
        require(input.toInt() in 1000..Int.MAX_VALUE) { Exception.INVALID_RANGE.getMessage() }
    }

    fun validate1000Unit(input: String) {
        val number = input.toInt()
        require(number % 1000 == 0) { Exception.INVALID_1000_UNIT.getMessage() }
    }

    fun validateLottoInteger(input: String) {
        val validation = input.split(",")
        validation.forEach {
            require(it.toIntOrNull() != null) { "당첨번호가 정수가 아닙니다." }
        }
    }

    fun validateLottoNotNull(input: String) {
        val validation = input.split(",")
        validation.forEach {
            require(it.trim().isNotEmpty()) { "당첨번호에 널값이 존재합니다." }
        }
    }

    fun validateLottoSpace(input: String) {
        require(!input.contains(' ')) { "당첨번호에 공백이 존재합니다." }
    }

    fun validateLottoRange(input: List<Int>) {
        input.forEach {
            require(it in 1..45) { "당첨번호가 1부터 45까지의 숫자가 아닙니다." }
        }
    }

    fun validateLottoLength(input: List<Int>) {
        require(input.size == 6) { "당첨번호의 숫자가 6자리가 아닙니다." }
    }

    fun validateLottoUnique(input: List<Int>){
        require(input.distinct().size == 6) { "당첨번호의 숫자에 중복이 존재합니다." }
    }
}