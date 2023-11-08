package lotto

class Calculator(
    private val userLotto: List<Int>,
    private val bonusNum: Int,
    private val lottoMachine: MutableList<List<Int>>
) {
//비교하는 곳 , 나 이거 비교해줘! 라는 곳에 대한 대답
//그러려면 사용자가 입력한 값과 로또 리스트를 비교하는자가 가지고 있어야겠지?

    val lottoResult = mutableMapOf<MatchedCount, Int>(
        MatchedCount.FIFTH to 0,
        MatchedCount.FOURTH to 0,
        MatchedCount.THIRD to 0,
        MatchedCount.SECOND to 0,
        MatchedCount.FIRST to 0,
    )

    private fun compareNum() {
        //로또속 번호와 사용자가 입력한 번호를 비교해서 몇개가 당첨인지를 알수 있다.
        for (lotto in lottoMachine) {

            val matchedNumbers = lotto.intersect(userLotto).size
            val isBonusMatched = userLotto.contains(bonusNum)    //보너스 볼이 포함 되어 있는지 확인

            val lottoRank = MatchedCount.fromMatchedNumbers(matchedNumbers, isBonusMatched)
            if (lottoRank != MatchedCount.NONE) lottoResult[lottoRank] = lottoResult.getOrDefault(lottoRank, 0) + 1
        }
    }

    //사용자의 로또와 컴터 한장 로또가 포함되어 있는지
    //포함되어이씅면 count++
    //보너스도 확인


}