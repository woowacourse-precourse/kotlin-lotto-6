package lotto.exception

enum class MatchCountException(val message: String) {
    NOT_POSITIVE_NUMBER("[ERROR] 당첨 횟수는 음수가 될 수 없습니다.")
}