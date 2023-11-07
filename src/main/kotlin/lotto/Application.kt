package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

var numberOfLottoTickets = 0
val lottos = mutableListOf<Lotto>()
lateinit var userLottos: Lotto
var userLottoBonusNumber = 0
val winnings = Winning.values()

fun main() {
    doLotto()
}

fun doLotto() {
    doLogic {
        val lottoPurchaseAmount = getLottoPurchaseAmount()
        getNumberOfLottoTickets(lottoPurchaseAmount)
    }
    getLottoWinningNumbers()
    showLottoWinningNumbers()
    doLogic {
        val userInputNumbers = getUserLottoNumbers()
        validateUserLottoNumbers(userInputNumbers)
    }
    doLogic {
        val userInputBonusNumber = getUserBonusLottoNumber()
        validateUserBonusLottoNumber(userInputBonusNumber)
    }
    checkWinning()
    showWinningResult()
    showRateOfReturn()
}

fun showLottoWinningNumbers() {
    lottos.forEach {
        it.printWinningNumbers()
    }
}

fun getLottoPurchaseAmount(): String {
    println("구입금액을 입력해 주세요.")
    val lottoPurchaseAmount = Console.readLine()
    println()
    return lottoPurchaseAmount
}

fun getNumberOfLottoTickets(lottoPurchaseAmount: String) {
    val lottoTickets = lottoPurchaseAmount.toIntOrNull()
    lottoTickets?.let {
        if (lottoTickets % amountUnit == 0) {
            println("${lottoTickets / amountUnit}개를 구매했습니다.")
            numberOfLottoTickets = lottoTickets / 1000
        } else {
            throw IllegalArgumentException("$errorPrefix 구입금액은 ${amountUnit}원 단위의 숫자 여야합니다.")
        }
        return
    }
    throw IllegalArgumentException("$errorPrefix 구입금액은 $amountUnit 단위의 숫자 여야합니다.")
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

fun getUserLottoNumbers(): String {
    println("당첨 번호를 입력해 주세요.")
    return Console.readLine()
}

fun validateUserLottoNumbers(userInputNumbers: String) {

    val parsedUserInputNumbers = userInputNumbers.split(",").filter {
        it.isNotEmpty()
    }.map {
        it.toIntOrNull()
    }

    val isUserInputNumberType = !parsedUserInputNumbers.contains(null)
    val isUserInputInRange =
        parsedUserInputNumbers.filter { it in minLottoWinningNumber..maxLottoWinningNumber }.size == lottoWinningNumberQuantity
    val isUerInputRightQuantity = parsedUserInputNumbers.size == lottoWinningNumberQuantity
    if (isUserInputNumberType && isUserInputInRange && isUerInputRightQuantity) {
        parsedUserInputNumbers.map { it!! }.apply {
            Lotto(this).apply {
                userLottos = this
            }
        }
    } else throw IllegalArgumentException("$errorPrefix 당첨 번호는 $minLottoWinningNumber~$maxLottoWinningNumber 사이의 중복되지 않는 숫자를 , 로 구분하여 ${lottoWinningNumberQuantity}개를 입력해야 합니다.")
}

fun getUserBonusLottoNumber(): String {
    println()
    println("보너스 번호를 입력해 주세요.")
    return Console.readLine()
}

fun validateUserBonusLottoNumber(userInputBonusNumber: String) {
    val bonusNumber = userInputBonusNumber.toIntOrNull()
    val isUerInputNumberType = bonusNumber != null
    val isUserInputInRange = bonusNumber in minLottoWinningNumber..maxLottoWinningNumber
    val isUerInputDistinct = !userLottos.getNumbers().contains(bonusNumber)
    if (isUerInputNumberType && isUserInputInRange && isUerInputDistinct) {
        bonusNumber.toString().toInt().apply {
            userLottoBonusNumber = this
        }
    } else throw IllegalArgumentException("$errorPrefix 보너스 번호는 $minLottoWinningNumber~$maxLottoWinningNumber 사이의 숫자 중 당첨 번호와 중복 되지 않는 수 하나를 입력해야 합니다.")
}

fun checkWinning() {
    lottos.forEach {
        val winningResult = it.checkWinning(userLottos, userLottoBonusNumber)
        winnings.toList().indexOf(winningResult).apply {
            if (this >= 0) winnings[this].winningCnt++
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

fun showRateOfReturn() {
    val totalWinningPrice = winnings.fold(0) { acc, winning ->
        acc + winning.winningPrice * winning.winningCnt
    }
    val totalRateOfReturn = calculateRateOfReturn(totalWinningPrice)
    println("총 수익률은 ${totalRateOfReturn}%입니다.")
}

fun calculateRateOfReturn(totalWinningPrice: Int): String {
    val rateOfReturn = totalWinningPrice.toDouble() / (numberOfLottoTickets * 1000) * 100
    return String.format("%.1f", rateOfReturn)
}