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
                winningPrize = 5_000
                return 5
            }

            4 -> {
                winningPrize = 50_000
                return 4
            }

            5 -> {
                if (numbers.contains(bonusNumber)) {
                    winningPrize = 30_000_000
                    return 2
                } else {
                    winningPrize = 1_500_000
                    3
                }
            }

            6 -> {
                winningPrize = 2_000_000_000
                return 1
            }

            else -> 0
        }
    }

}
