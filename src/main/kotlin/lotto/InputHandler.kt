package lotto
import camp.nextstep.edu.missionutils.Console.readLine

enum class UserPrompt(val message: String) {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    LOTTO_NUMBERS("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("\n보너스 번호를 입력해 주세요.")

}

class InputHandler() {

    fun getUserInput(prompt: UserPrompt): String{
        println(prompt.message)
        return readLine()
    }

    fun checkLottoNumbers(userInput: String): List<Int> {

        val numbers = userInput.split(',').map { it.toInt() }
        require(numbers.size == 6) { "로또 번호는 숫자 6개를 입력하세요."}
        require(numbers.distinct().size == 6) {"중복된 숫자가 있습니다"}
        require(numbers.all { it in 1..45 }) {"로또 번호는 1부터 45 사이의 숫자여야 합니다."}
        return numbers
    }

    fun checkBonusNumbers(userInput: String, lottoNumbers : Any? ): Int{
        val bonusNumber = userInput.toInt()
        require(bonusNumber in 1..45) {"로또 번호는 1부터 45 사이의 숫자여야 합니다."}
        require(bonusNumber !in lottoNumbers as List<*>){ "당첨 번호에 중복된 숫자가 있습니다."}
        return bonusNumber
    }

    fun checkAmount(userInput: String): Int {
        val amount = userInput.toInt()
        require(amount % 1000 == 0){ "1000원 단위로 입력하세요."}
        return amount
    }

    fun getUserInputHandler(prompt: UserPrompt, lottoNumbers: Any? = null): Any{
        while (true) {
            try {
                val userInput = getUserInput(prompt)

                return when (prompt) {
                    UserPrompt.LOTTO_NUMBERS -> checkLottoNumbers(userInput)
                    UserPrompt.BONUS_NUMBER -> checkBonusNumbers(userInput, lottoNumbers)
                    UserPrompt.PURCHASE_AMOUNT -> checkAmount(userInput)
                }

            } catch (e: NumberFormatException) {
                println("[ERROR] 숫자를 입력하세요")
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
                throw IllegalArgumentException()
            }
        }
    }

}