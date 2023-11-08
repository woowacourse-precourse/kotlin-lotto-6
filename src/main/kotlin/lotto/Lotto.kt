package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        if (numbers.size != numbers.distinct().size) {
            throw IllegalArgumentException("[ERROR] 로또 번호 중복.")
        }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}
