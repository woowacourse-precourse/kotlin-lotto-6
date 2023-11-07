package lotto

class Lotto(private val numbers: List<Int>) {
    private val lottoNumbers = numbers
    init {
        require(numbers.toSet().size==6)
    }
    override fun toString(): String {
        return lottoNumbers.toString()
    }
    fun getNumbers(): List<Int> {
        return lottoNumbers
    }
    // TODO: 추가 기능 구현
}
