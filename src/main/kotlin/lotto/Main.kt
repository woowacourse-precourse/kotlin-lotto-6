package lotto
import lotto.service.LottoService
import lotto.utils.ConsoleUtils
import lotto.utils.RandomUtils


fun main() {
    val consoleUtils = ConsoleUtils()
    val randomUtils = RandomUtils()
    consoleUtils.inputPurchaseAmountMessage()
    consoleUtils.outputPurchaseCountMessage()
    randomUtils.lottoNumberCreat()
}
