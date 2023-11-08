package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { ERROR_SIZE }
        require(numbers.all { it in 1..45 }) { ERROR_NUMBER_RANGE }
        require(numbers.distinct().size == numbers.size) { ERROR_DUPLICATE }
    }
    fun checkMatching(prizeLottoNumber: List<Int>, bonusNumber: Int):Pair<Int, Boolean>{
        val lottoNumber = numbers.count { it in prizeLottoNumber }
        val bonusNumberMatchStatus = numbers.any { it == bonusNumber }
        return Pair(lottoNumber, bonusNumberMatchStatus)
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
        private const val ERROR_SIZE = "[ERROR] 6개의 로또 번호를 입력하세요"
        private const val ERROR_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
        private const val ERROR_DUPLICATE = "[ERROR] 중복된 값은 입력할 수 없습니다."
    }
}
