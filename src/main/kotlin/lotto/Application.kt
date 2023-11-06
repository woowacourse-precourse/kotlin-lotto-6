package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
//    val lotto = publishLotto()
//    println(lotto.getSortedNumbers())

    val user = User()
//    val amount = inputAmountFromUser(user)
//    println(amount)

//    val winningNumbers = inputWinningNumbersFromUser(user)
//    println(winningNumbers)

    val bonusNumber = inputBonusNumberFromUser(user)
    println(bonusNumber)
}

fun inputAmountFromUser(user: User): Int {
    while (user.amount == 0) {
        try {
            user.inputAmount()
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
        }
    }

    return user.amount
}

fun inputWinningNumbersFromUser(user: User): List<Int> {
    while (user.winningNumbers.isEmpty()) {
        try {
            user.inputWinningNumbers()
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
        }
    }

    return user.winningNumbers
}

fun inputBonusNumberFromUser(user: User): Int {
    while (user.bonusNumber == 0) {
        try {
            user.inputBonusNumber()
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
        }
    }

    return user.bonusNumber
}



// 로또 번호 생성을 캡슐화를 해야 하나 고민
fun publishLotto(): Lotto = Lotto(generateLottoNumbers())

fun generateLottoNumbers(): List<Int> =
    Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.NUMBER_COUNT)

