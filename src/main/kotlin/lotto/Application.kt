package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("구입금액을 입력해 주세요.")

    val purchaseAmount = getPurchaseAmount()
    val lottoTickets = generateLottoNumbers(purchaseAmount)

    println("")
    println("${lottoTickets.size}개를 구매했습니다.")
    for (ticket in lottoTickets) {
        println("[${ticket.getNumbers().joinToString(", ")}]")
    }

    val winningNumbers = getWinningNumbers()
    val bonusNumber = getBonusNumber()

    println("당첨 번호: [${winningNumbers.joinToString(", ")}]")
    println("보너스 번호: [$bonusNumber]")

    return
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
        amount = inputPurchase(amount)
    }
    return amount
}

fun inputPurchase(amount: Int): Int {
    var confirmAmount = amount
    try {
        confirmAmount = Console.readLine()?.toInt()!!
    } catch (e: NumberFormatException) {
        println("[ERROR] 잘못된 입력 형식입니다.")
        return amount
    }
    if (confirmAmount % 1000 != 0) {
        println("[ERROR] 구입 금액은 1,000원 단위로 입력되어야 합니다.")
        return amount
    }
    if (confirmAmount == 0) {
        println("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.")
        return amount
    }
    return confirmAmount
}

fun getWinningNumbers(): List<Int> {
    var numbers = listOf(0)
    println("당첨 번호를 입력해 주세요.")
    while (numbers == listOf(0)) {
        numbers = inputWinningNumbers()
    }
    return numbers
}

fun inputWinningNumbers(): List<Int> {
    try {
        var numbers: List<Int>
        val input = Console.readLine()
        numbers = input?.split(",")!!.mapNotNull { it.trim().toIntOrNull() }
        validateLottoNumbers(numbers)
        return numbers
    } catch (e: NumberFormatException) {
        println("[ERROR] 잘못된 입력 형식입니다.")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
    return listOf(0)
}

fun getBonusNumber(): Int {
    var number = 0
    println("보너스 번호를 입력해 주세요.")
    while (number < 1 || number > 45) {
        number = inputBonusNumbers()
    }
    return number
}

fun inputBonusNumbers(): Int {
    var result = 0
    try {
        result = Console.readLine()!!.toInt()
        validateBonusNumbers(result)
        return result
    } catch (e: NumberFormatException) {
        println("[ERROR] 잘못된 입력 형식입니다.")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
    return result
}

fun validateLottoNumbers(numbers: List<Int>) {
    if (numbers.any { it < 1 || it > 45 } || numbers.size != 6) {
        throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자 6개를 입력해야 합니다.")
    }
    val uniqueNumbers = numbers.toSet()
    if (uniqueNumbers.size != 6) {
        throw IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 포함되어 있습니다.")
    }
}

fun validateBonusNumbers(number: Int) {
    if (number < 1 || number > 45) {
        throw IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
    }
}