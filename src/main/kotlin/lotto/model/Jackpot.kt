package lotto.model

class Jackpot {
    fun discriminate(answers: List<Int>, bonus: Int, lotto: List<List<Int>>): List<Int> {
        var rank = rankInitiate()
        for (eachLotto in lotto) {
            val count = countDiscriminate(answers,eachLotto)
            val bonusCount = bonusDiscriminate(answers,eachLotto,bonus)
            rank = rankUpdate(count,rank,bonusCount)
        }
        return rank
    }
    fun rankUpdate(count: Int,rank:MutableList<Int>,bonusCount:Int):MutableList<Int>{
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
        return rank
    }
    fun rankInitiate():MutableList<Int>{
        val rank = mutableListOf<Int>()
        repeat(Constants.FIVE) {
            rank.add(0)
        }
        return rank
    }
    fun countDiscriminate(answers:List<Int>,eachLotto: List<Int>): Int {
        var count = Constants.ZERO
        for (number in answers) {
            if (eachLotto.contains(number)) {
                count++
            }
        }
        return count
    }

    fun bonusDiscriminate(answers:List<Int>,eachLotto: List<Int>, bonus: Int): Int {
        var bonusCount = Constants.ZERO
        for (number in answers) {
            if (eachLotto.contains(bonus)) {
                bonusCount++
            }
        }
        return bonusCount
    }


}