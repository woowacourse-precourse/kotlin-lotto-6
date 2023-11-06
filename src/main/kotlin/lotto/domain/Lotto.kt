package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        duplicateCheck()
    }

    private fun duplicateCheck() {
        if (numbers.distinct().size != numbers.size) {
            throw IllegalArgumentException()
        }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }


}
