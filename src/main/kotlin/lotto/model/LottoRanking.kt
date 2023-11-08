package lotto.model

enum class LottoRanking (val message: String, val price: Int, val matchingNumberCnt: Int, val matchingBonus: Boolean, var userLottoRankCnt: Int) {
    FIFTH_RANK("3개 일치", 5_000, 3, false, 0),
    FORTH_RANK("4개 일치", 50_000, 4, false, 0),
    THIRD_RANK("5개 일치", 1_500_000, 5, false, 0),
    SECOND_RANK("5개 일치, 보너스 볼 일치", 30_000_000, 5, true, 0),
    FIRST_RANK("6개 일치", 2_000_000_000, 6, false, 0);

    companion object{

        fun calculateMatchingLottoRank(winningLottoNumbers: Lotto, bonusLottoNumber: Int, userLottoList: List<Lotto>){
            for(userLotto in userLottoList) {
                val matchedLottoNumbers = matchLottoRank(winningLottoNumbers, bonusLottoNumber, userLotto)
                if (matchedLottoNumbers.first >= 3){
                    countUserLottoRank(findRank(matchedLottoNumbers))
                }

            }
        }
        private fun matchLottoRank(winningLottoNumbers: Lotto, bonusLottoNumber: Int, userLottoNumbers: Lotto): Pair<Int, Boolean>{
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
        private fun countUserLottoRank(userLottoRank: LottoRanking) {
            when(userLottoRank) {
                FIFTH_RANK -> FIFTH_RANK.userLottoRankCnt ++
                FORTH_RANK -> FORTH_RANK.userLottoRankCnt ++
                THIRD_RANK -> THIRD_RANK.userLottoRankCnt ++
                SECOND_RANK -> SECOND_RANK.userLottoRankCnt ++
                FIRST_RANK -> FIRST_RANK.userLottoRankCnt ++
                else -> throw IllegalArgumentException("존재하지 않는 로또 등수입니다.")
            }
        }
        private fun findRank(matchingResult: Pair<Int, Boolean>): LottoRanking {
            return when(matchingResult) {
                Pair(3, false) -> FIFTH_RANK
                Pair(4, false) -> FORTH_RANK
                Pair(5, false) -> THIRD_RANK
                Pair(5, true) -> SECOND_RANK
                Pair(6, false) -> FIRST_RANK
                else -> throw IllegalArgumentException("존재하지 않는 로또 당첨 등급입니다.")
            }
        }
    }
}