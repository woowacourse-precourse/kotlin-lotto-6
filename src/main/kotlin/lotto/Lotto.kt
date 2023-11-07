package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { ERROR_LOTTO_NUMBER_SIZE }
        require(numbers.all { it in 1..45 }) { ERROR_LOTTO_NUMBER_RANGE }
        require(numbers.distinct().size == numbers.size) { ERROR_LOTTO_NUMBER_DUPLICATE }
    }
    fun matchCount(prizeLottoNumber: List<Int>, bonusNumber: Int):Pair<Int, Boolean>{
        val lottoNumberCount = numbers.count { it in prizeLottoNumber }
        val bonusNumberMatchStatus = numbers.any { it == bonusNumber }
        return Pair(lottoNumberCount, bonusNumberMatchStatus)
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
        private const val ERROR_LOTTO_NUMBER_SIZE = "[ERROR] 로또 번호의 수는 6개여야 합니다."
        private const val ERROR_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
        private const val ERROR_LOTTO_NUMBER_DUPLICATE = "[ERROR] 로또 번호는 중복된 값이 있으면 안됩니다."
    }
}
