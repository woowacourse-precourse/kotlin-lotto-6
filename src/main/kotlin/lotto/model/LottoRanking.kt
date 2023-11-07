package lotto.model

enum class LottoRanking (val message: String, val price: Int, val matchingNumberCnt: Int, val matchingBonus: Boolean, var userLottoRankCnt: Int) {
    FIFTH_RANK("3개 일치", 5_000, 3, false, 0),
    FORTH_RANK("4개 일치", 50_000, 4, false, 0),
    THIRD_RANK("5개 일치", 1_500_000, 5, false, 0),
    SECOND_RANK("5개 일치, 보너스 볼 일치", 30_000_000, 5, true, 0),
    FIRST_RANK("6개 일치", 2_000_000_000, 6, false, 0);

    companion object{
        fun matchLottoRank(winningLottoNumbers: Lotto, bonusLottoNumber: Int, userLottoNumbers: Lotto): Pair<Int, Boolean>{
            var matchingNumberCnt = 0
            var matchingBonus = false
            for (userLottoNum in userLottoNumbers.getLotto()){
                if (userLottoNum in winningLottoNumbers.getLotto()){
                    matchingNumberCnt ++
                }
            }
            if (matchingNumberCnt == 5 && bonusLottoNumber in userLottoNumbers.getLotto()){
                matchingBonus = true
            }
            return Pair(matchingNumberCnt, matchingBonus)
        }
        fun countUserLottoRank(userLottoRank: LottoRanking) {
            when(userLottoRank) {
                LottoRanking.FIFTH_RANK -> FIFTH_RANK.userLottoRankCnt + 1
                LottoRanking.FORTH_RANK -> FORTH_RANK.userLottoRankCnt + 1
                LottoRanking.THIRD_RANK -> THIRD_RANK.userLottoRankCnt + 1
                LottoRanking.SECOND_RANK -> SECOND_RANK.userLottoRankCnt + 1
                LottoRanking.FIRST_RANK -> FIRST_RANK.userLottoRankCnt + 1
                else -> throw IllegalArgumentException("존재하지 않는 로또 등수입니다.")
            }
        }
        fun findRank(matchingResult: Pair<Int, Boolean>): LottoRanking {
            return when(matchingResult) {
                Pair(3, false) -> LottoRanking.FIFTH_RANK
                Pair(4, false) -> LottoRanking.FORTH_RANK
                Pair(5, false) -> LottoRanking.THIRD_RANK
                Pair(5, true) -> LottoRanking.SECOND_RANK
                Pair(6, false) -> LottoRanking.FIRST_RANK
                else -> throw IllegalArgumentException("존재하지 않는 로또 당첨 여부입니다.")
            }
        }
    }
}