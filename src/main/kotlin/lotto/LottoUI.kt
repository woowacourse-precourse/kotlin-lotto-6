package lotto
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class LottoUI {

    //로또 구입 시작
    fun lottoExc(){

        LottoData.purchaseNum = LottoController.lottoPurchase()
        //로또 개수 입력 받기

        LottoController.lottoDraw()
        //로또 뽑기



    }





}