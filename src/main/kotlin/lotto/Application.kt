package lotto

import lotto.controller.*
import lotto.model.*
import lotto.view.*
import lotto.utils.*
import javax.naming.ldap.Control

fun main() {
//    TODO("프로그램 구현")

    val lottoController = LottoController()
    val lottoModel = LottoModel()
    val lottoView = LottoView()
    //

    lottoView.printRequestCost() // 구입금액 요청 출력
    var lottoCost = lottoController.inputLottoCost() // 구입금액 입력

    var lottoCheckCost = lottoModel.checkLottoCost(lottoCost)


    var lottoCostNum: Double = lottoCost.toDouble()

    var lottoCount = lottoModel.calculateLottoCount(lottoCost) // 구입 개수 저장
    lottoView.printLottoCountCheck(lottoCount) // 구입한 로또 개수 확인 문구 출력

    var lottoAllList = lottoModel.totalLottoMaker(lottoCount) // 로또 전체 리스트
    lottoView.printLottoAllList(lottoAllList)

    lottoView.printRequestWinNumber() //
    var lottoAnswer = lottoController.inputLottoAnswerNumber()
    var finalLottoAnswer = lottoModel.lottoAnswerNumberList(lottoAnswer)

    lottoView.printRequestBonusNumber()
    var lottoBonusAnswer = lottoController.inputLottoBonusNumber()

    lottoView.printTotalResult()
    lottoView.printTotalArea()

    var finalAnswer = lottoModel.winLottoMatchCount(lottoCount, lottoAllList, finalLottoAnswer, lottoBonusAnswer)

    println("${PrintMessage.WINNER_REWARD_5TH} ${finalAnswer.get(0)}개")
    println("${PrintMessage.WINNER_REWARD_4TH} ${finalAnswer.get(1)}개")
    println("${PrintMessage.WINNER_REWARD_3TH} ${finalAnswer.get(2)}개")
    println("${PrintMessage.WINNER_REWARD_2TH} ${finalAnswer.get(3)}개")
    println("${PrintMessage.WINNER_REWARD_1TH} ${finalAnswer.get(4)}개")

    var moneySum = 0.0
    for(i in 0 until finalAnswer.size) {
        var seedMoney = 0.0
        if(i==0){
            seedMoney = 5000.0
        } else if(i==1){
            seedMoney = 50000.0
        } else if(i==2){
            seedMoney = 1500000.0
        } else if(i==3){
            seedMoney = 30000000.0
        } else if(i==4){
            seedMoney = 2000000000.0
        }
        moneySum += seedMoney * finalAnswer.get(i)
    }

    var moneyRate:Double = moneySum / lottoCostNum * 100.0

    println("${PrintMessage.PRINT_TOTAL_RATE}${moneyRate}${PrintMessage.PRINT_TOTAL_END_MESSAGE}")


}
