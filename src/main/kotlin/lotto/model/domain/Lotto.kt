package lotto.model.domain

class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == numbers.size)
    }
}
