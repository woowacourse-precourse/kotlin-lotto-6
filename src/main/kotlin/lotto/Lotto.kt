package lotto

class Lotto(private val numbers: List<Int>) {
    private val lottoNumbers = numbers
    init {
        require(numbers.size == 6)
    }
    override fun toString(): String {
        return lottoNumbers.toString()
    }
    fun getNumbers(): List<Int> {
        return numbers
    }
    // TODO: 추가 기능 구현
}
