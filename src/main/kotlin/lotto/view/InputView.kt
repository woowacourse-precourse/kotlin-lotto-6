package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Exception

class InputView {

    fun inputPrice(): Int {
        var validInput = false
        var price = ""
        while(!validInput) {
            try {
                price = Console.readLine()
                Exception.validateInputPrice(price)
                validInput=true
            } catch (e: IllegalArgumentException) {
                println(e.message)
                validInput=false
            }
        }
        return price.toInt()
    }
    fun inputLuckyNumber() : List<Int> {
        var validInput = false
        var luckyNumbers = ""
        while(!validInput){
            try{
                luckyNumbers = Console.readLine()
                Exception.validateInputLuckyNumber(luckyNumbers)
                validInput=true
            } catch(e : IllegalArgumentException){
                println(e.message)
                validInput=false
            }
        }
        return luckyNumbers.split(",").map { it.toInt() }
    }
    fun inputBonusNumber() : Int{
        var validInput = false
        var bonusNumber = ""
        while(!validInput){
            try{
                bonusNumber = Console.readLine()
                Exception.validateInputBonusNumber(bonusNumber)
                validInput = true
            } catch(e : IllegalArgumentException){
                println(e.message)
                validInput = false
            }
        }
        return bonusNumber.toInt()
    }
}