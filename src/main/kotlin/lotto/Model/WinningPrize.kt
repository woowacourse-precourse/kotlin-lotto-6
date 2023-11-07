package lotto.Model

import lotto.util.Constants.Companion.FIFTH_REWARD_MATCHED_COUNT
import lotto.util.Constants.Companion.FIFTH_REWARD_PRIZE
import lotto.util.Constants.Companion.FIRST_REWARD_MATCHED_COUNT
import lotto.util.Constants.Companion.FIRST_REWARD_PRIZE
import lotto.util.Constants.Companion.FOURTH_REWARD_MATCHED_COUNT
import lotto.util.Constants.Companion.FOURTH_REWARD_PRIZE
import lotto.util.Constants.Companion.SECOND_REWARD_MATCHED_COUNT
import lotto.util.Constants.Companion.SECOND_REWARD_PRIZE
import lotto.util.Constants.Companion.THIRD_REWARD_MATCHED_COUNT
import lotto.util.Constants.Companion.THIRD_REWARD_PRIZE

enum class WinningPrize(val matchedCount: Int, val prize: String) {
    // 등수가 어떻게 나올 수 있고, 결과가 어떻게 되는지 나타내는 enum 클래스.
    GRADE_5(FIFTH_REWARD_MATCHED_COUNT, FIFTH_REWARD_PRIZE),
    GRADE_4(FOURTH_REWARD_MATCHED_COUNT, FOURTH_REWARD_PRIZE),
    GRADE_3(THIRD_REWARD_MATCHED_COUNT, THIRD_REWARD_PRIZE),
    GRADE_2(SECOND_REWARD_MATCHED_COUNT, SECOND_REWARD_PRIZE),
    GRADE_1(FIRST_REWARD_MATCHED_COUNT, FIRST_REWARD_PRIZE);
}