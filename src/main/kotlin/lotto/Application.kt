package lotto
import camp.nextstep.edu.missionutils.Randoms


fun main() {
    println("구입금액을 입력해 주세요.")

    val purchaseAmount = getPurchaseAmount()
}

fun generateLottoNumbers(purchaseAmount: Int): List<Lotto> {
    val lottoNumbers = mutableListOf<Lotto>()
    for (i in 1..(purchaseAmount / 1000)) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        val lotto = Lotto(numbers)
        lottoNumbers.add(lotto)
    }
    return lottoNumbers
}

fun getPurchaseAmount(): Int {
    var amount = 1
    while (amount % 1000 != 0) {
        amount=inputPurchase(amount)
    }
    return amount
}

fun inputPurchase(amount: Int): Int {
    var mutableAmount = amount
    try {
        mutableAmount = readLine()?.toInt()!!
    } catch (e: NumberFormatException) {
        println("[ERROR] 잘못된 입력 형식입니다.")
        return amount
    }
    if (mutableAmount % 1000 != 0) {
        println("[ERROR] 구입 금액은 1,000원 단위로 입력되어야 합니다.")
        return amount
    }
    if (mutableAmount == 0) {
        println("[ERROR] 구입 금액은 1000원 이상이어야 합니다.")
        return amount
    }
    return mutableAmount
}