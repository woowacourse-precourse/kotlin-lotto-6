package lotto.model

class Jackpot {
    fun discriminate(answers: List<Int>, bonus: Int, lotto: List<List<Int>>) :List<Int>{
        var rank = mutableListOf<Int>()
        repeat(Constants.FIVE) {
            rank.add(0)
        }
        for (eachLotto in lotto) {
            var count = Constants.ZERO
            var bonusCount = Constants.ZERO
            for (number in answers) {
                if (eachLotto.contains(number)) {
                    count++
                }
                if (eachLotto.contains(bonus)) {
                    bonusCount++
                }
            }
            if (count == Constants.THREE) {
                rank[Constants.ZERO]++
            } else if (count == Constants.FIVE && bonusCount == Constants.ONE) {
                rank[Constants.THREE]++
            } else if (count == Constants.FOUR) {
                rank[Constants.ONE]++
            } else if (count == Constants.FIVE) {
                rank[Constants.TWO]++
            } else if (count == Constants.SIX) {
                rank[Constants.FOUR]++
            }
        }
        return rank
    }

}