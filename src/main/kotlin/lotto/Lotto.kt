package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 배열의 길이가 6이 아닙니다." }
        require(numbers.all { it in 1..45}) {"[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."}
        require(!isLottoRepeated(numbers)) {"[ERROR] 중복되는 숫자가 존재합니다."}
    }

    override fun toString(): String {
        return "[${numbers.joinToString(", ")}]"
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun isLottoRepeated(answer: List<Int>): Boolean {
        return answer.size != answer.distinct().count()
    }

}
