package lotto.domain

import camp.nextstep.edu.missionutils.Console


// 사용자 입력 관리
class InputManager {
    fun inputLottoWinningNumber(): String {
        return Console.readLine()
    }

    fun inputBonusNumber(): String {
        return Console.readLine()
    }
}