package lotto

class LottoMachine {
    fun inputWinNum (): List<Int>{
        val input = readLine()!!.split(",").toList()
        if (input.size != 6) throw IllegalArgumentException("당첨 번호는 6개여야 합니다.")
        return input.map { it.toInt() }
    }
    fun inputSubNum (): Int{
        val input = readLine()!!.toInt()
        if (input < 1 || input > 45) throw IllegalArgumentException("보너스 번호는 1부터 45까지의 숫자여야 합니다.")
        return input
    }
}