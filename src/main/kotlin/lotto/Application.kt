package lotto

import lotto.controller.LottoGameController

fun main() {
    //TODO("프로그램 구현")
    val lottoGameController = LottoGameController()
    lottoGameController.start()

    lottoGameController.result()
}
