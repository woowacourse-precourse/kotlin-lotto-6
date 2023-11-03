package lotto
import camp.nextstep.edu.missionutils.Console.readLine

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
            return when (prompt) {
                UserPrompt.LOTTO_NUMBERS -> getUserInput(prompt).split(',').map { it.toInt() }
                else -> getUserInput(prompt).toInt()
            }
        } catch (e: NumberFormatException) {
            println("[ERROR] 잘못된 값을 입력하였습니다.")
        }
    }
}


fun main() {

    val purchaseAmount = getUserInputHandler(UserPrompt.PURCHASE_AMOUNT)
    val lottoNumbers = getUserInputHandler(UserPrompt.LOTTO_NUMBERS)
    val bonusNumber = getUserInputHandler(UserPrompt.BONUS_NUMBER)


}
