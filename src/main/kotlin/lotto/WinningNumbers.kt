package lotto

import camp.nextstep.edu.missionutils.Console

class WinningNumbers() {

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
}


