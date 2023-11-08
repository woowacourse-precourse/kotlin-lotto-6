package lottoView

enum class WinningReward(val correspondResult: String, val price: Int)
    {
        THREE("3개 일치", 5000),
        FOUR("4개 일치", 50000),
        FIVE("5개 일치", 1500000),
        FIVEANDBONUS("5개 일치, 보너스 볼 일치", 30000000),
        SIX("6개 일치", 2000000000),
        ZERO("3개 미만 일치", 0)
    }