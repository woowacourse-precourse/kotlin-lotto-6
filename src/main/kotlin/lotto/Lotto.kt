package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun sortNumbers(): List<Int> {
        return numbers.sorted()
    }

    // TODO:  구현
}
