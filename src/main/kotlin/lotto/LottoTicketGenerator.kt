import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LottoTicketGenerator {
    fun createAutoTicket() = Lotto(
        Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted().toList()
    )
}