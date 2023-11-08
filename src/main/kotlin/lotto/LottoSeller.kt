package lotto


class LottoSeller() {
    //랜덤수에 맞게 로또를 판매하는 곳, 돈을 받은 만큼 줬지?
    //what/who 계속 생각하기!
    //어떤 행위가 필요한가! 이 행위를 수행할 객체는 어디인가!
    fun generateLottoNumbers(lottoMoney: Int): List<LottoNumberGenerator> {
        //고객이 요구한 만큼 받아서 한번에 주는 거
        val result = mutableListOf<LottoNumberGenerator>()
        repeat(lottoMoney) {
            result.add(LottoNumberGenerator())
        }
        return result
    }

    //야 이거 잘못된 당첨번호 로또잖아!
    //다시 적어서 내렴
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

    fun checkLottoTicketCount(lottoMoney: String): Int {   //x원 받았는데 로또 몇장이냐?에 대한 대답
        //가격을 파는 사람이 알지 사는 사람이 우째 안대유
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


    //미쳐버려 이거 잘못된 보너스 번호잖아!
    //당첨번호랑 안겹치는 걸로 다시 적어서 내렴
    fun checkLottoHasBonusNum(lottoList: List<Int>, bonusNum: Int): Int {
        return try {
            checkContainNum(lottoList, bonusNum)
            checkBonuslength(bonusNum)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            LottoSeller().checkLottoHasBonusNum(lottoList, User().inputBonusNum())
        }
    }

    private fun checkContainNum(lottoList: List<Int>, bonusNum: Int): Int {
        if (lottoList.contains(bonusNum)) throw IllegalArgumentException(ERROR_INPUT_NUMBER_DISTINCT)
        return bonusNum
    }

    private fun checkBonuslength(bonusNum: Int): Int {
        if (bonusNum !in 1..45) throw IllegalArgumentException(ERROR_INPUT_NUMBER_RANGE)
        return bonusNum
    }

    companion object {
        private const val LOTTO_TICKET_PRICE = 1000
        private const val LOTTO_TICKET_REMAINDER = 0
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
