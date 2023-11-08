package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.global.InformationMessage
import lotto.service.LottoService
import lotto.service.WinningService
import lotto.service.RankService

class GameController {
	private val lottoService = LottoService()
	private val winningService = WinningService()
	private val rankService = RankService()

	fun start() {
		println(InformationMessage.PURCHASE_AMOUNT.message)
		purchase()

		println("\n${InformationMessage.WINNING_NUMBER.message}")
		winningNumber()

		println("\n${InformationMessage.BONUS_NUMBER.message}")
		bonusNumber()

		println("\n${InformationMessage.WINNING_STATISTIC.message}")
		checkLottoNumber()
	}

	private fun purchase() {
		try {
			val input = Console.readLine()
			val count = lottoService.purchaseLotto(input)
			println("\n$count${InformationMessage.PURCHASE_SUCCESS.message}")
			lottoService.createLotto(count)
		} catch (e: IllegalArgumentException) {
			println(e.message)
			purchase()
		}
	}

	private fun winningNumber() {
		try {
			val input = Console.readLine()
			winningService.winningNumber(input)
		} catch (e: IllegalArgumentException) {
			println(e.message)
			winningNumber()
		}
	}

	private fun bonusNumber() {
		try {
			val input = Console.readLine()
			winningService.bonusNumber(input)
		} catch (e: IllegalArgumentException) {
			println(e.message)
			bonusNumber()
		}
	}

	private fun checkLottoNumber() {
		val winningNumber = winningService.getLotto()
		val bonusNumber = winningService.getBonus()
		val lottos = lottoService.getLotto()

		val matches = rankService.rateRank(winningNumber, bonusNumber, lottos)
		println(InformationMessage.place(matches))

		calculateReturn(matches)
	}

	private fun calculateReturn(matches: MutableList<Int>) {
		val price = lottoService.getPrice()
		println(InformationMessage.returnRate(rankService.calculateReturn(price, matches)))
	}
}