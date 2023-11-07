package lotto

import camp.nextstep.edu.missionutils.Console

class LottoBot(
    private var budget: Int = 0,
    private var winningNumbers: MutableList<Int> = mutableListOf(),
    private var bonusNumber: Int = 0,
    private var _lottoWallet: LottoWallet = LottoWallet()
) {
    val lottoWallet: LottoWallet = _lottoWallet

    fun startLotto() {
        receiveBudget()
        purchaseLotto()
        receiveWinningNumbers()
        receiveBonusNumbers()
    }

    fun receiveBudget() {
        var flag = true
        while (flag) {
            runCatching {
                println("구입 금액을 입력해주세요")
                val input = Console.readLine()
                budget = Validator.validateBudget(input)
            }
                .onSuccess { flag = false }
                .onFailure { exception -> println(exception.message) }
        }
    }

    fun purchaseLotto() {
        val chance = budget / Validator.LOTTO_PRICE

        for (i in 1..chance) {
            var flag = true
            while (flag) {
                runCatching {
                    val newLotto = Lotto(LottoMaker.createRandomNumbers())
                    lottoWallet.addLotto(newLotto)
                }
                    .onSuccess { flag = false }
                    .onFailure { exception -> println(exception.message) }
            }
        }
    }

    fun receiveWinningNumbers() {
        var flag = true
        while (flag) {
            runCatching {
                println("당첨 번호를 입력해 주세요")
                val input = Console.readLine()
                val numbers = Validator.mapToWinningNumber(input)
                winningNumbers.addAll(Validator.validateNumbers(numbers))
            }
                .onSuccess { flag = false }
                .onFailure { exception -> println(exception.message) }
        }
    }

    fun receiveBonusNumbers() {
        var flag = true
        while (flag) {
            runCatching {
                println("보너스 번호를 입력해 주세요.")
                val input = Console.readLine()
                bonusNumber = Validator.validateBonusNumber(input)
            }.onSuccess { flag = false }
                .onFailure { exception -> println(exception.message) }
        }
    }

}