package lotto
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("구입금액을 입력해 주세요.")

    val purchaseAmount = getPurchaseAmount()

    val lottoNumbers = generateLottoNumbers(purchaseAmount)

    println("${lottoNumbers.size}개를 구매했습니다.")
    for (lottoNumber in lottoNumbers) {
        println(lottoNumber)
    }
    println("당첨 번호를 입력해 주세요.")
    val winningNumbers=getWinningNumbers()

    println("보너스 번호를 입력해 주세요.")
    val bonusNumber=getBonusNumber()

    val results=calculateResults(lottoNumbers,winningNumbers,bonusNumber)

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
        amount=inputPurchase(amount)
    }
    return amount
}

fun inputPurchase(amount: Int): Int {
    var mutableAmount = amount
    try {
        mutableAmount = Console.readLine().toInt()!!
    } catch (e: NumberFormatException) {
        println("[ERROR] 잘못된 입력 형식입니다.")
        return amount
    }
    if (mutableAmount % 1000 != 0 || mutableAmount == 0) {
        println("[ERROR] 구입 금액은 1,000원 단위로 입력되어야 합니다.")
        return amount
    }
    return mutableAmount
}

fun getWinningNumbers(): List<Int> {
    var numbers=listOf(0)
    println("당첨 번호를 입력해 주세요.")
    while (numbers==listOf(0)) {
        numbers=inputWinningNumbers()
    }
    return numbers
}

fun inputWinningNumbers(): List<Int> {
    try {
        var numbers: List<Int>
        val input = Console.readLine()
        numbers = input?.split(",")!!.mapNotNull { it.trim().toIntOrNull() }
        validateLottoNumbers(numbers)
        return numbers // 유효한 입력이 들어왔으면 루프를 종료
    } catch (e: NumberFormatException) {
        println("[ERROR] 잘못된 입력 형식입니다.")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
    return listOf(0)
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

fun getBonusNumber(): Int {
    var number = 0
    while (number < 1 || number > 45) {
        number=inputBonusNumbers()
    }
    return number
}

fun inputBonusNumbers(): Int{
    var result = 0
    try {
        result = Console.readLine().toInt()
        validateBonusNumbers(result)
        return result
    } catch (e: NumberFormatException) {
        println("[ERROR] 잘못된 입력 형식입니다.")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
    return result
}
fun validateBonusNumbers(number: Int){
    if (number < 1 || number > 45) {
        throw IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
    }
}

fun calculateResults(lottoNumbers: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): MutableMap<String, Int> {
    var results = mutableMapOf(
        "6개 일치" to 0,
        "5개 일치, 보너스 볼 일치" to 0,
        "5개 일치" to 0,
        "4개 일치" to 0,
        "3개 일치" to 0
    )

    for (lotto in lottoNumbers) {
        val numbers = lotto.getNumbers()
        results=matchingNumber(results,numbers,winningNumbers,bonusNumber)
    }

    return results
}

fun matchingNumber(results: MutableMap<String, Int>, numbers: List<Int>, winningNumbers: List<Int>, bonusNumber: Int): MutableMap<String, Int> {
    val matchingNumbers = numbers.intersect(winningNumbers).toList()
    val bonusMatch = if (numbers.contains(bonusNumber)) 1 else 0

    when (matchingNumbers.size) {
        6 -> results["6개 일치"] = results["6개 일치"]!! + 1
        5 -> results["5개 일치"] = results["5개 일치"]!! + 1
        4 -> results["4개 일치"] = results["4개 일치"]!! + 1
        3 -> results["3개 일치"] = results["3개 일치"]!! + 1
    }

    if (matchingNumbers.size == 5 && bonusMatch == 1) {
        results["5개 일치, 보너스 볼 일치"] = results["5개 일치, 보너스 볼 일치"]!! + 1
    }
    return results
}