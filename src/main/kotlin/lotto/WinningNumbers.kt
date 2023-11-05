package lotto

import camp.nextstep.edu.missionutils.Console
fun getWinningNumbers(): List<Int> {
    println("당첨 번호를 입력해 주세요.")
    val inputWinningNumber = Console.readLine()
    validateWinningNumber(inputWinningNumber)
    return inputWinningNumber.split(",").map { it.toInt()}
}

fun validateWinningNumber(inputWinningNumber: String):List<Int> {

}