package lotto.user

import camp.nextstep.edu.missionutils.Console
import lotto.model.LottoBonus
import lotto.util.LottoView

class LottoBonusPick {
    fun bonusPickNumber(prizeNumber:List<Int>): Int {
        LottoView().bonusView()
        while (true) {
            try {
                val bonusNumber = Console.readLine()
                LottoBonus().bonusCheck(bonusNumber)
                LottoBonus().bonusRepeat(bonusNumber.toInt(), prizeNumber)
                return bonusNumber.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}