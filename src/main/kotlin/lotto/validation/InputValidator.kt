package lotto.validation

object InputValidator {

    private const val ERROR_PREFIX: String = "[ERROR]"
    private const val DELIMITER_COMMA: Char = ','

    private const val PER_TICKET_PRICE: Int = 1_000
    private const val MAX_LOTTO_NUMBER: Int = 45
    private const val MIN_LOTTO_NUMBER: Int = 1

    fun checkInputEmpty(input: String) {
        require(input.isNotEmpty()) {
            "$ERROR_PREFIX 구입 금액이 입력되지 않았습니다."
        }
    }

    fun checkInputBlank(input: String) {
        require(input.isNotBlank()) {
            "$ERROR_PREFIX 구입 금액이 입력되지 않았습니다."
        }
    }

    fun checkInputTypeAsInt(input: String) {
        input.toIntOrNull() ?: throw NumberFormatException("$ERROR_PREFIX 올바른 입력값이 아닙니다.")
    }

    fun checkTicketPrice(price: Int) {
        require(price % PER_TICKET_PRICE == 0) {
            "$ERROR_PREFIX 구입 금액은 천원(1,000) 단위의 금액이어야 합니다."
        }
    }

    fun checkMaxPrice(price: Int) {
        require(price < Int.MAX_VALUE) {
            "$ERROR_PREFIX 구입 금액의 최대는 ${Int.MAX_VALUE}원 입니다."
        }
    }

    fun checkCommaBetweenNumbers(numbers: String) {
        require(numbers.contains(DELIMITER_COMMA)) {
            "$ERROR_PREFIX 쉼표(,)가 존재하지 않습니다."
        }
    }

    fun checkLimitLottoNumber(numbers: List<Int>) {
        require(numbers.all { number -> number in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) {
            "$ERROR_PREFIX 당첨 번호는 1에서 45 사이의 숫자로 이루어져야 합니다."
        }
    }

    fun checkLottoNumberPrefix(numbers: String) {
        require(numbers[0] != DELIMITER_COMMA) {
            "$ERROR_PREFIX 쉼표(,)는 가장 처음에 위치할 수 없습니다."
        }
    }

    fun checkLottoNumberPostfix(numbers: String) {
        require(numbers[numbers.lastIndex] != DELIMITER_COMMA) {
            "$ERROR_PREFIX 쉼표(,)는 가장 마지막에 위치할 수 없습니다."
        }
    }

    fun checkEmptyBetweenNumbers(numbers: String) {
        require(numbers.split(DELIMITER_COMMA).all { it.isNotBlank() }) {
            "$ERROR_PREFIX 올바른 입력값이 아닙니다."
        }
    }

    fun checkLimitBonusNumber(number: Int) {
        require(number in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) {
            "$ERROR_PREFIX 보너스 번호는 1에서 45 사이의 숫자로 이루어져야 합니다."
        }
    }

    fun checkDuplicateBetweenBonusAndLuckyNumbers(number: Int, luckyNumbers: List<Int>) {
        require(luckyNumbers.all { it != number }) {
            "$ERROR_PREFIX 당첨 번호와 중복된 숫자는 불가능합니다."
        }
    }
}