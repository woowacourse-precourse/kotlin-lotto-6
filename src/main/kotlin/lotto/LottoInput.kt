package lotto

import camp.nextstep.edu.missionutils.Console

class LottoInput {
    fun result():List<Int>{
        return inputLotto()
    }

    //todo 예외처리
    private fun inputLotto(): List<Int>{
        val inputText: String = Console.readLine()
        val numbers = mutableListOf<Int>()
        for (number in inputText.split(",")) {
            numbers.add(number.toInt())
        }
        return numbers
    }
}