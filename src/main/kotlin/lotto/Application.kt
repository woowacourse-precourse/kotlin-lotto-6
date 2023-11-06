package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


fun main() {
    var numberOfLottoTickets = 0
    val lottos = mutableListOf<Lotto>()
    println("구입금액을 입력해 주세요.")
    validateAndThrowExceptionIfError { numberOfLottoTickets = getLottoPurchaseAmount() }
    println("${numberOfLottoTickets}개를 구매했습니다.")
    lottos.addAll(getLottoWinningNumbers(lottos, numberOfLottoTickets))
    lottos.forEach {
        it.printWinningNumbers()
    }
}

fun getLottoPurchaseAmount(): Int {
    val lottoPurchaseAmount = Console.readLine()
    val numberOfLottoTickets = lottoPurchaseAmount.toInt()
    if (numberOfLottoTickets % 1000 == 0) {
        return numberOfLottoTickets / 1000
    } else {
        throw IllegalArgumentException("$errorPrefix 구입금액은 1000원 단위의 숫자 여야합니다.")
    }
}

fun getLottoWinningNumbers(
    lottos: MutableList<Lotto>,
    numberOfLottoTickets: Int
): MutableList<Lotto> {
    repeat(numberOfLottoTickets) {
        val numbers = Randoms.pickUniqueNumbersInRange(
            minLottoWinningNumber,
            maxLottoWinningNumber,
            lottoWinningNumberQuantity
        )
        Lotto(numbers).apply {
            lottos.add(this)
        }
    }
    return lottos
}