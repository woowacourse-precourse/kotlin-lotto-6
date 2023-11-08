package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == Constants.LOTTO_SIZE)
        require(numbers.all { it in Constants.MIN_NUMBER..Constants.MAX_NUMBER })
        require(numbers.toSet().size == Constants.LOTTO_SIZE) // Set 자료구조로 변환해 중복 여부 확인
    }
    // TODO: 추가 기능 구현
    fun getNumbers(): List<Int> {
        return numbers.sorted()
    }
    override fun toString() :String {
        return "[" + getNumbers().joinToString(", ") + "]"
    }
}
