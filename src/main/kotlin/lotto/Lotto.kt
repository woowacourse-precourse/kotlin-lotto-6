package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6)
        checkLottoNumber(numbers)
        checkDuplicationNumber(numbers)
    }

    private fun checkLottoNumber(numbers: List<Int>) {
        val lottoNumberRange = 1..45
        numbers.forEach {
            if (!lottoNumberRange.contains(it)) {
                throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
        }
    }

    private fun checkDuplicationNumber(numbers: List<Int>) {
        if (numbers.size != numbers.toSet().size) {
            throw IllegalArgumentException("[ERROR] 로또 번호는 중복 될 수 없습니다.")
        }
    }
}
