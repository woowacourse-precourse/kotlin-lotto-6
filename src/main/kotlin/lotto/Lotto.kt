package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.size == numbers.distinct().count())
        println(lottoSort(numbers))
    }

    private fun lottoSort(numbers: List<Int>): List<Int> {
        return numbers.sorted()
    }

    fun getNumbers(): List<Int> {
        return lottoSort(numbers)
    }

}

