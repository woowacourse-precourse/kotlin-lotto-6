package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        vaildateLottoNumbers();
    }

    fun vaildateLottoNumbers(): Boolean {
        require(numbers.size == 6) {
            println(ERROR_MESSAGE_HEADER + ERROR_LOTTO_NUMBER_SIZE_IS_NOT_SIX)
            return false
        }
        require(numbers.distinct().size != 6) {
            println(ERROR_MESSAGE_HEADER + ERROR_LOTTO_NUMBER_CANT_DUPLICATE)
            return false
        }
        return true
    }
    // TODO: 추가 기능 구현
}

const val ERROR_MESSAGE_HEADER = "[ERROR] "
const val ERROR_LOTTO_NUMBER_SIZE_IS_NOT_SIX = "로또 당첨 번호는 6개의 정수여야 합니다."
const val ERROR_LOTTO_NUMBER_IS_OUT_OF_RANGE = "로또 당첨 번호는 1~45사이의 정수여야 합니다."
const val ERROR_LOTTO_NUMBER_CANT_DUPLICATE = "로또 당첨 번호는 중복될 수 없습니다."