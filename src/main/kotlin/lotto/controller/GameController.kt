package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.global.InformationMessage
import lotto.service.IssuerService
import lotto.service.LottoService

class GameController {
	private val issuerService = IssuerService()
	private val lottoService = LottoService()

	fun start() {
		println(InformationMessage.PURCHASE_AMOUNT.message)
		purchase()

		println(InformationMessage.WINNING_NUMBER.message)
		winningNumber()

		println(InformationMessage.BONUS_NUMBER.message)
		bonusNumber()

		println(InformationMessage.WINNING_STATISTIC.message)
		checkLottoNumber()
	}

	private fun purchase() {
		try {
			val input = Console.readLine()
			val count = issuerService.purchaseLotto(input)
			println("\n$count${InformationMessage.PURCHASE_SUCCESS.message}")
			issuerService.createLotto(count).forEach(::println)
		} catch (e: IllegalArgumentException) {
			println(e.message)
			purchase()
		}
	}

	private fun winningNumber() {
		try {
			val input = Console.readLine()
			lottoService.winningNumber(input)
		} catch (e: IllegalArgumentException) {
			println(e.message)
			winningNumber()
		}
	}

	private fun bonusNumber() {
		try {
			val input = Console.readLine()
			lottoService.bonusNumber(input)
		} catch (e: IllegalArgumentException) {
			println(e.message)
			bonusNumber()
		}
	}

	private fun checkLottoNumber() {
		val matches: IntArray = intArrayOf(0, 0, 0, 0, 0)
		val winningNumber = lottoService.getLotto()
		val bonusNumber = lottoService.getBonus()
		val lottos = issuerService.getLotto()
		println(winningNumber)

		// 로직
		var tempMatch = 0
		lottos.forEach{ it: MutableSet<Int> ->
			for(i in it) {
				if(winningNumber.contains(i)) {
					println("contain")
					tempMatch++
				}
			}
			when(tempMatch) {
				3 -> matches[0] = matches[0]++
				4 -> matches[1] = matches[1]++
				5 -> if(!it.contains(bonusNumber)) {matches[2] = matches[2]++} else {matches[3] = matches[3]++}
				6 -> matches[4] = matches[4]++
			}
		}
		rate(matches)
	}

	fun rate(matches: IntArray) {
		matches
	}
}