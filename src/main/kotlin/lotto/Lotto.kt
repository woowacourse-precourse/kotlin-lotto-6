package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == 6) {throw IllegalArgumentException("$ERROR 6자리 숫자는 모두 달라야 합니다.")}

    }

    override fun toString(): String {
        return "$numbers"
    }

    fun getNumbers(): List<Int> {
        return numbers
    }


}
