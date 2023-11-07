package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoTicketGenerator {
    fun createAutoTicket() = Lotto(Randoms.pickUniqueNumbersInRange(LottoNumber.MIN_LOTTO_NUMBER.number, LottoNumber.MAX_LOTTO_NUMBER.number, LottoNumber.LOTTO_NUMBER_COUNT.number).sorted().toList())
}