package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {"[ERROR] 6개를 입력해주세요"}
        require(numbers.distinct().size == 6) {"[ERROR] 중복된 숫자가 있습니다."}
    }

    override fun toString(): String {
        return numbers.joinToString(separator = ", ", prefix = "[", postfix = "]")
    }
    // TODO: 추가 기능 구현
}
