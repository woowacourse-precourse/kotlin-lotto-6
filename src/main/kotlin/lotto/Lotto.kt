package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.size == numbers.distinct().count())
        require(numbers.equals(lottoSort(numbers)))
    }

    private fun lottoSort(numbers: List<Int>): List<Int> {
        return numbers.sorted()
    }

}

