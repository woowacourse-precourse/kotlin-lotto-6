package lotto

import camp.nextstep.edu.missionutils.Console

class User {
    var purchaseMoney: Int = 0
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
    
}