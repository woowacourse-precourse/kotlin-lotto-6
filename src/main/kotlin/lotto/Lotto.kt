package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        if (numbers.size != numbers.toSet().size) throw IllegalArgumentException()
    }

    // TODO: 추가 기능 구현
    fun getNumbers(): List<Int> {
        return numbers
    }

    fun printNumbers() {
        println(numbers)
    }
}
