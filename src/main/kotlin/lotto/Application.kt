package lotto

import camp.nextstep.edu.missionutils.Console.readLine

private var lottoPurchaseAmount: Int = -1

fun main() {

    println("구입금액을 입력해 주세요.")
    inputLottoPurchaseAmount()

}

private fun inputLottoPurchaseAmount() {
    lottoPurchaseAmount = readLine().toInt()
}
