package lotto.domain

import java.lang.NumberFormatException

class Customer {


    private var lottoCounts = 0

    init{

       lottoCounts = inputToInt()


     }


    //금액 입력
    private fun inputToInt() : Int {
        val inputCount  = readLine()
        if(!checkInputCount(inputCount)) return inputToInt()

        return inputCount!!.toInt()
    }
    private fun checkInputCount(input : String?) : Boolean {
        return try {
            require(input != null && input.toIntOrNull()!=null && input.toInt() % 1000 == 0 )
            true
        }catch (e : IllegalArgumentException){
            println("[ERROR] 천원 단위의 금액을 입력해주세요")
            false
        }
    }

}