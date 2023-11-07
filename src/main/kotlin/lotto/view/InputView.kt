package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto

class InputView {
    fun inputPurchaseLottoAmount() : Int{
        val userPurchaseAmount = Console.readLine()
        var purchasedUserLottoCount = 0
        if (userPurchaseAmount.toIntOrNull() == null){
            throw IllegalArgumentException("[ERROR] 로또의 구매 금액은 숫자를 입력하셔야 합니다.")
        }
        if (userPurchaseAmount.toIntOrNull()!! % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 로또의 구매 단위는 1,000원 입니다.")
        }
        purchasedUserLottoCount = userPurchaseAmount.toIntOrNull()!! / 1000
        return purchasedUserLottoCount
    }

    fun inputLottoWinningNumbers(): Lotto {
        val lottoWinningNumbers = Console.readLine().split(",")
        return Lotto(lottoWinningNumbers.map { it.toInt() })
    }

    fun inputLottoBonusNumber(): Int {
        val lottoBonusNumber = Console.readLine()
        if (lottoBonusNumber.toIntOrNull() == null){
            throw IllegalArgumentException("[ERROR] 보너스 번호는 정수여야 합니다.")
        }
        return lottoBonusNumber.toInt()
    }
}