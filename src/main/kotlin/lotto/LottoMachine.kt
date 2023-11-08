package lotto

import camp.nextstep.edu.missionutils.Console

class LottoMachine {
    fun inputWinNum (): List<Int>{
        val input = readLine()!!.split(",").toList()
        if (input.size != 6 && input.toSet().size == 6) throw IllegalArgumentException("${ERROR_MESSAGE}로또 번호는 1부터 45 사이의 중복되지 않는 숫자여야 합니다.")
        return input.map { it.toInt() }
    }
    fun inputSubNum (): Int{
        val input = readLine()!!.toInt()
        if ((input < 1 || input > 45)
            && (input in inputWinNum())) throw IllegalArgumentException("${ERROR_MESSAGE}로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        return input
    }
    companion object{
        const val ERROR_MESSAGE = "[ERROR]"
    }
}