package lotto

import camp.nextstep.edu.missionutils.Console.readLine

enum class UserPrompt(val message: String) {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    LOTTO_NUMBERS("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("\n보너스 번호를 입력해 주세요.")
}

val LOTTO_NUMBER_RULES = mapOf(
    { unused: Int, numbers: List<Int> -> numbers.size == 6 } to "로또 번호는 6개의 숫자여야 합니다.",
    { unused: Int, numbers: List<Int> -> numbers.distinct().size == 6 } to "입력한 값에 중복된 숫자가 있습니다.",
    { unused: Int, numbers: List<Int> -> numbers.all { it in 1..45 } } to "모든 숫자는 1부터 45 사이어야 합니다."
)

val BONUS_NUMBER_RULES = mapOf(
    { number: Int, unused: List<Int> -> number in 1..45 } to "보너스 번호는 1부터 45 사이의 숫자여야 합니다.",
    { number: Int, lottoNumbers: List<Int> -> number !in lottoNumbers } to "당첨 번호에 입력한 값과 중복된 숫자가 있습니다."
)

val PURCHASE_AMOUNT_RULES = mapOf(
    { amount: Int, unused: List<Int> -> amount % 1000 == 0 } to "1000원 단위로 입력하세요."
)

class InputHandler {

    fun getUserInput(prompt: UserPrompt): String {
        println(prompt.message)
        return readLine()
    }

    private fun checkInput(rules: Map<(Int, List<Int>) -> Boolean, String>, number:Int?, lottoNumbers:List<Int>?) {

        rules.forEach { (rule, message) ->
            require(rule(number?:0, lottoNumbers?: emptyList())) { message }
        }

    }

    fun checkLottoNumbers(userInput: String): List<Int>{
        val numbers = userInput.split(',').map { it.toInt() }
        checkInput(LOTTO_NUMBER_RULES,null, numbers)

        return numbers
    }


    fun checkBonusNumbers(userInput: String, lottoNumbers: List<Int>?): Int{
        val bonusNumber = userInput.toInt()
        checkInput(BONUS_NUMBER_RULES, bonusNumber, lottoNumbers)
        return bonusNumber

    }


    fun checkAmount(userInput: String): Int {
        val amount = userInput.toInt()
        checkInput(PURCHASE_AMOUNT_RULES,amount, null)
        return amount
    }


    fun getUserInputHandler(prompt: UserPrompt, lottoNumbers: List<Int>? = null): Any {
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
            }
        }
    }
}