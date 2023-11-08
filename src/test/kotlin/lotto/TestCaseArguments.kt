package lotto

import lotto.model.Lotto
import lotto.model.LottoRank
import org.junit.jupiter.params.provider.Arguments

object TestCaseArguments {

    val CLASSIFY_LOTTO_TEST_CASE_SUCCESS: Arguments = Arguments.of(
        listOf(
            Lotto(listOf(8, 21, 23, 41, 42, 43)),
            Lotto(listOf(3, 5, 11, 16, 32, 38)),
            Lotto(listOf(7, 11, 16, 35, 36, 44)),
            Lotto(listOf(1, 8, 11, 31, 41, 42)),
            Lotto(listOf(13, 14, 16, 38, 42, 45)),
            Lotto(listOf(7, 11, 30, 40, 42, 43)),
            Lotto(listOf(2, 13, 22, 32, 38, 45)),
            Lotto(listOf(1, 3, 5, 14, 22, 45)),
        ),
        Lotto(listOf(1, 2, 3, 4, 5, 6)),
        7,
        mapOf(
            Pair(LottoRank.FIFTH_RANK, 1),
            Pair(LottoRank.FOURTH_RANK, 0),
            Pair(LottoRank.THIRD_RANK, 0),
            Pair(LottoRank.SECOND_RANK, 0),
            Pair(LottoRank.FIRST_RANK, 0),
        )
    )

    val CLASSIFY_LOTTO_TEST_CASE_FAIL_BONUS_NOT_INIT: Arguments = Arguments.of(
        listOf(
            Lotto(listOf(8, 21, 23, 41, 42, 43)),
            Lotto(listOf(3, 5, 11, 16, 32, 38)),
            Lotto(listOf(7, 11, 16, 35, 36, 44)),
            Lotto(listOf(1, 8, 11, 31, 41, 42)),
            Lotto(listOf(13, 14, 16, 38, 42, 45)),
            Lotto(listOf(7, 11, 30, 40, 42, 43)),
            Lotto(listOf(2, 13, 22, 32, 38, 45)),
            Lotto(listOf(1, 3, 5, 14, 22, 45)),
        ),
        Lotto(listOf(1, 2, 3, 4, 5, 6)),
        -1,
        mapOf(
            Pair(LottoRank.FIFTH_RANK, 1),
            Pair(LottoRank.FOURTH_RANK, 0),
            Pair(LottoRank.THIRD_RANK, 0),
            Pair(LottoRank.SECOND_RANK, 0),
            Pair(LottoRank.FIRST_RANK, 0),
        )
    )
    val CLASSIFY_LOTTO_TEST_CASE_FAIL_LOTTO_LIST_NOT_INIT: Arguments = Arguments.of(
        listOf<Lotto>(),
        Lotto(listOf(1, 2, 3, 4, 5, 6)),
        7,
        mapOf(
            Pair(LottoRank.FIFTH_RANK, 1),
            Pair(LottoRank.FOURTH_RANK, 0),
            Pair(LottoRank.THIRD_RANK, 0),
            Pair(LottoRank.SECOND_RANK, 0),
            Pair(LottoRank.FIRST_RANK, 0),
        )
    )

    val CHECK_LOTTO_TEST_CASE_SUCCESS_FIFTH: Arguments = Arguments.of(
        Lotto(listOf(1, 3, 5, 14, 22, 45)),
        Lotto(listOf(1, 2, 3, 4, 5, 6)),
        7,
        LottoRank.FIFTH_RANK
    )
    val CHECK_LOTTO_TEST_CASE_SUCCESS_FOURTH: Arguments = Arguments.of(
        Lotto(listOf(1, 8, 11, 31, 41, 42)),
        Lotto(listOf(1, 5, 11, 31, 41, 44)),
        7,
        LottoRank.FOURTH_RANK
    )
    val CHECK_LOTTO_TEST_CASE_SUCCESS_THIRD: Arguments = Arguments.of(
        Lotto(listOf(2, 13, 22, 32, 42, 45)),
        Lotto(listOf(2, 9, 22, 32, 42, 45)),
        7,
        LottoRank.THIRD_RANK
    )
    val CHECK_LOTTO_TEST_CASE_SUCCESS_SECOND: Arguments = Arguments.of(
        Lotto(listOf(7, 11, 16, 35, 36, 44)),
        Lotto(listOf(5, 11, 16, 35, 36, 44)),
        7,
        LottoRank.SECOND_RANK
    )
    val CHECK_LOTTO_TEST_CASE_SUCCESS_FIRST: Arguments = Arguments.of(
        Lotto(listOf(8, 21, 23, 41, 42, 43)),
        Lotto(listOf(8, 21, 23, 41, 42, 43)),
        7,
        LottoRank.FIRST_RANK
    )
    val CHECK_LOTTO_TEST_CASE_FAIL_BONUS_NOT_INIT: Arguments = Arguments.of(
        Lotto(listOf(8, 21, 23, 41, 42, 43)),
        Lotto(listOf(8, 21, 23, 41, 42, 43)),
        -1,
        LottoRank.FIRST_RANK
    )
    val SUM_LOTTO_TEST_CASE_SUCCESS: Arguments = Arguments.of(
        mapOf(
            Pair(LottoRank.FIFTH_RANK, 5),
            Pair(LottoRank.FOURTH_RANK, 4),
            Pair(LottoRank.THIRD_RANK, 3),
            Pair(LottoRank.SECOND_RANK, 2),
            Pair(LottoRank.FIRST_RANK, 1),
        ),
        2064725000
    )
}