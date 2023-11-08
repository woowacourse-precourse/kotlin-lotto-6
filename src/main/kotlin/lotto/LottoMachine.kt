package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine(payment: Int) {

    private val numberOfTicket = payment / 1000

    init {
        require(payment >= 1000) {"[ERROR] 1000원 이상 입력해 주세요."}
        require(payment % 1000 == 0) {"[ERROR] 1000원 단위로 입력해 주세요."}
    }

    fun generateLotto(): List<Lotto> {

        val lottoTickets = mutableListOf<Lotto>()

        repeat(numberOfTicket) {
            val sortedLotto = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
            lottoTickets.add(sortedLotto)
        }
        println("${numberOfTicket}개를 구매했습니다.")
        return lottoTickets
    }
}