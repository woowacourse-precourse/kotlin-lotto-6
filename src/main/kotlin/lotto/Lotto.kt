package lotto

class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { throw IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.")}
        require(numbers.toSet().size == 6) { throw IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.")}
        require(numbers.all { it in 1..45 }) { throw IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.")}
    }

    fun isSameAs(other: Lotto): Boolean {
        return numbers.toSet() == other.numbers.toSet()
    }
}
