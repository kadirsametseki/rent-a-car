package kadirsametseki.rent_a_car.dto.response.get

import kadirsametseki.rent_a_car.dto.response.BrandModelResponse

data class GetBrandResponse(
    val id: Long?,
    val name: String?,
    val models: List<BrandModelResponse>
)
