package lotto.Model

import camp.nextstep.edu.missionutils.Randoms
import java.util.EnumMap

object LottoGameModel{
    lateinit var checkUserLottoScore: EnumMap<Score, Int>

    fun createRandomLottoNumbers(howManyBuyLotto: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()

        repeat(howManyBuyLotto) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottos.add(Lotto(numbers.sorted()))
//            println(numbers.sorted())
        }
        return lottos
    }

    fun getScore(madeLottoList: List<Lotto>, userLotto :Lotto, userBonus : Int): EnumMap<Score, Int> {
        checkUserLottoScore = EnumMap(Score::class.java)
        madeLottoList.forEach { _lotto ->
            val (matchCount, containBonusNumber) = matchLotto(_lotto, userLotto, userBonus)
            setScore(matchCount,containBonusNumber)
        }
        return checkUserLottoScore
    }

    fun matchLotto(lotto: Lotto, userLotto: Lotto, userBonus: Int ) : Pair<Int, Boolean>{
        var containBonus = lotto.getLottoNumbers().contains(userBonus)
        var matchCount = 0

        lotto.getLottoNumbers().forEach { _lottoNumber ->
            if(userLotto.getLottoNumbers().contains(_lottoNumber))
                matchCount++
        }
        return Pair(matchCount, containBonus)
    }

    fun setScore(matchCount : Int, containBonusNumber :Boolean){
        if(matchCount == Score.FIVE.matchNumber) checkScoreIsFiveWithBonus(containBonusNumber)

        when(matchCount){
            Score.THREE.matchNumber -> checkUserLottoScore[Score.THREE] = checkUserLottoScore.getOrDefault(Score.THREE,0) + 1
            Score.FOUR.matchNumber -> checkUserLottoScore[Score.FOUR] = checkUserLottoScore.getOrDefault(Score.FOUR,0) + 1
            Score.FIVE.matchNumber -> checkUserLottoScore[Score.FIVE] = checkUserLottoScore.getOrDefault(Score.FIVE,0) + 1
            Score.FIVEWITHBONUS.matchNumber -> checkUserLottoScore[Score.FIVEWITHBONUS] = checkUserLottoScore.getOrDefault(Score.FIVEWITHBONUS,0) + 1
            Score.SIX.matchNumber -> checkUserLottoScore[Score.SIX] = checkUserLottoScore.getOrDefault(Score.SIX,0) + 1
        }
    }

    fun checkScoreIsFiveWithBonus(containBonusNumber: Boolean): Score {
        if (containBonusNumber)
            return Score.FIVEWITHBONUS
        return Score.FIVE
    }

}