package lottoViewModel
import camp.nextstep.edu.missionutils.Console
import lottoView.LottoOutPut

class ValidInput {
    fun validInputPurchase():Int{
        val totalPurchase = Console.readLine()
        when {
            totalPurchase.toIntOrNull() == null -> {
                throw IllegalArgumentException("[ERROR]구매 금액은 숫자로만 입력가능합니다.")
            }
            totalPurchase.toInt() % 1000 != 0 -> {
                throw IllegalArgumentException("[ERROR]구매 금액은 1000원 단위로 입력하셔야합니다.")
            }
        }
        return totalPurchase.toInt()/1000
    }
}