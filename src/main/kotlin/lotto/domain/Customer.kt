package lotto.domain

import camp.nextstep.edu.missionutils.Console
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

        while (order <= _purchaseCounts) {

            val lottoNums = produceLottoNums()
            _lottoNumsList.add(lottoNums)
            order++

        }
    }



    private fun inputToInt() : Int {

        val inputCount  = Console.readLine()
        if(!checkInputCount(inputCount)) inputToInt()

        return inputCount.toInt()
    }
    private fun checkInputCount(input : String) : Boolean {
        return try {
            require( input.toIntOrNull()!=null && input.toInt() % 1000 == 0,{"[ERROR]"})
            true
        }catch (e : IllegalArgumentException){
            e.message?.let{
                println(it)
            } ?: println()
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