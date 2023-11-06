package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


fun main() {
    var numberOfLottoTickets = 0
    val lottos = mutableListOf<Lotto>()
    val userLottoNumbers = mutableSetOf<Int>()
    var userLottoBonusNumbers = 0
    validateAndThrowExceptionIfError { numberOfLottoTickets = getLottoPurchaseAmount() }
    println("${numberOfLottoTickets}개를 구매했습니다.")
    getLottoWinningNumbers(lottos, numberOfLottoTickets)
    lottos.forEach {
        it.printWinningNumbers()
    }
    validateAndThrowExceptionIfError { userLottoNumbers.addAll(getUserLottoNumbers()) }
    validateAndThrowExceptionIfError {
        userLottoBonusNumbers = getUserBonusLottoNumbers(userLottoNumbers.toList())
    }
}

fun getLottoPurchaseAmount(): Int {
    println("구입금액을 입력해 주세요.")
    val lottoPurchaseAmount = Console.readLine()
    println()
    val numberOfLottoTickets = lottoPurchaseAmount.toInt()
    if (numberOfLottoTickets % 1000 == 0) return numberOfLottoTickets / 1000
    else throw IllegalArgumentException("$errorPrefix 구입금액은 1000원 단위의 숫자 여야합니다.")

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
    val userLottoNumbers = userInput.split(",").filter {
        it.isNotEmpty()
    }.map {
        it.toIntOrNull()
    }
    return validateUserLottoNumbers(userLottoNumbers)
}

fun validateUserLottoNumbers(userLottoNumbers: List<Int?>): List<Int> {
    val isUserInputNumber = !userLottoNumbers.contains(null)
    val isRangedNumber =
        userLottoNumbers.filter { it in minLottoWinningNumber..maxLottoWinningNumber }.size == lottoWinningNumberQuantity
    val isAppropriateCnt = userLottoNumbers.size == lottoWinningNumberQuantity
    if (isUserInputNumber && isRangedNumber && isAppropriateCnt) return userLottoNumbers.map { it!! }
    else throw IllegalArgumentException("$errorPrefix 당첨 번호는 1~45 사이의 중복되지 않는 숫자를 , 로 구분하여 6개를 입력해야 합니다.")
}

fun getUserBonusLottoNumbers(userLottoNumbers: List<Int>): Int {
    println("보너스 번호를 입력해 주세요.")
    val userBonusLottoNumberInput = Console.readLine()
    return validateUserBonusLottoNumbers(userBonusLottoNumberInput, userLottoNumbers)
}

fun validateUserBonusLottoNumbers(userBonusInput: String, userLottoNumbers: List<Int>): Int {
    val userLottoNumber = userBonusInput.toIntOrNull()
    val isNumber = userLottoNumber != null
    val isRangedNumber = userLottoNumber in minLottoWinningNumber..maxLottoWinningNumber
    val isNotDuplicatedNumber = !userLottoNumbers.contains(userLottoNumber)
    if (isNumber && isRangedNumber && isNotDuplicatedNumber) return userLottoNumber.toString()
        .toInt()
    else throw IllegalArgumentException("$errorPrefix 보너스 번호는 1~45 사이의 숫자 중 당첨 번호와 중복 되지 않는 수 하나를 입력해야 합니다.")
}


