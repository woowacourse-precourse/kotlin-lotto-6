package lotto.domain.model

class Winning(val numbers: List<Int>, val bonusNumber: Int) {
    init {
        require(numbers.size == 6)
        require(numbers.all { number -> (1..45).contains(number) })
        require(numbers.distinct().size == 6)
        require((1..45).contains(bonusNumber))
        require(!numbers.contains(bonusNumber))
    }

}