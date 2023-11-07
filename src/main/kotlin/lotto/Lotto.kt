package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "배열의 길이가 6이 아닙니다." }
        require(numbers.all { it in 1..45}) { "1 ~ 45 범위 밖의 숫자가 존재합니다." }
    }

    override fun toString(): String {
        return "[${numbers.joinToString(", ")}]"
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    // TODO: 추가 기능 구현
}
