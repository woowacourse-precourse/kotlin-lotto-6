package lottoViewModel
import camp.nextstep.edu.missionutils.Console
import lottoView.LottoOutPut

class ValidInput {
    object ErrorMessage{
        const val INPUT_PRICE_ONLY_DIGIT="[ERROR]구매 금액은 숫자로만 입력가능합니다."
        const val ERROR_INVALID_INPUT_PRICE="[ERROR]구매 금액은 1000원 단위로 입력하셔야합니다."
        const val WINNING_NUMBER_ONLY_DIGIT="[ERROR]당첨번호에는 숫자와 쉼표만 입력가능합니다."
        const val OUT_OF_RANGE_WINNING_NUMBER="[ERROR]당첨번호는 1~45까지의 숫자로 구성되어있습니다."
        const val DUPLICATE_WINNING_NUMBER="[ERROR]당첨번호에는 중복이 없어야 합니다."
        const val SIZE_MISS_WINNING_NUMBER="[ERROR]당첨번호는 6개입니다."
        const val INVALID_BONUS_NUMBER="[ERROR]보너스 번호의 숫자나 양식을 다시 확인해주세요."
        const val DUPLICATE_BONUS_NUMBER="[ERROR]보너스 번호가 당첨번호에 이미 포함되어 있습니다."
    }
    fun validInputPurchase(): Int {
        val totalPurchase = Console.readLine()
        when {
            totalPurchase.toIntOrNull() == null -> {
                throw IllegalArgumentException(ErrorMessage.INPUT_PRICE_ONLY_DIGIT)
            }

            totalPurchase.toInt() % 1000 != 0 -> {
                throw IllegalArgumentException(ErrorMessage.ERROR_INVALID_INPUT_PRICE)
            }
        }
        return totalPurchase.toInt() / 1000
    }

    fun convertWinningNumbers(): List<Int> {
        val winningNumberInput = Console.readLine()
        val numbers = winningNumberInput.split(",").map { it.toIntOrNull() }

        if (numbers.any { it == null }) {
            throw IllegalArgumentException(ErrorMessage.WINNING_NUMBER_ONLY_DIGIT)
        }

        if (numbers.any { it!! < 1 || it > 45 }) {
            throw IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_WINNING_NUMBER)
        }

        return numbers.mapNotNull { it }
    }

    fun validWinningNumbers(winningNumbers: List<Int>):List<Int>{
        when{
            winningNumbers.toSet().size!=winningNumbers.size->{
                throw IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBER)
            }
            winningNumbers.any { it==null }->{
                throw IllegalArgumentException(ErrorMessage.WINNING_NUMBER_ONLY_DIGIT)
            }
            winningNumbers.any{it<1||it>45}->{
                throw IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_WINNING_NUMBER)
            }
            winningNumbers.size!=6->{
                throw IllegalArgumentException(ErrorMessage.SIZE_MISS_WINNING_NUMBER)
            }
        }
        return winningNumbers.map{it}
    }
    fun bringBonusNumber(winningNumbers: List<Int>): Int {
        LottoOutPut().printlnBonusNumberMent()
        val bonusNumberInput = Console.readLine()
        return try {
            val bonusNumber = bonusNumberInput.toIntOrNull()
            if (bonusNumber==null||bonusNumber<1||bonusNumber>45) {
                throw IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER)
            }
            if (winningNumbers.contains(bonusNumber)) {
                throw IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER)
            }
            LottoOutPut().outputMent()
            bonusNumber
        } catch (e: IllegalArgumentException) {
            println(e.message)
            bringBonusNumber(winningNumbers)
        }
    }

}
