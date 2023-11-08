package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class User {
    var purchaseMoney: Int = 0
    val lottoTickets = mutableListOf<List<Int>>()
    var bonusNumber: Int = 0
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
        println("\n${ticketCounts}개를 구매했습니다.")
        for (count in 0 until ticketCounts) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            numbers.sort()
            lottoTickets.add(numbers)
            println(numbers)
        }
    }

    fun inputLottoNumbers(): List<Int> {
        var validation: Boolean = false
        var lottoNumbers: String = ""
        while (!validation) {
            println("\n당첨 번호를 입력해 주세요.")
            lottoNumbers = Console.readLine()
            validation = validator.couldConvertIntList(lottoNumbers)
        }
        return convertIntList(lottoNumbers)
    }

    private fun convertIntList(winning: String): List<Int> {
        var winningNumbers = mutableListOf<Int>()
        for (number in winning.split(",")) {
            winningNumbers.add(number.toInt())
        }
        winningNumbers.sort()
        return winningNumbers
    }

    fun inputBonusNumber() {
        var validation: Boolean = false
        var bonus: String = ""
        while (!validation) {
            println("\n보너스 번호를 입력해 주세요.")
            bonus = Console.readLine()
            validation = validator.validateBonusNumber(bonus)
        }
        bonusNumber = bonus.toInt()
    }
}