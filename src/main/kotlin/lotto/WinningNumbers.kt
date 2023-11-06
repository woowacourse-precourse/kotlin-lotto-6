package lotto

import camp.nextstep.edu.missionutils.Console
fun getWinningNumbers(): List<Int> {
    println("당첨 번호를 입력해 주세요.")
    val inputWinningNumber = Console.readLine()
    validateWinningNumber(inputWinningNumber)
    return inputWinningNumber.split(",").map { it.toInt()}
}
fun getBonusNumber(): Int {
    println("보너스 번호를 입력해 주세요.")
    val inputBonusNumber = Console.readLine().toInt()
    validateBonusNumber(inputBonusNumber)
    return inputBonusNumber.
}
fun validateWinningNumber(inputWinningNumber: String):List<String> {
    if (inputWinningNumber.contains(",").not()) throw IllegalArgumentException("[Error] 잘못된 입력입니다.")
    if (inputWinningNumber.isEmpty()) throw IllegalArgumentException("[ERROR] 값을 입력해 주세요.")
    if (inputWinningNumber.isBlank()) throw IllegalArgumentException("[ERROR] 값을 입력해 주세요.")
    if (!inputWinningNumber.matches(Regex("^\\d*\$"))) throw IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.")
    return listOf(inputWinningNumber)
}


fun validateBonusNumber(inputBonusNumber: Int):Int {
    if(inputBonusNumber !in 1..45) throw IllegalArgumentException("[ERROR] 1~45 사이의 숫자만 입력해 주세요.")
    return inputBonusNumber
}