package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class LottoMachine() {
    fun payLottery(): Int {
        println("구입금액을 입력해 주세요.")
        val payment = Console.readLine()
        validatePayment(payment)
        return payment.toInt()
    }

    private fun validatePayment(payment: String): String {
        if (payment.isEmpty()) throw IllegalArgumentException("[ERROR] 값을 입력해주세요.")
        if (payment.isBlank()) throw IllegalArgumentException("[ERROR] 값을 입력해주세요.")
        if (!payment.matches(Regex("^\\d*\$"))) throw IllegalArgumentException("[ERROR] 숫자만 입력해주세요.")
        if ((payment.toInt() % 1000) != 0) throw IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.")
        if (payment.toInt() < 1000) throw IllegalArgumentException("[ERROR] 최소 1000원 이상 입력해주세요.")
        return payment
    }
    fun countNumberOfTickets(payment: Int): Int {
        val numberOfTicket = payment / 1000
        println("${numberOfTicket}개를 구매했습니다.")
        return numberOfTicket
    }

    fun generateLotto(): List<List<Int>> {
        val payment = payLottery()
        val numberOfTicket = countNumberOfTickets(payment)
        val lottoTickets = mutableListOf<List<Int>>()

        repeat(numberOfTicket) {
            var sortedLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            lottoTickets.add(sortedLotto)
        }
        println(lottoTickets)
        return lottoTickets
    }
}

