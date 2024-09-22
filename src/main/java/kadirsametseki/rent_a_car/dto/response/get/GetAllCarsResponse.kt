package kadirsametseki.rent_a_car.dto.response.get

import kadirsametseki.rent_a_car.model.StateType
import java.math.BigDecimal

data class GetAllCarsResponse(
    val id: Long?,
    val modelYear: Int?,
    val plate: String?,
    val state: StateType? = StateType.AVAILABLE,
    val dailyPrice: BigDecimal?,
)