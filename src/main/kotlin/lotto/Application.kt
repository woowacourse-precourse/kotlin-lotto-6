package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val lotto = publishLotto()
    println(lotto.getSortedNumbers())

    val user = User()
    user.inputAmount()
    println(user.amount)

    user.inputAmount()
    println(user.amount)
}

// 로또 번호 생성을 캡슐화를 해야 하나 고민
fun publishLotto(): Lotto = Lotto(generateLottoNumbers())

fun generateLottoNumbers(): List<Int> =
    Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.NUMBER_COUNT)