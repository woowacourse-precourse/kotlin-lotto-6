package lotto.ui

import camp.nextstep.edu.missionutils.Console
import lotto.validation.InputValidator
import lotto.extentions.stringToIntList

class LottoView {

    private lateinit var luckyNumbers: List<Int>

    fun getTicketPrice(): String {
        var inputPrice = ""
        var isValid = false

        while (!isValid) {
            try {
                inputPrice = askPurchaseTickets()
                validTicketPrice(inputPrice)

                isValid = true
            } catch (exception: IllegalArgumentException) {
                println(exception.message)
            } catch (exception: NumberFormatException) {
                println(exception.message)
            }
        }

        return inputPrice
    }

    fun getLuckyNumbers(): List<Int> {
        var inputLuckyNumbers = ""
        var isValid = false

        while (!isValid) {
            try {
                inputLuckyNumbers = askLuckyNumbers()
                validLuckyNumbers(inputLuckyNumbers)

                isValid = true
            } catch (exception: IllegalArgumentException) {
                println(exception.message)
            } catch (exception: NumberFormatException) {
                println(exception.message)
            }
        }

        this.luckyNumbers = inputLuckyNumbers.stringToIntList()

        return inputLuckyNumbers.stringToIntList()
    }

    fun getBonusNumber(): Int {
        var inputBonusNumber = ""
        var isValid = false

        while (!isValid) {
            try {
                inputBonusNumber = askBonusNumber()
                validBonusNumber(inputBonusNumber)

                isValid = true
            } catch (exception: IllegalArgumentException) {
                println(exception.message)
            } catch (exception: NumberFormatException) {
                println(exception.message)
            }
        }

        return inputBonusNumber.toInt()
    }

    fun calculateTicketCount(price: Int): Int = price / PRICE_PER_TICKET

    fun showPurchasedTicketCount(ticketCount: Int) {
        printWithNewLine("${ticketCount}개를 구매했습니다.")
    }

    fun showWinResult(ranks: List<Int>) {
        println("3개 일치 (5,000원) - ${ranks[RANK_5TH]}개")
        println("4개 일치 (50,000원) - ${ranks[RANK_4TH]}개")
        println("5개 일치 (1,500,000원) - ${ranks[RANK_3RD]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${ranks[RANK_2ND]}개")
        println("6개 일치 (2,000,000,000원) - ${ranks[RANK_1ST]}개")
    }

    fun showOverviewWinResult() {
        printWithNewLine("당첨 통계")
        println(DIVIDER)
    }

    fun showRateOfProfit(rateOfProfit: Double) {
        print("총 수익률은 ${rateOfProfit}%입니다.")
    }

    fun closeConsole() = Console.close()

    private fun printWithNewLine(output: String) {
        println(
            """
                
            $output
            """.trimIndent()
        )
    }

    private fun askPurchaseTickets(): String {
        println("구입금액을 입력해 주세요.")
        val inputPrice = getInputDataFromPlayer()

        return inputPrice
    }

    private fun askLuckyNumbers(): String {
        printWithNewLine("당첨 번호를 입력해 주세요.")
        val luckyNumbers = getInputDataFromPlayer()

        return luckyNumbers
    }

    private fun askBonusNumber(): String {
        printWithNewLine("보너스 번호를 입력해 주세요.")
        val bonusNumber = getInputDataFromPlayer()

        return bonusNumber
    }

    private fun validTicketPrice(price: String) {
        with(InputValidator) {
            checkInputBlank(price)
            checkInputEmpty(price)
            checkInputTypeAsInt(price)
            checkTicketPrice(price.toInt())
            checkMaxPrice(price.toInt())
        }
    }

    private fun validLuckyNumbers(numbers: String) {
        with(InputValidator) {
            checkInputBlank(numbers)
            checkInputEmpty(numbers)
            checkCommaBetweenNumbers(numbers)
            checkLottoNumberPrefix(numbers)
            checkLottoNumberPostfix(numbers)
            checkEmptyBetweenNumbers(numbers)
            checkLimitLottoNumber(numbers.split(DELIMITER_COMMA).map { it.toInt() })
        }
    }

    private fun validBonusNumber(number: String) {
        with(InputValidator) {
            checkInputBlank(number)
            checkInputEmpty(number)
            checkInputTypeAsInt(number)
            checkLimitBonusNumber(number.toInt())
            checkDuplicateBetweenBonusAndLuckyNumbers(number.toInt(), luckyNumbers)
        }
    }

    private fun getInputDataFromPlayer(): String = Console.readLine()

    companion object {
        private const val DELIMITER_COMMA: String = ","
        private const val DIVIDER: String = "---"

        private const val PRICE_PER_TICKET: Int = 1_000

        private const val RANK_1ST: Int = 1
        private const val RANK_2ND: Int = 2
        private const val RANK_3RD: Int = 3
        private const val RANK_4TH: Int = 4
        private const val RANK_5TH: Int = 5
    }
}