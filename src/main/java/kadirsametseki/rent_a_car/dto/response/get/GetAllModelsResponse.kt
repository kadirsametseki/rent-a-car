package kadirsametseki.rent_a_car.dto.response.get

import kadirsametseki.rent_a_car.dto.response.ModelBrandResponse

data class GetAllModelsResponse(
    val id: Long?,
    val name: String?,
    val brand: ModelBrandResponse?,
    val cars: List<GetAllCarsResponse>?
)