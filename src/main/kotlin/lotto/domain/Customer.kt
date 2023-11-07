package lotto.domain

import java.lang.NumberFormatException

class Customer {


    private var _lottoAmounts = 0
    private var _purchaseCounts = 0

    private var _lottoNumsList = mutableListOf<List<Int>>()
    val lottoNumsList= _lottoNumsList

    private var order = 1

    init {
        _lottoAmounts = inputToInt()
        _purchaseCounts = _lottoAmounts / 1000

        while(order<=_purchaseCounts){

            val lottoNums = produceLottoNums()
            _lottoNumsList.add(lottoNums)
            order ++

        }

     }


    private fun input(): String? {
        println("구입금액을 입력해 주세요.")
        val inputCount  = readLine()
        return inputCount
    }

    //금액 입력
    private fun inputToInt() : Int {
        var inputCount  = input()
        if(!checkInputCount(inputCount)) inputToInt()

        return inputCount!!.toInt()
    }
    private fun checkInputCount(input : String?) : Boolean {
        return try {
            require(input != null && input.toIntOrNull()!=null && input.toInt() % 1000 == 0 , { "[ERROR] 천원 단위의 금액을 입력해주세요" } )
            true
        }catch (e : IllegalArgumentException){
            println(e.message)
            false
        }catch (e : Exception){
            println(e.message)
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

    fun getPurchaseAmounts() : Long {
        return  _lottoAmounts.toLong()
    }

}