package kadirsametseki.rent_a_car.dto.request.update

import kadirsametseki.rent_a_car.model.StateType
import java.math.BigDecimal

data class UpdateCarRequest(
    val modelId: Long,
    val modelYear: Int,
    val plate: String,
    val state: StateType,
    val dailyPrice: BigDecimal
)