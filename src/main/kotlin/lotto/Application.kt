package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
//    val lotto = publishLotto()
//    println(lotto.getSortedNumbers())

    val user = User()
//    val amount = inputAmountFromUser(user)
//    println(amount)

    user.inputWinningNumbers()
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

// 로또 번호 생성을 캡슐화를 해야 하나 고민
fun publishLotto(): Lotto = Lotto(generateLottoNumbers())

fun generateLottoNumbers(): List<Int> =
    Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.NUMBER_COUNT)

