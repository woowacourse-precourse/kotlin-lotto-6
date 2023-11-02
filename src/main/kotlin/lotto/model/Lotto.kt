package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {}
        require(numbers.size == numbers.distinct().size) {}
        require(numbers == numbers.sorted()) {}
    }

    // TODO: 추가 기능 구현
}
