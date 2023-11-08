package lotto.Model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "로또 번호는 6개여야 합니다." }
        require(numbers.toSet().size == 6) { "로또 번호에 중복된 숫자가 있습니다." }
        require(numbers.all { it in 1..45 }) { "로또 번호는 1부터 45 사이의 값이어야 합니다." }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun lottoNumberCheck(winningNumbers: List<Int>, bonusNumber: Int): String {
        val matchedNumbers = numbers.filter { it in winningNumbers }
        val matchingCount = matchedNumbers.size
        return when (matchingCount) {
            3 -> "3개 일치"
            4 -> "4개 일치"
            5 -> {
                if (numbers.contains(bonusNumber)) "5개 일치, 보너스 볼 일치" else "5개 일치"
            }
            6 -> "6개 일치"
            else -> "꽝"
        }
    }
}
