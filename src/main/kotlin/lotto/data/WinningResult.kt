package lotto.data

/**
 * 당첨 결과 클래스
 *
 * GameViewer 에서 당첨 결과 출력에 사용된다.
 * 각 케이스별 당첨 개수와 수익률에 대한 정보를 가진다.
 */
data class WinningResult(
    val winningCounts: List<Int>,
    val margin: Double
)
