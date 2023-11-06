package lotto.view

import lotto.util.Constants.OUTPUT_NUMBER

class Output {

    fun outputNumber(num : Int) {
        println("${num/1000}" + OUTPUT_NUMBER)
    }
}