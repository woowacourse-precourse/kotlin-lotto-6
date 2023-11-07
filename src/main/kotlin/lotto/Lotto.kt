package lotto


class Lotto(private val numbers: List<Int>) : Iterable<Int> {
    init {
        require(hasSixNumbers(numbers)) { "[ERROR] 로또 티켓에는 숫자가 6개만 있어야합니다." }
        require(isInValidRange(numbers)) { "[ERROR] 로또 숫자의 범위는 1 이상 45 미만 이어야합니다." }
        require(isUnique(numbers)) { "[ERROR] 로또 숫자는 모두 달라야합니다." }
    }

    override fun toString(): String {
        return numbers.joinToString(prefix = "[", postfix = "]")
    }

    override fun iterator(): Iterator<Int> {
        return numbers.iterator()
    }
}
