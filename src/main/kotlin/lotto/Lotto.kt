package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {"[ERROR] 6개를 입력해주세요"}
        require(numbers.distinct().size == 6) {"[ERROR] 중복된 숫자가 있습니다."}
        require(numbers.all { it in 1..45 }) { "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." }
    }

    override fun toString(): String {
        return numbers.joinToString(separator = ", ", prefix = "[", postfix = "]")
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    fun getMatchCount(winningNumbers: List<Int>): Int {
        return numbers.count(winningNumbers::contains)
    }
    // TODO: 추가 기능 구현
}
