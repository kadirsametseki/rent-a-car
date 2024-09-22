package kadirsametseki.rent_a_car.dto.response.get

import kadirsametseki.rent_a_car.model.StateType
import java.math.BigDecimal

data class GetCarResponse(
    val id: Long?,
    val modelId: Long?,
    val modelYear: Int?,
    val plate: String?,
    val state: StateType?,
    val dailyPrice: BigDecimal?,
    val modelName: String?,
    val modelBrandName: String?
)