package lotto

class WinningNumber {
    fun inputWinningNumber() {
        println()
        println("당첨 번호를 입력해주세요.")
        val inputWinningNumber = readLine()?.split(",")  // "," 기준으로 자름

        // TODO 옳지않은 값 들어오면 Exception 처리 구현 (try-catch 이용)
        val winningNumber = stringToInt(inputWinningNumber)
        //for (i in winningNumber.indices)
        //    println(winningNumber[i])
    }

    private fun stringToInt(inputWinningNumber: List<String>?): Array<Int> {
        val winningNumber = Array<Int>(6) { 0 }
        for (i in inputWinningNumber!!.indices)
            winningNumber[i] = inputWinningNumber[i].toInt()
        return winningNumber
    }

    fun inputBonusNumber() {
        println()
        println("보너스 번호를 입력해 주세요.")
        val bonusNumber = readLine()
        // TODO 옳지않은 값 들어오면 Exception 처리 구현
    }
}