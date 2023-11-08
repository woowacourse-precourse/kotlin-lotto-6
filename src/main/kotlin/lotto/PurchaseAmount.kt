package lotto

import camp.nextstep.edu.missionutils.Randoms

class PurchaseAmount {
    var purchaseAmount = 0
    fun enterNumber(): Int {
        println("구입금액을 입력해 주세요.")
        purchaseAmount = readln().toInt()  // readln 뭔지 찾아보기
        if (purchaseAmount % 1000 != 0)
            throw IllegalArgumentException("Error")
        return purchaseAmount/1000
    }

}