package lotto
import camp.nextstep.edu.missionutils.Console

object InitSetting {
    private var money: Int = 0
    private var ticketCount: Int = 0

    fun initSet() {
        println("구입금액을 입력해 주세요")
        money = Ticket().inputmoney() // Call the inputmoney function

        if (money == 0) {
            throwException()
        }

        ticketCount = Ticket().inputticket(money)

        println("$ticketCount 개를 구입했습니다.")
    }

    fun printrandomlotto() {
        if (money == 0 || ticketCount == 0) {
            println("initSet을 먼저 호출하여 money 및 ticketCount를 설정해야 합니다.")
            return
        }

        for (i in 1..ticketCount) {
            val lottoNumbers = Lotto.randomlotto() // Function call
            println(lottoNumbers)
        }
    }
    fun initSetans() {
        println("당첨 번호를 입력해 주세요.")
        val answerlotto: IntArray = answer_lotto().answer() // Call the answer function
        println()
        println("보너스 번호를 입력해 주세요.")
        val answerbonus:Int = answer_lotto().bonus()

    }


    private fun throwException() {
        throw IllegalArgumentException("")
    }
}
