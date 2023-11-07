package lotto.domain

import java.lang.NumberFormatException

class Customer {


    private var lottoAmounts = 0

    private var _purchaseCounts = 0

    private var _lottoNumsList = mutableListOf<List<Int>>()
    val lottoNumsList= _lottoNumsList

    private var order = 1

    init{

        lottoAmounts = inputToInt()
        _purchaseCounts = lottoAmounts / 1000

        while(order<=_purchaseCounts){

            val lottoNums = produceLottoNums()
            _lottoNumsList.add(lottoNums)
            order ++

        }

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

    private fun produceLottoNums() : List<Int>{

        val randomNumProducer = LottoNumProducer()
        val sortNums = randomNumProducer.getLottoRandomNums().sorted()

        return sortNums

    }

    fun getPurchaseCounts() : Int {
        return _purchaseCounts
     }


}