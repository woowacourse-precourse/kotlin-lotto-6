package lotto.view

import lotto.domain.Lotto
import lotto.domain.Place
import lotto.util.Constant.FIFTH_PLACE_MESSAGE
import lotto.util.Constant.FIRST_PLACE_MESSAGE
import lotto.util.Constant.FOURTH_PLACE_MESSAGE
import lotto.util.Constant.INPUT_BONUS_NUMBER_MESSAGE
import lotto.util.Constant.INPUT_LUCKY_NUMBER_MESSAGE
import lotto.util.Constant.INPUT_PRICE_MESSAGE
import lotto.util.Constant.LOTTO_BUY_MESSAGE
import lotto.util.Constant.SECOND_PLACE_MESSAGE
import lotto.util.Constant.THIRD_PLACE_MESSAGE
import lotto.util.Constant.TOTAL_EARNING_RATE_MESSAGE
import lotto.util.Constant.UNIT_PRICE
import lotto.util.Constant.WINNING_STATISTICS_MESSAGE

class OutputView {

    fun printInputPrice() = println(INPUT_PRICE_MESSAGE)
    fun printBuyLotto(price: Int) = println("\n${LOTTO_BUY_MESSAGE.format(price / UNIT_PRICE)}")
    fun printUserLotto(lottoes: List<Lotto>) = lottoes.forEach { lotto -> println(lotto.getLottoNumbers()) }

    fun printInputLuckyNumber() = println("\n${INPUT_LUCKY_NUMBER_MESSAGE}")
    fun printInputBonusNumber() = println("\n${INPUT_BONUS_NUMBER_MESSAGE}")
    fun printWinStatisticsMessage() = println("\n${WINNING_STATISTICS_MESSAGE}")
    fun printWinStatisticsResult(map: Map<Place,Int>) {
        println(FIFTH_PLACE_MESSAGE.format(map.getOrElse(Place.Fifth) { 0 }))
        println(FOURTH_PLACE_MESSAGE.format(map.getOrElse(Place.Fourth) { 0 }))
        println(THIRD_PLACE_MESSAGE.format(map.getOrElse(Place.Third) { 0 }))
        println(SECOND_PLACE_MESSAGE.format(map.getOrElse(Place.Second) { 0 }))
        println(FIRST_PLACE_MESSAGE.format(map.getOrElse(Place.First) { 0 }))
    }
    fun printTotalEarningRate(earnRate : Double) = println(TOTAL_EARNING_RATE_MESSAGE.format(earnRate))
}