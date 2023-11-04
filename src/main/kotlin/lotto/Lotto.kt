package lotto
import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) { "[ERROR] 6개의 숫자를 입력하세요." }
        validateLottoNumbers(numbers)
    }
    companion object {
        const val LOTTO_SIZE = 6
        const val LOTTO_START_NUM = 1
        const val LOTTO_END_NUM = 45
    }

    private fun validateLottoNumbers(numbers: List<Int>) {
        if (numbers.toSet().size != numbers.size) {
            throw IllegalArgumentException("[ERROR] 중복되는 숫자가 없어야 합니다.")
        }

        if (numbers.any { it < LOTTO_START_NUM || it > LOTTO_END_NUM }) {
            throw IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자만 입력하세요.")
        }
    }
}
