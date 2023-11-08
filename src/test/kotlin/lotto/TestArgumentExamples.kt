package lotto

import lotto.model.Lotto
import lotto.model.Winner
import org.junit.jupiter.params.provider.Arguments
import java.util.*

object TestArgumentExamples {

    // TestArguments :: LottoServiceTest - getWinningMap - 구매한 로또에서 당첨내역을 확인
    val WINNING_MAP_ARGUMENT_EXAMPLE_FIRST: Arguments = Arguments.of(
        listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)), // 1등 : Winner.FIRST_GRADE
            Lotto(listOf(1, 2, 3, 4, 5, 7)), // 2등 : Winner.SECOND_GRADE
            Lotto(listOf(1, 2, 3, 4, 5, 8)), // 3등 : Winner.THIRD_GRADE
        ), Lotto(listOf(1, 2, 3, 4, 5, 6)), 7,
        EnumMap(mapOf(Winner.FIRST_GRADE to 1, Winner.SECOND_GRADE to 1, Winner.THIRD_GRADE to 1))
    )
    val WINNING_MAP_ARGUMENT_EXAMPLE_SECOND: Arguments = Arguments.of(
        listOf(
            Lotto(listOf(2, 3, 5, 6, 7, 44)), // 3등 : Winner.THIRD_GRADE
            Lotto(listOf(2, 3, 4, 5, 10, 11)), // 4등 : Winner.FOURTH_GRADE
            Lotto(listOf(2, 3, 4, 11, 12, 13)), // 5등 : Winner.FIFTH_GRADE
        ), Lotto(listOf(2, 3, 4, 5, 6, 7)), 9,
        EnumMap(mapOf(Winner.THIRD_GRADE to 1, Winner.FOURTH_GRADE to 1, Winner.FIFTH_GRADE to 1))
    )
    val WINNING_MAP_ARGUMENT_EXAMPLE_THIRD: Arguments = Arguments.of(
        listOf(
            Lotto(listOf(2, 3, 4, 5, 10, 11)), // 4등 : Winner.FOURTH_GRADE
            Lotto(listOf(2, 3, 4, 11, 12, 13)), // 5등 : Winner.FIFTH_GRADE
            Lotto(listOf(2, 3, 18, 25, 38, 44)), // 당첨되지 않음.
        ), Lotto(listOf(2, 3, 4, 5, 6, 7)), 9,
        EnumMap(mapOf(Winner.FOURTH_GRADE to 1, Winner.FIFTH_GRADE to 1))
    )

    // TestArguments :: LottoServiceTest - getEarningRate - 수익률 검증
    val EARNING_RATE_EXAMPLE_FIRST: Arguments = Arguments.of(
        EnumMap(mapOf<Winner, Int>(Winner.FIFTH_GRADE to 1)), 8000, 62.5
    )
    val EARNING_RATE_EXAMPLE_SECOND: Arguments = Arguments.of(
        EnumMap(mapOf<Winner, Int>(Winner.FIRST_GRADE to 1)), 1000, 200000000.0
    )
    val EARNING_RATE_EXAMPLE_THIRD: Arguments = Arguments.of(
        EnumMap(mapOf<Winner, Int>(Winner.SECOND_GRADE to 1)), 3000000, 1000.0
    )
}