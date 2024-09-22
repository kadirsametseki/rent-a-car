package kadirsametseki.rent_a_car.dto.request.create

import java.math.BigDecimal

data class CreateCarRequest(
    val modelId: Long,
    val modelYear: Int,
    val plate: String,
    val dailyPrice: BigDecimal
)