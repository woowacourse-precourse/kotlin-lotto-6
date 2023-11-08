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
        for (lotto in lottoMachine) {
            val matchedNumbers = lotto.count { it in userLotto }
            val isBonusNumberMatched = userLotto.contains(lotto.last()) // 보너스 볼 확인

            val matchedCount = MatchedCount.fromMatchedNumbers(matchedNumbers, isBonusNumberMatched)
            val currentCount = lottoResult[matchedCount] ?: 0
            lottoResult[matchedCount] = currentCount + 1
        }
    }




    //사용자의 로또와 컴터 한장 로또가 포함되어 있는지
    //포함되어이씅면 count++
    //보너스도 확인


}