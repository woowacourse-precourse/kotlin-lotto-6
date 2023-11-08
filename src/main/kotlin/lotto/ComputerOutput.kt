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

    fun winLotto(lottoResult: MutableList<List<Int>>) {
        var nums: MutableList<Int> = mutableListOf(0,0,0,0,0)
        for (i in 0 until lottoResult.size) {
            if (lottoResult[i][0] == 3) nums[0] += 1
            if (lottoResult[i][0] == 4) nums[1] += 1
            if (lottoResult[i][0] == 5) nums[2] += 1
            if (lottoResult[i][0] == 5 && lottoResult[i][1] == 1) nums[3] += 1
            if (lottoResult[i][0] == 6) nums[4] += 1
        }

        var m: String = "3개 일치 (5,000원) - ${nums[0]}개\n" +
                "4개 일치 (50,000원) - ${nums[1]}개\n" +
                "5개 일치 (1,500,000원) - ${nums[2]}개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - ${nums[3]}개\n" +
                "6개 일치 (2,000,000,000원) - ${nums[4]}개"
        println(m)
    }

    fun staticLotto(money: Int, lotto: Int) {
        var profit: Double = ((lotto.toDouble() / money.toDouble()) * 100)
        var m = "총 수익률은 ${profit}%입니다."
        println(m)
    }
}