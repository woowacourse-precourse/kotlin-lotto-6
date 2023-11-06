package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {"[ERROR] 로또 번호는 정확히 6개여야 합니다."}
        require(numbers.toSet().size == 6) {"[ERROR] 로또 번호는 중복되지 않는 6개여야 합니다."}
        validateLottoNumberRange()
    }

    private fun validateLottoNumberRange() {
        for (num in numbers) {
            if (num !in 1.. 45) {
                throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
                return
        }
    }
    fun getLotto(): List<Int>{
        return numbers
    }
}
