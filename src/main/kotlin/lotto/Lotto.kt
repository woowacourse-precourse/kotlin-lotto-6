package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        require(isLottoSize()) { NUMBER_SIZE_ERROR }
        require(isDuplicated()) { NUMBER_DUPLICATE_ERROR }
        numbers.forEach {
            require(isNumberInRange(it)) { NUMBER_NOT_IN_RANGE_ERROR }
        }
    }

    private fun isNumberInRange(it: Int) = it in MIN_NUM..MAX_NUM

    private fun isDuplicated() = numbers.distinct().size == LOTTO_SIZE

    private fun isLottoSize() = numbers.size == LOTTO_SIZE

    fun getLottoNumbers(): List<Int> {
        return numbers
    }

    companion object {
        const val LOTTO_SIZE = 6
        const val MIN_NUM = 1
        const val MAX_NUM = 45
        const val NUMBER_SIZE_ERROR = "[ERROR] 번호를 6개만 입력해주세요"
        const val NUMBER_DUPLICATE_ERROR = "[ERROR] 중복된 번호가 있습니다."
        const val NUMBER_NOT_IN_RANGE_ERROR = "[ERROR] 1부터 45 사이의 수를 입력해주세요."
    }
}
