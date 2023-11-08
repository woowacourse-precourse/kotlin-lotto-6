package lotto

private const val LOTTO_TICKET_PRICE = 1000
private const val LOTTO_TICKET_REMAINDER = 0
private const val ERROR_INPUT_MONEY = "로또 한장은 1,000원 입니다. 다시 입력해주세요"

class LottoSeller() {
    //랜덤수에 맞게 로또를 판매하는 곳, 돈을 받은 만큼 줬지?
    //what/who 계속 생각하기!
    //어떤 행위가 필요한가! 이 행위를 수행할 객체는 어디인가!
    private var inputLottoMoney = 0
    fun generateLottoNumbers(lottoMoney: Int): List<LottoNumberGenerator> {
        //고객이 요구한 만큼 받아서 한번에 주는 거
        val result = mutableListOf<LottoNumberGenerator>()
        inputLottoMoney = lottoMoney
        repeat(checkLottoTicketCount()) {
            result.add(LottoNumberGenerator())
        }
        return result
    }

    //야 이거 잘못된 당첨번호 로또잖아!
    //다시 적어서 내렴
    fun isValidateLotto() {
        try {
            Lotto(User().inputLottoNumber()).checkLottoNumberException()
        } catch (e: Exception) {
            checkExceptionStatement(e)
            LottoSeller().isValidateLotto()
        }
    }

    private fun checkExceptionStatement(e: Exception) {
        when (e.message) {
            ERROR_INPUT_NUM_LENGTH -> println(ERROR_INPUT_NUM_LENGTH_PRINT)
            ERROR_INPUT_NUM -> println(ERROR_INPUT_NUM_PRINT)
            else -> println(ERROR_TRY_AGAIN_NUM_PRINT)
        }
    }

    //미쳐버려 이거 잘못된 보너스 번호잖아!
    //당첨번호랑 안겹치는 걸로 다시 적어서 내렴
    fun checkLottoHasBonusNum() {

    }

    private fun checkLottoTicketCount(): Int {   //x원 받았는데 로또 몇장이냐?에 대한 대답
        //가격을 파는 사람이 알지 사는 사람이 우째 안대유
        if (inputLottoMoney % LOTTO_TICKET_PRICE != LOTTO_TICKET_REMAINDER) {
            throw IllegalArgumentException(ERROR_INPUT_MONEY)
        }
        return inputLottoMoney / LOTTO_TICKET_PRICE
    }

    companion object {
        const val ERROR_INPUT_NUM_LENGTH = "For input string: \"\""
        const val ERROR_INPUT_NUM_LENGTH_PRINT = "[ERROR]번호 개수를 체크해주세요"
        const val ERROR_INPUT_NUM = "Failed requirement."
        const val ERROR_INPUT_NUM_PRINT = "[ERROR]잘못된 번호를 입력했습니다."
        const val ERROR_TRY_AGAIN_NUM_PRINT = "[ERROR]당첨번호를 다시 입력해주세요"
    }
}
