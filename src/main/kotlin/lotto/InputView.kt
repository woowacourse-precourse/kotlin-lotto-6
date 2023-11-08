package lotto
import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputAmount(): Int {
        val line: String = Console.readLine()
        try {
            val amount: Int = line.toInt()
            if (amount % 1000 != 0)
                throw IllegalArgumentException("[ERROR] 구입 금액은 1000으로 나눌수 있는 숫자여야 합니다.")
            return (amount / 1000)
        } catch (e: Exception) {
            throw IllegalArgumentException("[ERROR] 구입 금액은 1000으로 나눌수 있는 숫자여야 합니다.")
        }
    }
    fun inputWinningNum(): List<Int> {
        val line: String = Console.readLine()
        try {
            val tokens: List<String> = line.split(Regex(",\\s*"))
            val nums: List<Int> = tokens.map { it.toInt() }
            if (nums.size != 6)
                throw IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.\n")
            if (nums.size != nums.distinct().size)
                throw IllegalArgumentException("[ERROR] 로또 번호는 중복이 없는 숫자여야 합니다.\n")
            nums.forEach { num ->
                if (num > 45 || num < 1)
                    throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.\n")
            }
            return nums
        } catch(e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.\n")
        } catch (e: IllegalArgumentException){
            throw e
        } catch (e: Exception){
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.\n")
        }
    }

    fun inputBonusNum(): Int {
        val line: String = Console.readLine()
        try {
            val num: Int = line.toInt()
            if (num > 45 || num < 1)
                throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.\n")
            return num
        } catch (e: Exception) {
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.\n")
        }
    }
}