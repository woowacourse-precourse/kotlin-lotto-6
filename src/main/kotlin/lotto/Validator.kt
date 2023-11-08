package lotto

object Validator {

    private const val MAX_NUMBER = 45
    private const val MIN_NUMBER = 1
    private const val LOTTO_LENGTH = 6
    private const val TICKET_PRICE = 1000

    fun convertNumber(text: String) {
        require(text.toIntOrNull() != null && text.toInt() > 0) { ErrorMessage.INVALID_NUMBER.getMessage() }
    }

    fun price(price: String) {
        require(price.toInt() % TICKET_PRICE == 0) { ErrorMessage.REMAIN_CHARGE.getMessage() }
    }


    fun duplication(numbers: List<Int>) {
        require(numbers.size == numbers.distinct().count()) { ErrorMessage.DUPLICATED_NUMBER.getMessage() }
    }

    fun lottoLength(numbers: List<Int>) {
        require(numbers.size == LOTTO_LENGTH) { ErrorMessage.INVALID_LOTTO_LENGTH.getMessage() }
    }

    fun range(number: Int) {
        require(number in MIN_NUMBER..MAX_NUMBER) { ErrorMessage.INVALID_LOTTO_RANGE.getMessage() }
    }

    fun lottoRange(numbers: List<Int>) {
        numbers.forEach { range(it) }
    }

    fun exist(winning: List<Int>, number: Int) {
        require(!winning.contains(number)) { ErrorMessage.INVALID_LOTTO_UNIQUE.getMessage() }
    }

}