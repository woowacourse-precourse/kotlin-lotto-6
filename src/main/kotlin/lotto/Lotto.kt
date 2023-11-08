package lotto


class Lotto(private val numbers: List<Int>) : Iterable<Int> {
    init {
        require(hasSixNumbers(numbers)) { ErrorMessages.LOTTO_NUMBER_COUNT_SHOULD_BE_SIX }
        require(areAllNumbersInValidRange(numbers)) { ErrorMessages.LOTTO_NUMBER_SHOULD_BE_IN_RANGE }
        require(isUnique(numbers)) { ErrorMessages.LOTTO_NUMBER_SHOULD_BE_UNIQUE }
    }

    override fun toString(): String {
        return numbers.joinToString(prefix = "[", postfix = "]")
    }

    override fun iterator(): Iterator<Int> {
        return numbers.iterator()
    }
}
