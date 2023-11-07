package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    override fun toString(): String {
        return numbers.sorted().toString()
    }

    fun getLottoNumbers(): List<Int> = numbers
}
