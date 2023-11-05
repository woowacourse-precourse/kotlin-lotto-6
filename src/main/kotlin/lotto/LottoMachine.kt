package lotto

class LottoMachine {
    fun inputWinNum (): List<Int>{
        val input = readLine()!!.split(",").toList()
        return input.map { it.toInt() }
    }
    fun inputSubNum (): Int{
        val input = readLine()!!.toInt()
        return input
    }
}