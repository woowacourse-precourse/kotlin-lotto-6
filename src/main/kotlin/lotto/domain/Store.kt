package lotto.domain

import camp.nextstep.edu.missionutils.Console

class Store {
    private var cost: Int = 0
    fun payToBuy() {
        println("구입금액을 입력해 주세요.")
        cost = Console.readLine().toInt()
    }
}