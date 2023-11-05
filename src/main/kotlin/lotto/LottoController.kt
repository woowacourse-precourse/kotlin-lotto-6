package lotto

//사용자 입력을 받아 모델에 전달하고, 모델로부터 받은 결과를 뷰에 전달합니다. 뷰와 모델을 연결하는 역할을 합니다.
class LottoController(private val lottoView: LottoView,private val lotto: Lotto) {
}