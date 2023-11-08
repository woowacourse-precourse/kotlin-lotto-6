package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6)
        checkLottoNumber(numbers)
    }

    private fun checkLottoNumber(numbers: List<Int>) {
        val lottoNumberRange = 1..45
        numbers.forEach {
            if (!lottoNumberRange.contains(it)) {
                throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
        }
    }

}
