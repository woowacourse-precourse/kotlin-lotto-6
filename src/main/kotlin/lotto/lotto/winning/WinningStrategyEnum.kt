package lotto.lotto.winning

enum class WinningStrategyEnum(
    val title: String,
    val prize: Int,
    val calculate: (List<Int>, WinningNumber) -> (Boolean)
) {
    FIRST("6개 일치 (2,000,000,000원)", 2_000_000_000, { target, winning ->
        val count = target.count {
            it in winning.numbers
        }
        count == 6
    }),

    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000, { target, winning ->
        val count = target.count {
            it in winning.numbers
        }
        count == 5 && target.contains(winning.bonus)
    }),

    THIRD("5개 일치 (1,500,000원)", 1_500_000, { target, winning ->
        val count = target.count {
            it in winning.numbers
        }
        count == 5
    }),

    FORTH("4개 일치 (50,000원)", 50_000, { target, winning ->
        val count = target.count {
            it in winning.numbers
        }
        count == 4
    }),

    FIFTH("3개 일치 (5,000원)", 5_000, { target, winning ->
        val count = target.count {
            it in winning.numbers
        }
        count == 3
    }),

}