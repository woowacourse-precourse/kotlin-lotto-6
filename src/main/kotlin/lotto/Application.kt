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

fun main() {

    val purchaseAmount = getUserInput(UserPrompt.PURCHASE_AMOUNT)
    val lottoNumbers = getUserInput(UserPrompt.LOTTO_NUMBERS)
    val bonusNumber = getUserInput(UserPrompt.BONUS_NUMBER)



}
