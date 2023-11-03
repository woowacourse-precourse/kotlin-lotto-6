package lotto
import camp.nextstep.edu.missionutils.Console.readLine
import java.util.Dictionary

enum class UserPrompt(val message: String) {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요.")

}

fun getUserInput(prompt: UserPrompt): String{
    println(prompt.message)
    return readLine()
}



fun getUserInputHandler(prompt: UserPrompt): Any {
    while (true) {
        try {
            val userInput = getUserInput(prompt)

            return when (prompt) {
                UserPrompt.LOTTO_NUMBERS -> checkLottoNumbers(userInput.split(',').map { it.toInt() })
                UserPrompt.BONUS_NUMBER -> checkBonusNumbers(userInput.toInt(), userInput.split(',').map { it.toInt() })
                UserPrompt.PURCHASE_AMOUNT -> checkAmount(userInput.toInt())
            }

        } catch (e: NumberFormatException) {
            println("[ERROR] 숫자를 입력하세요.")
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
        }
    }
}


fun checkLottoNumbers(numbers: List<Int>): List<Int> {
    require(numbers.size == 6) { "로또 번호는 숫자 6개를 입력하세요."}
    require(numbers.distinct().size == 6) {"중복된 숫자가 있습니다"}
    require(numbers.all { it in 1..45 }) {"로또 번호는 1부터 45 사이의 숫자여야 합니다."}
    return numbers
}

fun checkBonusNumbers(bonusNumber: Int, lottoNumbers: List<Int> ): Int{
    require(bonusNumber in 1..45) {"로또 번호는 1부터 45 사이의 숫자여야 합니다."}
    require(bonusNumber in lottoNumbers){ "당첨번호에 중복된 숫자가 있습니다."}
    return bonusNumber
}

fun checkAmount(amount: Int ): Int{
    require(amount % 1000 == 0){ "1000원 단위로 입력하세요."}
    return amount
}


fun main() {
    val purchaseAmount = getUserInputHandler(UserPrompt.PURCHASE_AMOUNT)
    val lottoNumbers = getUserInputHandler(UserPrompt.LOTTO_NUMBERS)
    val bonusNumber = getUserInputHandler(UserPrompt.BONUS_NUMBER)

    println(purchaseAmount)
    println(lottoNumbers)
    println(bonusNumber)

}