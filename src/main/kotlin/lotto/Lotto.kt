package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun getNumbers() = numbers

    // TODO: 추가 기능 구현
}
