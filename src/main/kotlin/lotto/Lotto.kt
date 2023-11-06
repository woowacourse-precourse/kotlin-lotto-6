package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.all { it in 1..45 })
        require(numbers.toSet().size == 6) // Set 자료구조로 변환해 중복 여부 확인
    }
    fun getNumbers(): List<Int> {
        return numbers.sorted()
    }
    override fun toString() :String {
        return getNumbers().joinToString(", ")
    }
    // TODO: 추가 기능 구현
}
