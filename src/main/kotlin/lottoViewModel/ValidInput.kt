package lottoViewModel
import camp.nextstep.edu.missionutils.Console
import lottoView.LottoOutPut

class ValidInput {
    fun validInputPurchase(): Int {
        val totalPurchase = Console.readLine()
        when {
            totalPurchase.toIntOrNull() == null -> {
                throw IllegalArgumentException("[ERROR]구매 금액은 숫자로만 입력가능합니다.")
            }

            totalPurchase.toInt() % 1000 != 0 -> {
                throw IllegalArgumentException("[ERROR]구매 금액은 1000원 단위로 입력하셔야합니다.")
            }
        }
        return totalPurchase.toInt() / 1000
    }

    fun convertWinningNumbers(): List<Int> {
        val winningNumberInput = Console.readLine()
        val numbers = winningNumberInput.split(",").map { it.toIntOrNull() }

        if (numbers.any { it == null }) {
            throw IllegalArgumentException("[ERROR]당첨번호에는 숫자와 쉼표만 입력가능합니다.")
        }

        if (numbers.any { it!!< 1 || it!! > 45 }) {
            throw IllegalArgumentException("[ERROR]당첨번호는 1~45까지의 숫자로 구성되어있습니다.")
        }

        return numbers.mapNotNull { it }
    }


    fun convertWinningNumbersInt(winningNumberInput: String): List<Int> {
        val winningNumbers = winningNumberInput.split(",").map { it.toInt() }
        return winningNumbers
    }
    fun validWinningNumbers(winningNumbers: List<Int>):List<Int>{
        when{
            winningNumbers.toSet().size!=winningNumbers.size->{
                throw IllegalArgumentException("[ERROR]당첨번호에는 중복이 없어야 합니다.")
            }
            winningNumbers.any { it==null }->{
                throw IllegalArgumentException("[ERROR]당첨번호에는 숫자와 쉼표만 입력가능합니다.")
            }
            winningNumbers.any{it<1||it>45}->{
                throw IllegalArgumentException("[ERROR]당첨번호는 1~45까지의 숫자로 구성되어있습니다.")
            }
            winningNumbers.size!=6->{
                throw IllegalArgumentException("[ERROR]당첨번호는 6개입니다.")
            }
        }
        return winningNumbers.map{it}
    }
    fun bringBonusNumber(winningNumbers: List<Int>): Int {
        LottoOutPut().printlnBonusNumberMent()
        val bonusNumberInput = Console.readLine()
        try {
            val bonusNumber = bonusNumberInput.toIntOrNull()
            if (bonusNumber==null||bonusNumber<1||bonusNumber>45) {
                throw IllegalArgumentException("[ERROR]보너스 번호의 숫자나 양식을 다시 확인해주세요.")
            }
            if (winningNumbers.contains(bonusNumber)) {
                throw IllegalArgumentException("[ERROR]보너스 번호가 당첨번호에 이미 포함되어 있습니다.")
            }
            LottoOutPut().outputMent()
            return bonusNumber
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return bringBonusNumber(winningNumbers)
        }
    }

}
