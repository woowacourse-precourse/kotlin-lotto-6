package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {

    println("구입금액을 입력해 주세요.")
    val purchaseAmount = readPurchaseAmount()
    println()

    val myPurchaselottos = purchaseLottos(purchaseAmount)
    println()

}

fun readPurchaseAmount(): Int {
    while (true) {
        try {
            val input = Console.readLine().toInt()
            if (input % 1000 != 0) {
                throw IllegalArgumentException("[ERROR] 유효한 금액을 입력하세요.")
            }
            return input
        } catch (e: NumberFormatException) {
            println("[ERROR] 유효한 숫자를 입력하세요.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun purchaseLottos(purchaseAmount: Int): List<Lotto> {
    val numberOfLottos = purchaseAmount / 1000
    val myPurchaselottos = mutableListOf<Lotto>()
    for (i in 1..numberOfLottos) {
        myPurchaselottos.add(Lotto.createRandomLotto())
    }
    println("${numberOfLottos}개를 구매했습니다.")
    myPurchaselottos.forEach { lotto ->
        println(lotto.getNumbers().sorted())
    }
    return myPurchaselottos
}

