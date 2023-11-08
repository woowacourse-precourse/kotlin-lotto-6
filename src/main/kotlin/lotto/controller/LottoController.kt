package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.model.Customer
import lotto.model.Lotto
import lotto.model.Profit
import lotto.model.Rank
import lotto.model.Store
import lotto.model.Winning
import lotto.utils.Constants.ERROR_INPUT_BLANK_OR_CHAR
import lotto.utils.Constants.LOTTO_PURCHASE_UNIT
import lotto.utils.Validate.validateBonusNumber
import lotto.utils.Validate.validatePay
import lotto.utils.Validate.validateWinningNumber
import lotto.view.InputView.printBonusNumberInputMessage
import lotto.view.InputView.printPayInputMessage
import lotto.view.InputView.printWinningNumberInputMessage
import lotto.view.OutPutView.printLottoRankResult
import lotto.view.OutPutView.printProduceLottoResult
import lotto.view.OutPutView.printProfitResult


class LottoController {
    private val customer: Customer = Customer()
    private val store: Store = Store()
    private val winning: Winning = Winning()
    private val rank: Rank = Rank()
    private val profit: Profit = Profit()

    fun run() {
        inputCustomerPay()
        produceLotto()
        printLotto()
        inputWinningNumbers()
        inputBonusNumber()
        rankLotto()
        printLottoRanking()
        calculateProfit()
        printProfit()
    }

    private fun inputCustomerPay() {
        while (true) {
            printPayInputMessage()
            try {
                val payment =
                    Console.readLine().toIntOrNull() ?: throw IllegalArgumentException(ERROR_INPUT_BLANK_OR_CHAR)
                validatePay(payment)
                customer.setPay(payment)
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun produceLotto() {
        val piece = customer.getPay() / LOTTO_PURCHASE_UNIT
        val newLottoCollection: MutableList<Lotto> = store.produceLottoNumber(piece)
        customer.setLottoCollection(newLottoCollection)
    }

    private fun printLotto() {
        val produceLottoResult = customer.getLottoCollection()
        printProduceLottoResult(produceLottoResult)
    }

    private fun inputWinningNumbers() {
        while (true) {
            printWinningNumberInputMessage()
            try {
                val newWinningNumbers = Console.readLine()
                validateWinningNumber(newWinningNumbers)
                winning.setWinningNumbers(newWinningNumbers.split(",").map { it.trim().toInt() })
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun inputBonusNumber() {
        while (true) {
            printBonusNumberInputMessage()
            try {
                val newBonusNumber =
                    Console.readLine().toIntOrNull() ?: throw IllegalArgumentException(ERROR_INPUT_BLANK_OR_CHAR)
                validateBonusNumber(newBonusNumber, winning.getWinningNumbers())
                winning.setBonusNumber(newBonusNumber)
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun rankLotto() {
        val rankCount = rank.analyzeLottoRanking(customer.getLottoCollection(), winning)
        rank.setRankCount(rankCount)
    }

    private fun printLottoRanking() {
        printLottoRankResult(rank.getRankCount())
    }

    private fun calculateProfit() {
        profit.calculateLottoProfit(rank.getRankCount(), customer.getPay())
    }

    private fun printProfit() {
        printProfitResult(profit.getProfit())
    }
}