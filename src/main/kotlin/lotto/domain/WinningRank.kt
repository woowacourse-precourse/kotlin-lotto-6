package lotto.domain

enum class WinningRank(
    val message: String,
    val winningPrize: Int
) {

    NO_MATCHES("2개 이하 일치", 0) {

    },

    THREE_MATCHES("3개 일치", 5000) {

    },

    FOUR_MATCHES("4개 일치", 50000) {

    },

    FIVE_MATCHES("5개 일치", 1500000) {

    },

    FIVE_MATCHES_WITH_BONUS_NUMBER("5개 일치, 보너스 볼 일치", 30000000) {

    },

    SIX_MATCHES("6개 일치", 2000000000) {

    };

}