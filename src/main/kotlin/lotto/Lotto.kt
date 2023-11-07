package lotto

class Lotto(private val numbers: List<Int>) {
    var winningPrize = 0;

    init {
        require(numbers.size == 6)
    }

    fun printLottoNumbers() {
        println(numbers)
    }

    fun getLotteryOutcome(winningNumbers: List<Int>, bonusNumber: Int): Int {
        var winning: Int = 0
        for (item in winningNumbers) {
            if (numbers.contains(item)) {
                winning += 1
            }
        }

        return when (winning) {
            3 -> {
                winningPrize = PRIZE[5]
                return 5
            }

            4 -> {
                winningPrize = PRIZE[4]
                return 4
            }

            5 -> {
                if (!numbers.contains(bonusNumber)) {
                    winningPrize = PRIZE[3]
                    return 3
                } else {
                    winningPrize = PRIZE[2]
                    2
                }
            }

            6 -> {
                winningPrize = PRIZE[1]
                return 1
            }

            else -> 0
        }
    }

}
