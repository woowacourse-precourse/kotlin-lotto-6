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
    fun convertWinningNumbers():List<String>{
        val winningNumber=Console.readLine()
        return winningNumber.split(",").toList()
    }
    fun validWinningNumbers(winningNumbers:List<String>):String{
       when{
           winningNumbers.toSet().size!=winningNumbers.size->{
               throw IllegalArgumentException("[ERROR]당첨번호에는 중복이 없어야 합니다.")
           }
           winningNumbers.any { it.toIntOrNull()==null }->{
               throw IllegalArgumentException("[ERROR]당첨번호에는 숫자와 쉼표만 입력가능합니다.")
           }
           winningNumbers.any{it.toInt()<1||it.toInt()>45}->{
               throw IllegalArgumentException("[ERROR]당첨번호는 1~45까지의 숫자로 구성되어있습니다.")
           }
           winningNumbers.size!=6->{
               throw IllegalArgumentException("[ERROR]당첨번호는 6개입니다.")
           }
       }
        return winningNumbers.joinToString("," )
    }
}