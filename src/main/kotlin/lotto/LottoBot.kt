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
    private var purchaseChance = 0
    private val _winningNumbers: List<Int> = winningNumbers
    private val _lottoWallet: List<Lotto> = lottoWallet
    private val _bonusWallet: List<Int> = bonusWallet

    fun startLotto() {
        receiveBudget()
        purchaseLotto()
        showLottos()
        receiveWinningNumbers()
        receiveBonusNumbers()
        presentCalculationResult()
    }

    private fun receiveBudget() {
        var flag = true
        while (flag) {
            try {
                println("구입금액을 입력해주세요.")
                val input = Console.readLine()
                budget = Validator.validateBudget(input)
                flag = false
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun purchaseLotto() {
        purchaseChance = budget / Validator.LOTTO_PRICE
        while (lottoWallet.size < purchaseChance) {
            try {
                val newLotto = Lotto(LottoMaker.createRandomLottoNumbers())
                val newBonus = LottoMaker.createRandomBonusNumbers()
                lottoWallet.add(newLotto)
                bonusWallet.add(newBonus)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun showLottos() {
        println("${purchaseChance}개를 구매했습니다.")
        lottoWallet.map {
            println(it._numbers)
        }
    }

    private fun receiveWinningNumbers() {
        var flag = true
        while (flag) {
            try {
                println("당첨 번호를 입력해 주세요.")
                val input = Console.readLine()
                val numbers = Validator.mapToWinningNumbers(input)
                winningNumbers.addAll(Validator.validateNumbers(numbers))
                winningNumbers.sort()
                flag = false
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }


    private fun receiveBonusNumbers() {
        var flag = true
        while (flag) {
            runCatching {
                println("보너스 번호를 입력해 주세요.")
                val input = Console.readLine()
                bonusNumber = Validator.validateBonusNumber(input)
            }
                .onSuccess { flag = false }
                .onFailure { exception -> println(exception.message) }
        }
    }

    private fun presentCalculationResult() {
        calculater.calculateAllJackpot(
            _lottoWallet,
            _bonusWallet,
            _winningNumbers,
            bonusNumber
        )
        calculater.showAllCalculation()
        calculater.calculateProfitRate(budget)
        calculater.showProfitRate()
    }
}