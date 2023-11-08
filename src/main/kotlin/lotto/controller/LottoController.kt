package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.model.domain.Lotto
import lotto.model.domain.Rank
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
        println("${lottoCounts}${messageViews.outputMoneyMessage}")
        val lottos: List<Lotto> = lottoGame.generateLottos(lottoCounts)
        for (lotto in lottos) {
            println(lotto.numbers.toString())
        }
        println(messageViews.inputLottoMessage)
        val inputWinningLotto =
            Console.readLine().split(",").map { validator.validatedNumberInRange(it.toInt(), 1, 45) }
        println(messageViews.inputBonusMessage)
        val bonusNumber = validator.validatedInputIsInt(Console.readLine())
        val winningLotto = lottoGame.generateWinningLottoFromInput(inputWinningLotto, bonusNumber)
        val rankList: List<Rank> = lottos.map { lottoGame.compareLotto(winningLotto, it) }
        println(messageViews.outputLottoMessage)
        lottoGame.printResultToString(rankList, inputMoney)
    }

}