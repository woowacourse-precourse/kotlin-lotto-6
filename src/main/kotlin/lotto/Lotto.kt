package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6)
        if (numbers.size != numbers.distinct().size) {
            throw IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.")
        }
    }

    fun getNumbers(): List<Int>{
        return numbers
    }
}
