package lotto

private const val LOTTO_TICKET_PRICE = 1000
private const val LOTTO_TICKET_REMAINDER = 0
private const val EROOR_INPUT_MONEY = "로또 한장은 1,000원 입니다. 다시 입력해주세요"

class LottoSeller(private val lottoMoney: Int) {
//랜덤수에 맞게 로또를 판매하는 곳, 돈을 받은 만큼 줬지?
    //what/who 계속 생각하기!
    //어떤 행위가 필요한가! 이 행위를 수행할 객체는 어디인가!

    fun generateLottoNumbers(): List<LottoGenerator> {
        //고객이 요구한 만큼 받아서 한번에 주는 거
        val result = mutableListOf<LottoGenerator>()
        repeat(checkLottoTicketCount()) {
            result.add(LottoGenerator())
        }
        return result
    }

    private fun checkLottoTicketCount(): Int {   //x원 받았는데 로또 몇장이냐?에 대한 대답
        //가격을 파는 사람이 알지 사는 사람이 우째 안대유
        if (lottoMoney % LOTTO_TICKET_PRICE != LOTTO_TICKET_REMAINDER) {
            return throw IllegalArgumentException(EROOR_INPUT_MONEY + "돈을 입력받는 곳으로 다시 가야됨")
        }
        return lottoMoney / LOTTO_TICKET_PRICE
    }
}
