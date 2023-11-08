package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.model.domain.Lotto
import lotto.model.service.Service
import lotto.validator.Validator
import lotto.view.Messages

val validator = Validator()

class LottoController {
    val lottoGame = Service()
    val messageViews = Messages()
    fun gameStart() {
        println(messageViews.inputMoneyMessage)
        val inputMoney = validator.validatedMoneyIsInt(Console.readLine())
        val lottoCounts = validator.validatedMoneyUnit(inputMoney, 1000) / 1000
        val lottos: List<Lotto> = lottoGame.generateLottos(lottoCounts)
    }

}