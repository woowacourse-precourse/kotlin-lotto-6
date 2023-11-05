package lotto

fun main() {
    val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6)) // 예시로 넣은 숫자, 실제로는 사용자 입력이나 랜덤 생성 등을 활용합니다.
    val lottoView = LottoView()
    val lottoController = LottoController(lottoView, lotto)

    lottoController.generateLottoTickets(8000)
}

