package lotto.Controller
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.Model.Lotto
import lotto.View.LottoView
import org.junit.jupiter.api.Test

object LottoGame {
    fun start() {
        try{
            LottoView.printPurchasePrompt()
            val money = Console.readLine()?.toInt()?: throw IllegalArgumentException("[ERROR] 유효하지 않은 금액입니다.")
            if (money % 1000 != 0) throw IllegalArgumentException ("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.")

            val lottoTicket = buyLottoTicket(money)
            LottoView.printLottoPurchase(lottoTicket.size)
            LottoView.printLottoNumbers(lottoTicket)

            val winNumber = inputWinningNumber()
            val bonusNumber = inputBonusNumber(winNumber)
            val result = calculatResults(lottoTicket, winNumber,bonusNumber)

            LottoView.printWinningStatistics(result , calculateRevenueRate(result,money))
        }catch (e :IllegalArgumentException) {
            LottoView.printErrorMessage(e.message ?: "알수없는 에러발생")
            start()
        }
    }
    private fun buyLottoTicket(money: Int): List<Lotto> {
        val lottoTicket = mutableListOf<Lotto>()
        repeat(money / 1000) {
            val number = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())

            lottoTicket.add(number)
        }
        return lottoTicket
    }

    private fun inputWinningNumber(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        val winNumber = Console.readLine()?.split(",")
                ?.filter { it.matches(Regex("\\d+")) }
                ?.map { it.toInt() }
                ?.takeIf { it.size == 6 }
                ?: throw IllegalArgumentException("유효하지 않은 입력입니다. 숫자 6개를 입력해주세요.")
        return  winNumber
    }


    private  fun inputBonusNumber(winNumber: List<Int>) :Int {
        while (true) {
            try {
                println()
                println("보너스 번호를 입력해 주세요.")
                val bonusNumberInput = Console.readLine()
                val bonusNumber = bonusNumberInput?.toIntOrNull()
                        ?: throw IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.")
                if (bonusNumber in winNumber || bonusNumber !in 1..45) {
                    throw IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 달라야 하며 1부터 45 사이의 값이어야 합니다.")
                }
                return bonusNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

    }
    fun calculatResults(lottoTickets :List<Lotto>, winNumber: List<Int>, bonusNumber: Int) :Map<Int,Int> {
        val result = mutableMapOf(3 to 0, 4 to 0, 5 to 0, 5 to 0, 6 to 0, 7 to 0)

        for (ticket in lottoTickets) {
            val matchCount = ticket.match(winNumber)
            if (matchCount == 5 && ticket.BonusNumber(bonusNumber)) {
                result[7] = (result[7] ?: 0) + 1
            } else {
                result[matchCount] = (result[matchCount] ?: 0) + 1
            }
        }

        return result
    }
    fun calculateRevenueRate(result : Map<Int ,Int> , money :Int) :Double {
        var totalPrize  = 0.0
        result.forEach { (matchCount , count ) ->
            val prize = when(matchCount) {
                3 -> 5000 * count
                4 -> 50000 * count
                5 -> 1500000 * count
                6 -> 30000000 * count
                7 -> 2000000000 * count
                else -> 0
            }
            totalPrize +=prize
        }
        return  (totalPrize/money) *100
    }
}