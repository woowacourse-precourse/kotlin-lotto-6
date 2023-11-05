package lotto

class Lotto(numbers: List<Int>) {
    val sortedNumbers: List<Int> = numbers.sorted()

    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == 6)
    }

    fun matchCount(winningNumbers: List<Int>): Int {
        return sortedNumbers.intersect(winningNumbers).size
    }

    // TODO: 추가 기능 구현
}