package lotto
import camp.nextstep.edu.missionutils.Randoms
import lottoView.LottoOutPut
import lottoViewModel.CreateNumbers
import lottoViewModel.ValidInput
import kotlin.IllegalArgumentException

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        checkNumbersSize()
        numbersRange()
    }
    private fun checkNumbersSize(){
        if(numbers.size!=6)throw IllegalArgumentException("[ERROR]숫자는 6개씩 입력되어야합니다.")
        if(numbers.toSet().size!=numbers.size)throw IllegalArgumentException("[ERROR]중복 데이터를 확인해주세요")
    }
    private fun numbersRange(){
        numbers.forEach{
            if(1>it||it>45)throw IllegalArgumentException("[ERROR]숫자의 범위가 잘못되었습니다.")
        }
    }
    fun lottoNumbersPrint(purchaseAmount:Int){
        try{
            LottoOutPut().randomNumbersPrint(purchaseAmount)
            LottoOutPut().printlnWiningNumberMent()
        }
        catch (e:IllegalArgumentException){
            println(e.message)
        }
    }
}
