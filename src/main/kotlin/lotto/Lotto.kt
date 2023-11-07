package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { NUMBER_SIZE_ERROR }
        require(numbers.distinct().size == 6) { NUMBER_DUPLICATE_ERROR }
        numbers.forEach {
            require(it in 1..45) { NUMBER_NOT_IN_RANGE_ERROR }
        }
    }

    fun getLottoNumbers(): List<Int> {
        return numbers
    }

    companion object {
        const val NUMBER_SIZE_ERROR = "[ERROR] 번호를 6개만 입력해주세요"
        const val NUMBER_DUPLICATE_ERROR = "[ERROR] 중복된 번호가 있습니다."
        const val NUMBER_NOT_IN_RANGE_ERROR = "[ERROR] 1부터 45 사이의 수를 입력해주세요."
    }
}
