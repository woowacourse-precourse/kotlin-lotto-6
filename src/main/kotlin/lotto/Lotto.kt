package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "배열의 길이가 6이 아닙니다." }
        require(numbers.all { it in 1..45}) { "1 ~ 45 범위 밖의 숫자가 존재합니다." }
        require(!isLottoRepeated(numbers))
    }

    override fun toString(): String {
        return "[${numbers.joinToString(", ")}]"
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun isLottoRepeated(answer: List<Int>): Boolean {
        if (isNumRepeated(answer)) {
            throw IllegalArgumentException("중복되는 숫자가 존재합니다.")
        }
        return false
    }

    fun isNumRepeated(numbers: List<Int>): Boolean {
        if (numbers.size != numbers.distinct().count()){
            return true
        }
        return false
    }
}
