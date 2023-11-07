package lotto.validator.string

class PurchaseAmountValidator(
    private val numericValidator: StringValidator = NumericValidator(),
    private val divideThousandValidator: StringValidator = DivideThousandValidator()
) : StringValidator {
    override fun validate(value: String) {
        numericValidator.validate(value)
        divideThousandValidator.validate(value)
    }
}