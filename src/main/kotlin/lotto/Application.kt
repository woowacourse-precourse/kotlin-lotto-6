package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


fun main() {
    var numberOfLottoTickets = 0
    val lottos = mutableListOf<Lotto>()
    validateAndThrowExceptionIfError { numberOfLottoTickets = getLottoPurchaseAmount() }
    println("${numberOfLottoTickets}개를 구매했습니다.")
    getLottoWinningNumbers(lottos, numberOfLottoTickets)
    lottos.forEach {
        it.printWinningNumbers()
    }
    validateAndThrowExceptionIfError { getUserLottoNumbers() }
}

fun getLottoPurchaseAmount(): Int {
    println("구입금액을 입력해 주세요.")
    val lottoPurchaseAmount = Console.readLine()
    println()
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
) {
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
}

fun getUserLottoNumbers(): List<Int> {
    println("당첨 번호를 입력해 주세요.")
    val userInput = Console.readLine()
    val userLottoNumbers = userInput.split(",").map {
        it.toInt()
    }
    if (userLottoNumbers.size == 6) {
        return userLottoNumbers
    } else {
        throw IllegalArgumentException("$errorPrefix 당첨 번호는 1~45 사이의 중복되지 않는 숫자를 , 로 구분하여 입력해야 합니다.")
    }
}

