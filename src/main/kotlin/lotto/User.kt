package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class User {
    var purchaseMoney: Int = 0
    val lottoTickets = mutableListOf<List<Int>>()
    val validator = Validator()

    fun inputPurchaseMoney() {
        var validation: Boolean = false
        var money: String = ""
        while (!validation) {
            println("구입금액을 입력해 주세요.")
            money = Console.readLine()
            validation = validator.validatePurchaseMoney(money)
        }
        purchaseMoney = money.toInt()
    }

    fun purchaseLottoTickets() {
        val ticketCounts: Int = purchaseMoney / 1000
        println("${ticketCounts}개를 구매했습니다.")
        for (count in 0 until ticketCounts) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            numbers.sort()
            lottoTickets.add(numbers)
            println(numbers)
        }
    }

    fun inputLottoNumbers(): String {
        var validation: Boolean = false
        var lottoNumbers: String = ""
        while (!validation) {
            println("당첨 번호를 입력해 주세요.")
            lottoNumbers = Console.readLine()
            validation = validator.couldConvertIntList(lottoNumbers)
        }
        return lottoNumbers
    }
}