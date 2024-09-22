package kadirsametseki.rent_a_car.dto.response.create

import kadirsametseki.rent_a_car.model.StateType
import java.math.BigDecimal

data class CreateCarResponse(
    val id: Long?,
    val modelId: Long?,
    val modelYear: Int?,
    val plate: String?,
    val state: StateType?,
    val dailyPrice: BigDecimal?
)