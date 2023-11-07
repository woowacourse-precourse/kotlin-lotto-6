package lotto

import camp.nextstep.edu.missionutils.Console

class LottoBot(
    private var budget: Int = 0,
    private var winningNumbers: MutableList<Int> = mutableListOf(),
    private var bonusNumber: Int = 0,
    private var lottoWallet: MutableList<Lotto> = mutableListOf(),
    private var bonusWallet: MutableList<Int> = mutableListOf(),
    private var calculater: Calculator = Calculator()
) {
    private var purchase_chance = 0
    private val _winningNumbers: List<Int> = winningNumbers
    private val _lottoWallet: List<Lotto> = lottoWallet
    private val _bonusWallet: List<Int> = bonusWallet

    fun startLotto() {
        receiveBudget()
        purchaseLotto()
        showLottos()
        receiveWinningNumbers()
        receiveBonusNumbers()
        presentStatics()
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
        purchase_chance = budget / Validator.LOTTO_PRICE

        for (i in 1..purchase_chance) {
            var flag = true
            while (flag) {
                runCatching {
                    val newLotto = Lotto(LottoMaker.createRandomLottoNumbers())
                    val newBonus = LottoMaker.createRandomBonusNumbers()
                    lottoWallet.add(newLotto)
                    bonusWallet.add(newBonus)
                }
                    .onSuccess { flag = false }
                    .onFailure { exception -> println(exception.message) }
            }
        }
    }

    fun showLottos() {
        println("\n${purchase_chance}개를 구매했습니다.")
        lottoWallet.map {
            println(it._numbers)
        }
    }

    fun receiveWinningNumbers() {
        var flag = true
        while (flag) {
            runCatching {
                println("\n당첨 번호를 입력해 주세요")
                val input = Console.readLine()
                val numbers = Validator.mapToWinningNumbers(input)
                winningNumbers.addAll(Validator.validateNumbers(numbers))
                winningNumbers.sort()
            }
                .onSuccess { flag = false }
                .onFailure { exception -> println(exception.message) }
        }
    }


    fun receiveBonusNumbers() {
        var flag = true
        while (flag) {
            runCatching {
                println("\n보너스 번호를 입력해 주세요.")
                val input = Console.readLine()
                bonusNumber = Validator.validateBonusNumber(input)
            }.onSuccess { flag = false }
                .onFailure { exception -> println(exception.message) }
        }
    }

    fun presentStatics() {
        calculater.calculateAllJackpot(
            _lottoWallet,
            _bonusWallet,
            _winningNumbers,
            bonusNumber
        )
        calculater.showAllCalculation()
    }
}