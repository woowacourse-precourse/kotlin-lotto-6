package lotto.view

import lotto.model.WinningType

class Output {

    fun printWinStatics(winStatics: Map<WinningType, Int>) {
        println("당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${winStatics[WinningType.FIFTH]}개")
        println("4개 일치 (50,000원) - ${winStatics[WinningType.FOURTH]}개")
        println("5개 일치 (1,500,000원) - ${winStatics[WinningType.THIRD]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winStatics[WinningType.SECOND]}개")
        println("6개 일치 (2,000,000,000원) - ${winStatics[WinningType.FIRST]}개")
    }

    fun printTotalReturn() {

    }
}