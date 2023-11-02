package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun inputPrice(): Int {
        var validInput = false
        var price = ""
        while(!validInput) {
            try {
                price = Console.readLine()
                InputValidator.validateInputPrice(price)
                validInput=true
            } catch (e: IllegalArgumentException) {
                println(e.message)
                validInput=false
            }
        }
        return price.toInt()
    }
}