package lotto.model

import lotto.utils.Constant.FIFTH_REWARD_MATCHED_COUNT
import lotto.utils.Constant.FIRST_REWARD_PRIZE
import lotto.utils.Constant.SECOND_REWARD_PRIZE
import lotto.utils.Constant.THIRD_REWARD_PRIZE
import lotto.utils.Constant.FOURTH_REWARD_PRIZE
import lotto.utils.Constant.FIFTH_REWARD_PRIZE
import lotto.utils.Constant.FIRST_REWARD_MATCHED_COUNT
import lotto.utils.Constant.FOURTH_REWARD_MATCHED_COUNT
import lotto.utils.Constant.SECOND_REWARD_MATCHED_COUNT
import lotto.utils.Constant.THIRD_REWARD_MATCHED_COUNT

enum class LottoReward(val matchedCount: Int, val prize: String) {
    FIRST(FIRST_REWARD_MATCHED_COUNT, FIRST_REWARD_PRIZE),
    SECOND(SECOND_REWARD_MATCHED_COUNT, SECOND_REWARD_PRIZE),
    THIRD(THIRD_REWARD_MATCHED_COUNT, THIRD_REWARD_PRIZE),
    FOURTH(FOURTH_REWARD_MATCHED_COUNT, FOURTH_REWARD_PRIZE),
    FIFTH(FIFTH_REWARD_MATCHED_COUNT, FIFTH_REWARD_PRIZE),
}