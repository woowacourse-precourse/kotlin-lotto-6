package lotto.store.machine

interface Machine {
    // 랜던 로또 리스트를 만듬
    fun makeRandomLotto(count: Int): List<List<Int>>

    // 입력받은 리스트의 당첨 여부과 수익률을 계산한다
    fun calculateWinResult(lottoList: List<List<Int>>, winNumber: List<Int>, bonusNumber: Int): Float
}