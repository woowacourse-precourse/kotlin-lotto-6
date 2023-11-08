package lotto.model

class Jackpot {
    fun discriminate(answers: List<Int>, bonus: Int, lotto: List<List<Int>>): List<Int> {
        var rank = rankInitiate()
        for (eachLotto in lotto) {
            val count = countDiscriminate(answers, eachLotto)
            val bonusCount = bonusDiscriminate(eachLotto, bonus)
            rank = rankUpdate(count, rank, bonusCount)
        }
        return rank
    }

    fun rankUpdate(count: Int, rank: MutableList<Int>, bonusCount: Boolean): MutableList<Int> {
        if (count == NumberConstants.THREE.value) {
            rank[NumberConstants.ZERO.value]++
        } else if (count == NumberConstants.FIVE.value && bonusCount) {
            rank[NumberConstants.THREE.value]++
        } else if (count == NumberConstants.FOUR.value) {
            rank[NumberConstants.ONE.value]++
        } else if (count == NumberConstants.FIVE.value) {
            rank[NumberConstants.TWO.value]++
        } else if (count == NumberConstants.SIX.value) {
            rank[NumberConstants.FOUR.value]++
        }
        return rank
    }

    fun rankInitiate(): MutableList<Int> {
        val rank = mutableListOf<Int>()
        repeat(NumberConstants.FIVE.value) {
            rank.add(0)
        }
        return rank
    }

    fun countDiscriminate(answers: List<Int>, eachLotto: List<Int>): Int {
        var count = NumberConstants.ZERO.value
        for (number in answers) {
            if (eachLotto.contains(number)) {
                count++
            }
        }
        return count
    }

    fun bonusDiscriminate(eachLotto: List<Int>, bonus: Int): Boolean {
        var bonusCount = false
        if (eachLotto.contains(bonus)) {
            bonusCount = !bonusCount
        }
        return bonusCount
    }


}