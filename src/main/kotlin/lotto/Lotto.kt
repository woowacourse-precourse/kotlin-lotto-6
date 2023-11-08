package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.size == numbers.distinct().count())
    }

    // TODO: 추가 기능 구현
}
