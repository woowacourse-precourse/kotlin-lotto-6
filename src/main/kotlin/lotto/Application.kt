package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    print(inputPurchaseAmount())
}

fun inputPurchaseAmount(): Int {
    println("구입금액을 입력해 주세요.")
    return Console.readLine().toInt()
}


