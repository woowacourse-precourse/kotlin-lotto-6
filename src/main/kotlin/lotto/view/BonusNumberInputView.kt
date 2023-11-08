package lotto.view

import camp.nextstep.edu.missionutils.Console

class BonusNumberInputView {
    var bonusNumber = ""
        private set

    fun input() {
        println("보너스 번호를 입력해 주세요.")
        bonusNumber = Console.readLine().trim()
        println()
    }
}