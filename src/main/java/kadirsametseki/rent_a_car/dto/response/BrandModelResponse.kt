package kadirsametseki.rent_a_car.dto.response

import kadirsametseki.rent_a_car.dto.response.get.GetAllCarsResponse

data class BrandModelResponse(
    val id: Long,
    val name: String,
    val cars: List<GetAllCarsResponse>?
)
