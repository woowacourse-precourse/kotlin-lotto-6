package lotto.domain

class Prize(val money: Int) {
    init {
        require(money >= 0) {
            "상금은 음수일 수 없습니다."
        }
    }

    override fun toString(): String = "%,d원".format(money)
}