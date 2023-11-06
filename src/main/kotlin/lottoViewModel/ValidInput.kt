package lottoViewModel
import camp.nextstep.edu.missionutils.Console
import lottoView.LottoOutPut
import net.bytebuddy.pool.TypePool.Resolution.Illegal

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
    fun validWinningNumbers(winningNumbers:List<String>):List<String>{
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
        return winningNumbers
    }
    fun bringBonusNumber(winningNumbers: List<String>){
        LottoOutPut().printlnBonusNumberMent()
        val bonusNumber = Console.readLine()
        try {
            if (winningNumbers.contains(bonusNumber)) {
                throw IllegalArgumentException("[ERROR]보너스 번호가 당첨번호에 이미 포함되어 있습니다.")
            }
            if(bonusNumber.toIntOrNull()==null){
                throw IllegalArgumentException("[ERROR]보너스 번호는 숫자로 입력해야합니다.")
            }
            if(bonusNumber.toInt()<1||bonusNumber.toInt()>45){
                throw IllegalArgumentException("[ERROR]보너스 번호는 숫자로 입력해야합니다.")
            }
            LottoOutPut().printlnOutPutMent()
            LottoOutPut().printlnThreeBar()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return bringBonusNumber(winningNumbers)
        }
    }


}