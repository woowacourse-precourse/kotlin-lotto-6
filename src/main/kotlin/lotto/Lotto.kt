package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == 6) { "로또 번호에 중복된 숫자가 있으면 예외가 발생합니다." }
        require(numbers.all { it in 1..45 }) { "로또 번호는 1에서 45 사이여야 합니다." }

    }

    fun printNumbers() : List<Int>
    {
        return numbers.sorted()
    }

    fun getMatchedNumbers(winningNumbers: List<Int>): Int {
        return numbers.intersect(winningNumbers).count()
    }

    fun containsNumber(bonusNumber: Int): Boolean {
        return bonusNumber in numbers
    }
}
