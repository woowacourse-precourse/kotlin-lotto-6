package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

var numberOfLottoTickets = 0
val lottos = mutableListOf<Lotto>()
val userLottoNumbers = mutableSetOf<Int>()
var userLottoBonusNumber = 0
val winnings = Winning.values()

fun main() {
    doLogic { getLottoPurchaseAmount() }
    getLottoWinningNumbers()
    showLottoWinningNumbers()
    doLogic { getUserLottoNumbers() }
    doLogic { getUserBonusLottoNumber() }
    checkWinning()
    showWinningResult()
}

fun showLottoWinningNumbers() {
    lottos.forEach {
        it.printWinningNumbers()
    }
}

fun getLottoPurchaseAmount() {
    println("구입금액을 입력해 주세요.")
    val lottoPurchaseAmount = Console.readLine()
    println()
    val lottoTickets = lottoPurchaseAmount.toInt()
    if (lottoTickets % 1000 == 0) {
        println("${lottoTickets / 1000}개를 구매했습니다.")
        numberOfLottoTickets = lottoTickets / 1000
    } else throw IllegalArgumentException("$errorPrefix 구입금액은 1000원 단위의 숫자 여야합니다.")
}

fun getLottoWinningNumbers() {
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

fun getUserLottoNumbers() {
    println("당첨 번호를 입력해 주세요.")
    val userInput = Console.readLine()
    val userInputLottoNumbers = userInput.split(",").filter {
        it.isNotEmpty()
    }.map {
        it.toIntOrNull()
    }
    validateUserLottoNumbers(userInputLottoNumbers)
}

fun validateUserLottoNumbers(userInputLottoNumbers: List<Int?>) {
    val isUserInputNumber = !userInputLottoNumbers.contains(null)
    val isRangedNumber =
        userInputLottoNumbers.filter { it in minLottoWinningNumber..maxLottoWinningNumber }.size == lottoWinningNumberQuantity
    val isAppropriateCnt = userInputLottoNumbers.size == lottoWinningNumberQuantity
    if (isUserInputNumber && isRangedNumber && isAppropriateCnt) userLottoNumbers.addAll(
        userInputLottoNumbers.map { it!! })
    else throw IllegalArgumentException("$errorPrefix 당첨 번호는 1~45 사이의 중복되지 않는 숫자를 , 로 구분하여 6개를 입력해야 합니다.")
}

fun getUserBonusLottoNumber() {
    println()
    println("보너스 번호를 입력해 주세요.")
    val userBonusLottoNumberInput = Console.readLine()
    userLottoBonusNumber = validateUserBonusLottoNumber(userBonusLottoNumberInput)
}

fun validateUserBonusLottoNumber(userBonusInput: String): Int {
    val userLottoNumber = userBonusInput.toIntOrNull()
    val isNumber = userLottoNumber != null
    val isRangedNumber = userLottoNumber in minLottoWinningNumber..maxLottoWinningNumber
    val isNotDuplicatedNumber = !userLottoNumbers.contains(userLottoNumber)
    if (isNumber && isRangedNumber && isNotDuplicatedNumber) return userLottoNumber.toString()
        .toInt()
    else throw IllegalArgumentException("$errorPrefix 보너스 번호는 1~45 사이의 숫자 중 당첨 번호와 중복 되지 않는 수 하나를 입력해야 합니다.")
}

fun checkWinning() {
    lottos.forEach {
        when (it.checkWinning(userLottoNumbers, userLottoBonusNumber)) {
            Winning.matchingThreeCount -> winnings[0].winningCnt++
            Winning.matchingFourCount -> winnings[1].winningCnt++
            Winning.matchingFiveCount -> winnings[2].winningCnt++
            Winning.matchingFiveCountWithBonus -> winnings[3].winningCnt++
            Winning.matchingSixCount -> winnings[4].winningCnt++
            else -> {}
        }
    }
}

fun showWinningResult() {
    println()
    println("당첨 통계")
    println("---")
    winnings.forEach {
        println("${it.msg} (${PriceUtil.decimal.format(it.winningPrice)}원) - ${it.winningCnt}개")
    }
}
