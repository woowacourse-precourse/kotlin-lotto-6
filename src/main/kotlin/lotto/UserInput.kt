package lotto

class UserInput {

    fun priceInput(): Int {
        while (true) {
            try {
                println(PrintMessage.INPUT_AMOUNT.content())
                val input = camp.nextstep.edu.missionutils.Console.readLine().trim()
                val purchasePrice = checkIsNumeric(input)
                PriceRangeJudgement(purchasePrice)
                PriceUnitJudgement(purchasePrice)
                return purchasePrice / 1000 // 로또 티켓 개수 반환
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun checkIsNumeric(input: String): Int {
        val purchasePrice = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Input must be a number.\n")
        return purchasePrice
    }

    private fun PriceUnitJudgement(input: Int) {
        require(input % 1000 == 0) {
            "[ERROR] Input must be a positive multiple of 1000.\n"
        }
    }

    private fun PriceRangeJudgement(input: Int) {
        require(input > 0) {
            "[ERROR] Input must be greater than 0.\n"
        }
    }

    fun BonusNumberRangeJudgement(bonusnumber: Int) {
        require(bonusnumber in 1..45) {
            "Bonus number must be between 1 and 45."
        }
    }

    fun bonusNumberInput(): Int {
        while (true) {
            try {
                println(PrintMessage.INPUT_BONUS_NUMBER.content())
                val input = camp.nextstep.edu.missionutils.Console.readLine().trim()
                val bonusNumber = checkIsNumeric(input)
                BonusNumberRangeJudgement(bonusNumber)
                return bonusNumber // 보너스 번호 반환
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}
