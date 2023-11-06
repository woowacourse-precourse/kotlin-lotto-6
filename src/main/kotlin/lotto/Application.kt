package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("구입금액을 입력해 주세요.")
    validateAndThrowExceptionIfError { getLottoPurchaseAmount() }
}

fun getLottoPurchaseAmount(): Int {
    val lottoPurchaseAmount = Console.readLine()
    val numberOfLottoTickets = lottoPurchaseAmount.toInt()
    if (numberOfLottoTickets % 1000 == 0) {
        return numberOfLottoTickets
    } else {
        throw IllegalArgumentException("$errorPrefix 구입금액은 1000원 단위의 숫자 여야합니다.")
    }
}
