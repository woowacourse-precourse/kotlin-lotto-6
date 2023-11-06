package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGame(private val user: User) {

    fun start() {
        showMessage(INPUT_AMOUNT_MESSAGE)
        val amount = inputAmountFromUser()
        println(amount)

        showMessage(INPUT_WINNING_NUMBERS_MESSAGE)
        val winningNumbers = inputWinningNumbersFromUser()
        println(winningNumbers)

        showMessage(INPUT_BONUS_NUMBER_MESSAGE)
        val bonusNumber = inputBonusNumberFromUser()
        println(bonusNumber)

        val lottoCount = calculateLottoCount(amount)
        showMessage(PURCHASED_LOTTO_COUNT_MESSAGE.format(lottoCount))

        val lottos = publishLottos(lottoCount)
        lottos.forEach { showMessage(makeLottoNumbersMessage(it)) }
    }

    private fun inputAmountFromUser(): Int {
        while (user.amount == 0) {
            try {
                user.inputAmount()
            } catch (e: IllegalArgumentException) {
                showErrorMessage(e.message ?: UNKNOWN_ERROR_MESSAGE)
            }
        }

        return user.amount
    }

    private fun inputWinningNumbersFromUser(): List<Int> {
        while (user.winningNumbers.isEmpty()) {
            try {
                user.inputWinningNumbers()
            } catch (e: IllegalArgumentException) {
                showErrorMessage(e.message ?: UNKNOWN_ERROR_MESSAGE)
            }
        }

        return user.winningNumbers
    }

    private fun inputBonusNumberFromUser(): Int {
        while (user.bonusNumber == 0) {
            try {
                user.inputBonusNumber()
            } catch (e: IllegalArgumentException) {
                showErrorMessage(e.message ?: UNKNOWN_ERROR_MESSAGE)
            }
        }

        return user.bonusNumber
    }

    private fun calculateLottoCount(amount: Int): Int = amount / User.AMOUNT_UNIT

    private fun publishLottos(lottoCount: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()

        repeat(lottoCount) {
            val lotto = Lotto(generateLottoNumbers())
            lottos.add(lotto)
        }

        return lottos
    }

    private fun generateLottoNumbers(): List<Int> =
        Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.NUMBER_COUNT)

    private fun makeLottoNumbersMessage(lotto: Lotto): String = LOTTO_NUMBERS_MESSAGE.format(parseLottoNumbers(lotto))

    private fun parseLottoNumbers(lotto: Lotto): String = lotto.getSortedNumbers().joinToString(LOTTO_NUMBER_SEPARATOR)

    private fun showMessage(message: String) = println(message)

    private fun showErrorMessage(errorMessage: String) = println("$PREFIX_ERROR_MESSAGE $errorMessage")

    companion object {
        const val PREFIX_ERROR_MESSAGE = "[ERROR]"
        const val UNKNOWN_ERROR_MESSAGE = "알 수 없는 에러가 발생했습니다."

        const val INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
        const val INPUT_WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요."
        const val INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요."
        const val PURCHASED_LOTTO_COUNT_MESSAGE = "\n%d개를 구매했습니다."

        const val LOTTO_NUMBERS_MESSAGE = "[%s]"
        const val LOTTO_NUMBER_SEPARATOR = ", "
    }
}