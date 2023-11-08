package lotto

class ComputerOutput {
    fun takeOrder() {
        var m: String = "구입 금액을 입력해주세요."
        println(m)
    }

    fun theNumPurchased(num: Int) {
        var m: String = "${num}개를 구매했습니다."
        println(m)
    }

    fun purchasedLotto(nums: List<Int>) {
        println(nums)
    }

    fun askWinNum() {
        var m: String = "당첨 번호를 입력해 주세요."
        println(m)
    }

    fun askBonNum() {
        var m: String = "보너스 번호를 입력해 주세요."
        println(m)
    }

    fun winLotto(nums: List<Int>) {
        var m: String = "3개 일치 (5,000원) - ${nums[0]}개" +
                "4개 일치 (50,000원) - ${nums[1]}개" +
                "5개 일치 (1,500,000원) - ${nums[2]}개" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - ${nums[3]}개" +
                "6개 일치, (2,000,000,000원) - ${nums[4]}개"
        println(m)
    }

    fun staticLotto(money: Int, lotto: Int) {
        var profit: Long = ((lotto / money) * 100).toLong()
        var m: String = "총 수익률은 ${profit}%입니다."
    }
}