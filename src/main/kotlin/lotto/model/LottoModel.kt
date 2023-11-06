package lotto.model

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.*
import lotto.controller.*
import org.mockito.plugins.MockMaker

class LottoModel { // 연산 처리
    fun calculateLottoCount(input: Int): Int { // 로또 개수 계산4
        var lottoCount: Int = (input / Value.LOTTO_COST)
        if (input % Value.LOTTO_COST == 0) {
            return lottoCount
        } else {
            return throw IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_TOTAL_COST)
        }
    }

    fun randomNumberMaker(): Int { // 난수 생성
        return Randoms.pickNumberInRange(Value.MINIMUM_LOTTO_NUMBER_BOUNDARY, Value.MAXIMUM_LOTTO_NUMBER_BOUNDARY)
    }

    fun lottoAnswerNumberList(input: String): List<Int> { // 로또 당첨 번호 리스트 6자리 저장
        return input.split(",").map { it.toInt() }.toMutableList()
    }

    fun randomLottoMaker(): MutableList<Int> { // 로또 6자리 생성
        var lottoAnswer = mutableListOf<Int>()
        var i = Value.MINIMUM_LOTTO_NUMBER_COUNT
        while (i != Value.MAXIMUM_LOTTO_NUMBER_COUNT) {
            var randomInput = randomNumberMaker()
            i++
            if (lottoAnswer.contains(randomInput)) {
                i--
            } else {
                lottoAnswer.add(randomInput)
            }
//            println("lotto ${i} ${lottoAnswer}")
        }
        lottoAnswer.sort() // 오름차순으로 정렬
        return lottoAnswer
    }

    fun totalLottoMaker(count: Int): List<List<Int>> { // 전체 구매 로또 번호를 담은 이중 리스트
        var allLotto: MutableList<MutableList<Int>> = mutableListOf()
        for (i in Value.MINIMUM_LOTTO_NUMBER_COUNT until count) {
            allLotto.add(randomLottoMaker())
        }
        return allLotto
    }

    //
    fun winLottoMatchCount(inputCount:Int, inputLotto: List<List<Int>>, inputAnswer: List<Int>, inputBonus:Int): List<Int> {
        var Answer = mutableListOf(0,0,0,0,0)
        var bonusCheck: Boolean = false

        for (a in 0 until inputCount){
            if(inputLotto[a].contains(inputBonus)){
                bonusCheck = true
            }

            var matchingCount = 0;

            for (i in 0 until Value.MAXIMUM_LOTTO_NUMBER_COUNT) {
                if (inputAnswer.contains(inputLotto[a].get(i))) {
                    matchingCount++
                }
            }

            if(matchingCount == Value.WINNER_NUMBER_MATCH_5TH) {
                Answer[0]++
            } else if(matchingCount == Value.WINNER_NUMBER_MATCH_4TH) {
                Answer[1]++
            } else if(matchingCount == Value.WINNER_NUMBER_MATCH_3TH) {
                Answer[2]++
            } else if(matchingCount == Value.WINNER_NUMBER_MATCH_2TH && bonusCheck) {
                Answer[3]++
            } else if(matchingCount == Value.WINNER_NUMBER_MATCH_1TH) {
                Answer[4]++
            }

        }

        return Answer
    }


}
