package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.toSet().size != 6) { "[ERROR] 중복된 숫자가 올 수 없습니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 숫자는 1에서 45 사이에 있어야 합니다."}
    }

    fun getNumbers() = numbers
    fun lottoNumberToString() = numbers.sorted().joinToString(prefix = "[", postfix = "]", separator = ", ")

}
