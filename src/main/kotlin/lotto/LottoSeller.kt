package lotto


class LottoSeller() {
    fun generateLottoNumbers(lottoMoney: Int): List<LottoNumberGenerator> {
        val result = mutableListOf<LottoNumberGenerator>()
        repeat(lottoMoney) {
            result.add(LottoNumberGenerator())
        }
        return result
    }

    fun isValidateLotto(): List<Int> {
        return try {
            Lotto(User().inputLottoNumber()).checkLottoNumberException()
        } catch (e: IllegalArgumentException) {
            checkExceptionStatement(e)
            LottoSeller().isValidateLotto()
        }
    }

    private fun checkExceptionStatement(e: IllegalArgumentException) {
        when (e.message) {
            ERROR_INPUT_NUM_LENGTH -> println(ERROR_INPUT_NUM_LENGTH_PRINT)
            ERROR_INPUT_NUM -> println(ERROR_INPUT_NUM_PRINT)
            else -> println(ERROR_TRY_AGAIN_NUM_PRINT)
        }
    }

    fun checkLottoTicketCount(lottoMoney: String): Int {
        lottoMoney.forEach { char ->
            val charConvertedToCode = char.code
            if ((charConvertedToCode > 57) or (charConvertedToCode < 48)) {
                throw IllegalArgumentException(ERROR_ONLY_INPUT_INT)
            }
        }
        if (lottoMoney.toInt() % LOTTO_TICKET_PRICE != LOTTO_TICKET_REMAINDER) {
            throw IllegalArgumentException(ERROR_INPUT_MONEY)
        }

        return lottoMoney.toInt() / LOTTO_TICKET_PRICE
    }

    fun checkLottoHasBonusNum(lottoList: List<Int>, bonusNum: Int): Int {
        checkContainNum(lottoList, bonusNum)
        checkBonusLength(bonusNum)
        return bonusNum
    }

    private fun checkContainNum(lottoList: List<Int>, bonusNum: Int): Int {
        if (lottoList.contains(bonusNum)) throw IllegalArgumentException(ERROR_INPUT_NUMBER_DISTINCT)
        return bonusNum
    }

    private fun checkBonusLength(bonusNum: Int): Int {
        if (bonusNum !in 1..45) throw IllegalArgumentException(ERROR_INPUT_NUMBER_RANGE)
        return bonusNum
    }

    companion object {
        const val LOTTO_TICKET_PRICE = 1000
        const val LOTTO_TICKET_REMAINDER = 0
        private const val ERROR_INPUT_MONEY = "[ERROR]로또 한장은 1,000원 입니다. 다시 입력해주세요"
        private const val ERROR_ONLY_INPUT_INT = "[ERROR] 정수만 입력 가능합니다"
        private const val ERROR_INPUT_NUM_LENGTH = "For input string: \"\""
        private const val ERROR_INPUT_NUM_LENGTH_PRINT = "[ERROR]번호 개수를 체크해주세요"
        private const val ERROR_INPUT_NUM = "Failed requirement."
        private const val ERROR_INPUT_NUM_PRINT = "[ERROR]잘못된 번호를 입력했습니다."
        private const val ERROR_TRY_AGAIN_NUM_PRINT = "[ERROR]당첨번호를 다시 입력해주세요"
        private const val ERROR_INPUT_NUMBER_RANGE = "[ERROR]1~45사이의 수가 아닙니다"
        private const val ERROR_INPUT_NUMBER_DISTINCT = "[ERROR] 이미 입력한 번호 입니다."
    }
}
